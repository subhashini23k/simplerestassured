package Tests;

import org.testng.annotations.DataProvider;

public class DataForTest  {
	@DataProvider(name="post data")
	public Object[][] dataForPost(){

		Object[][] data =new Object[2][7];

		data[0][0] ="232321";
		data[0][1] = "SDET-16";
		data[0][2] = "T-mobile";
		data[0][3] = "CA";
		data[0][4] = "Full time";
		data[0][5] = "SDET";
		data[0][6] =  "10 mins back";

		data[1][0] ="090934";
		data[1][1] = "SDET-16";
		data[1][2] = "Apple";
		data[1][3] = "CA";
		data[1][4] = "Full time";
		data[1][5] = "QA-Automation-Engineer";
		data[1][6] =  "6 mins back";

		return data;
	}
	@DataProvider(name="Put data")
	public Object[][] PutData() {

		Object[][] data =new Object[2][2];
		data[0][0] = "232321";
		data[0][1]="SDET-16_PUT";

		data[1][0] = "090934";
		data[1][1] ="PUT-SDET";

		return data;

	}
	@DataProvider(name="delete data")
	public Object[] DeleteData() {
		Object[] data =new Object[2];
		data[0] = "232321";
		data[1] = "090934";
		return data;
		}
}
