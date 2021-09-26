package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

public class ExcelUtils {
	//Static class variable can be referred in any functions of this class
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;
	//This is constructor.Constructor is always called when we instantiate a class,
	//when we create an object for class using new key word
	
	
	public ExcelUtils(String excelpath,String Sheetname) {
		try {

			workBook = new XSSFWorkbook(excelpath);
			sheet=workBook.getSheet(Sheetname);  


		} catch (IOException exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}


	}
	
	public static void getcellData(int rowNum,int ColNum) {

		DataFormatter formatter=new DataFormatter();
		Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(ColNum));
		System.out.println("values of the cell : "+value);

	}

	public static void getRowCount() {
	
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows "+rowcount);

	}

}
