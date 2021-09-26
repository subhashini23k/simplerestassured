package Utils;

public class ExcelUtilsTest  {
 public static void main(String[] args) {
	 
	 String excelPath= "/SimpleRest/src/test/resources/Data/Testdata.xlsx";
	 String sheetName = "Sheet1";
	 ExcelUtils excel= new ExcelUtils(excelPath, sheetName);
	 excel.getRowCount();
	 excel.getcellData(1,0);
	 excel.getcellData(1,1);

	 excel.getcellData(1,2);

	 
	 excel.getcellData(1,3);
	 excel.getcellData(1,4);

	 
	
}
}
