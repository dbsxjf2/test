package finalproj.mvc.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finalproj.dto.ResumeVO;
import finalproj.mvc.dao.AdminDao;

@RestController
@RequestMapping("/feedback")
public class FeedBackRestController {
	@Autowired
	AdminDao dao;
	
	// �ǵ�鿡 ���� ����
	@RequestMapping(value = "/company_content")
	public Map<String, String> edu_company_content(int cpfnum) {
		String content = dao.fback_contentView(cpfnum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("content", content);
		System.out.println(content);
		return map;
	}

	// �ǵ�鿡 ���� ���� * restJS�� �ٲ� ����
	@RequestMapping(value = "/resume_file")
	public List<ResumeVO> edu_resume_fileview(int snum) {
		List<ResumeVO> rlist = dao.fback_Resume_fileview(snum);
		return rlist;
	}
}
