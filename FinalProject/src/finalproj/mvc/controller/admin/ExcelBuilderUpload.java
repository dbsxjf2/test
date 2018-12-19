package finalproj.mvc.controller.admin;

import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


@SuppressWarnings("resource")
public class ExcelBuilderUpload{

	protected String readExcel(String path, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ������ �б����� ���������� �����´�
		String filepath = path;
		System.out.println("ExcelPath :::" + filepath);
		FileInputStream fis = new FileInputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int columnindex = 0;
		String[] columnname = {"cpnum","cpname","cploc","keyword","cplink"};
		// ��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		// ���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		HSSFSheet sheet = workbook.getSheetAt(0);
		// ���� ��
		int rows = sheet.getPhysicalNumberOfRows();
		StringBuffer sb = new StringBuffer();
		for (rowindex = 1; rowindex < rows; rowindex++) {
			// ���� �д´�
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// ���� ��
				int cells = row.getPhysicalNumberOfCells();
				for (columnindex = 0; columnindex <= cells; columnindex++) {
					// ������ �д´�
					HSSFCell cell = row.getCell(columnindex);
					String value = "";
					// ���� ���ϰ�츦 ���� ��üũ
					if (cell == null) {
						continue;
					} else {
						// Ÿ�Ժ��� ���� �б�
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						}
					}
					if(columnindex == 0) {
						sb.append("{");
					}
					
					sb.append("\"").append(columnname[columnindex]).append("\":\"").append(value).append("\"");
					
					if(columnindex == 4) {
						sb.append("},");
					}else {
						sb.append(",");
					}
						System.out.println("�� �� ���� :" + sb.toString());
					
				}
			}
		}
		return sb.toString();
	}
}
