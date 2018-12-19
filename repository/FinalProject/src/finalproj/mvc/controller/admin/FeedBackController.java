package finalproj.mvc.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import finalproj.dto.CpfeedVO;
import finalproj.dto.ResumeVO;
import finalproj.mvc.dao.AdminDao;

@Controller
public class FeedBackController {

	@Autowired
	private AdminDao dao;

	// ---- Edu_resume.jsp start ----
	// �̷¼� ��û ����Ʈ View(Edu_resume.jsp ȭ��)
	@RequestMapping(value = "/resume")
	public String edu_resume(Model model) {
		List<Map<String, Object>> list = dao.fback_Resume();
		model.addAttribute("list", list);

		return "Edu_Resume";
	}

	// resume ���� ���ε�
	// rnum(�̷¼� ���̺��� pk)�� ���� mfile(�̷¼� ���̺��� rfile)�� ���� �Ķ��Ÿ ������ �޾�
	// ������ ��ο� ������ ���ε� ��Ű�� DB�� �����ϴ� �����̴�.
	@PostMapping(value = "rfile_upload")
	public String rfile_upload(@RequestParam("rnum") int rnum, @RequestParam("mfile") MultipartFile mfile, Model model,
			HttpServletRequest request) {
		// ������ ��η� ������ ����
		String file_path = "resources\\upload\\";
		String r_path = request.getRealPath("/");
		// ���ϸ�
		String oriFn = mfile.getOriginalFilename();
		String contentType = mfile.getContentType();
		StringBuffer path = new StringBuffer();
		path.append(r_path).append(file_path);
		path.append(oriFn);
		System.out.println(path);
		File f = new File(path.toString());
		System.out.println(f.exists());

		// ���� ���ε� ����
		try {
			mfile.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("fileName", oriFn);
		// ----���� ���ε� ���� End-----

		// ---- DB���̺� update ���� -----
		ResumeVO rvo = new ResumeVO();
		rvo.setRfile(oriFn);
		rvo.setRnum(rnum);
		dao.rfile_up(rvo);
		// ---- DB���̺� update ���� -----
		return "redirect:resume";
	}
	// ---- Edu_resume.jsp end -----

	// ---- Edu_Company.jsp start ----
	// �л����� ���ɱ�� �ǵ��
	@RequestMapping(value = "/company")
	public String edu_company(Model model) {
		List<Map<String, Object>> list = dao.fback_CompanyList();
		model.addAttribute("list", list);
		return "Edu_Company";
	}
	// ---- Edu_Company.jsp end ----

	// ---- Edu_Company_Write.jsp start ----
	// �л����� ���ɱ�� �ǵ�� �󼼺���
	@RequestMapping(value = "/company_write")
	public String edu_company_write(Model model, int cpfnum) {
		String content = dao.fback_contentView(cpfnum);
		model.addAttribute("cpfnum", cpfnum);
		model.addAttribute("content", content);
		return "Edu_Company_Write";
	}

	// �ǵ�鿡 ���� ���� ���ε� �� �л����� ���ɱ�� ����Ʈ�� �Ѿ�� �Լ�
	@RequestMapping(value = "/company_upload")
	public String edu_company_upload(Model model, int cpfnum, String content) {
		CpfeedVO cpfvo = new CpfeedVO();
		cpfvo.setCpfnum(cpfnum);
		cpfvo.setCpfcontent(content);
		dao.fback_up(cpfvo);
		return "redirect:company";
	}
	// ---- Edu_Company_Write.jsp end ----

	// ---- ���� �ٿ�ε� �޼��� Start ----
	// ������ ũ�� ����
	private static final int BUFFER_SIZE = 4096;

	// ���� �ٿ�ε�
	@RequestMapping(value = "/fileDown")
	public void fileDown(@RequestParam("fileName") String fileName, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// applicationContext ��ü�� request�� ���� ��
		ServletContext context = request.getServletContext();
		// ���ε�� ��� ����
		String path = session.getServletContext().getRealPath("/resources/upload/") + fileName;
		System.out.println(path);
		// �� ��η� ���� ��ü�� ����
		File downloadFile = new File(path);
		// FileInputStream ��Ʈ������ �о��
		FileInputStream fi = new FileInputStream(downloadFile);
		// ��û ��ü�κ��� ����� �������� ����Ÿ���� ��
		String mimeType = context.getMimeType(path);
		System.out.println(mimeType);
		// ���� ����Ÿ�԰��� ������ �׳� ����Ʈ�� ��Ʈ������ ����
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		// ������ ����Ÿ�� ����
		response.setContentType(mimeType);
		// �ٿ�ε� �� ������ ���� ����
		response.setContentLength((int) downloadFile.length());
		// �ٿ�ε� Type�� ������
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		System.out.println(headerValue);
		// ���� �ٿ�ε� Ÿ���� ������ �ش��� ����
		response.setHeader(headerKey, headerValue);
		// �������κ��� ��Ʈ���� ����
		OutputStream outStream = response.getOutputStream();
		// ���۸� ������ ������ ���� ����
		byte[] buffer = new byte[BUFFER_SIZE];
		// ���� �������� ������, �ڿ� ������ ��
		int bytesRead = -1;
		while ((bytesRead = fi.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		fi.close();
		outStream.close();
	}
	// ---- ���� �ٿ�ε� �޼��� End ----

}
