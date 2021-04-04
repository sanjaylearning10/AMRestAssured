package apitesting.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostRequest {

	public static void main(String[] args) {
		RequestSpecification requestSpecification= RestAssured.given().log().all();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
		requestSpecification.basePath("booking");
		requestSpecification.body("{\r\n    \"firstname\" : \"Kanishk\",\r\n    \"lastname\" : \"Chandel\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}");
		//requestSpecification.contentType("application/json;");
		requestSpecification.contentType(ContentType.JSON);
		Response response= requestSpecification.post();
		//ValidatableResponse validateResponse=response.then().log().all();
		ValidatableResponse validateResponse=response.then().log().all();
		//validateResponse.statusCode(300);
		validateResponse.statusCode(200);
	}

}
