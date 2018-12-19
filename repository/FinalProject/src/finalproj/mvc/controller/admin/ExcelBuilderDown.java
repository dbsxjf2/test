package finalproj.mvc.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import finalproj.dto.CplistVO;



@SuppressWarnings("deprecation")
public class ExcelBuilderDown extends AbstractExcelView{
	// excelView �並 ã����, �̰��� ���� Ŭ���� ExcelBuilder �� AbstractExcelView�� ��� �߱� ������ �̰��� �� �̴�.
	// DispatcherServlet -> [view]jsp (model) : forward
	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// HSSF : ����ũ�� ����Ʈ�� ���� ���� Ŭ����
		// DispatcherServlet �� ���ؼ� Model�� �޴´�.
		// ${listBooks}
		List<CplistVO> listBooks = (List<CplistVO>) model.get("cplist");
		// poi ����
		HSSFSheet sheet = workbook.createSheet("show list");
		sheet.setDefaultColumnWidth(30);
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		HSSFRow header = sheet.createRow(0);
		
		//������ �� Ÿ��Ʋ
		String[] str = {"�����ȣ","����̸�","�����ġ","�з�","ä�����"};
		for(int i =0; i<str.length; i++) {
			header.createCell(i).setCellValue(str[i]);
			header.getCell(i).setCellStyle(style);
		}
		int rowCount = 1;
		for(CplistVO book : listBooks) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			aRow.createCell(0).setCellValue(book.getCpnum());
			aRow.createCell(1).setCellValue(book.getCpname());
			aRow.createCell(2).setCellValue(book.getCploc());
			aRow.createCell(3).setCellValue(book.getKeyword());
			aRow.createCell(4).setCellValue(book.getCplink());
		}
		//  ���䰴ü�� ���� �ٿ�ε� ���� Ÿ�԰� ���� �̸��� �����Ѵ�.
		response.setContentType("Application/Msexcel");
		response.setHeader("Content-Disposition", "attachment; filenname=�������Ʈ.xls"); 
	}

}
