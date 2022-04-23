package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {
		// TODO Auto-generated constructor stub
		XSSFSheet sheet;

	public ExcelRead1() throws IOException {

		FileInputStream file = new FileInputStream("C:\\Program Files\\Java\\Book.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet("Sheet1");

	}

	public String readData(int i, int j) {

		Row row = sheet.getRow(i);
		Cell cell = row.getCell(j);
		CellType type = cell.getCellType();

		switch (type) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());

		case STRING:
			return cell.getStringCellValue();
		}
		return null;
	}

	public int rowsize() {
		return sheet.getLastRowNum() + 1;
	}
}