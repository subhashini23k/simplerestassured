package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class JobsService extends DataForTest {
	

	@Test(priority=1)
	public void GetJobs() {

		baseURI = "https://jobs123.herokuapp.com/Jobs";
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.get(baseURI)
		.then()
		.statusCode(200);		 

	}

	@Test (priority=2 , dataProvider="post data")
	public void CreateJob(String JobId,String JobTitle,String JobCompanyName,String JobLocation , String JobType,String JobDescription,String JobPostedtime) {

		baseURI = "https://jobs123.herokuapp.com/Jobs";
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


	@Test(priority=3,dataProvider="Put data")
	public void UpdateJob(String JobId,String JobTitle) {
		
		baseURI ="https://jobs123.herokuapp.com/Jobs";

		JSONObject req= new JSONObject();
		req.put("Job Id",JobId);
		req.put("Job Title",JobTitle);
		System.out.println(req.toJSONString());

		given()
		.contentType("application/json")
		.body(req.toJSONString())
		.when()
		.put(baseURI)
		.then()
		.statusCode(200);		
	}


	@Test(priority=5,dataProvider="delete data")
	public void DeleteJob(String JobId) {
		baseURI ="https://jobs123.herokuapp.com/Jobs";
		JSONObject req =new JSONObject();
		req.put("Job Id",JobId);
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.delete(baseURI)
		.then()
		.statusCode(200);		

	}
}