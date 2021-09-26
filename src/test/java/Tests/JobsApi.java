package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.TestBase;
import Utils.TestUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JobsApi extends TestBase {
	
	@BeforeMethod
	public void setUp(){
		TestBase.init();
	}
	
	@DataProvider
	public Object[][] getData() throws InvalidFormatException{
		Object testData[][] = TestUtils.getDataFromSheet(TestUtils.JobsSheet);
		return testData;
	}

	@Test(priority=1)
	public void getjobs() {
		RestAssured.baseURI=Properties.getProperty("baseURI");

		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.get(baseURI)
		.then()
		.statusCode(200);	
		
	}
	
	
	@Test (priority=2 , dataProvider="getData")
	public void CreateJob(String JobId,String JobTitle,String JobCompanyName,String JobLocation , String JobType,String JobDescription,String JobPostedtime) {

		RestAssured.baseURI=Properties.getProperty("baseURI");
		JSONObject request = new JSONObject();
		request.put("Job Id",JobId);
		request.put("Job Title",JobTitle );
		request.put("Job Company Name",JobCompanyName);
		request.put("Job Location", JobLocation);
		request.put("Job Type",JobType);
		request.put("Job Description", JobDescription);
		request.put("Job Posted time",JobPostedtime);

		System.out.println(request);

		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post(baseURI)
		.then()
		.statusCode(200);
	}


}
