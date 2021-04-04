package apitesting.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PostRequestRefactor {

	public static void main(String[] args) {
		//RequestSpecification requestSpecification= RestAssured.given().log().all();
		//RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/");
		//RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking");
		//RestAssured.given().log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("booking").body("{\r\n    \"firstname\" : \"Jim\",\r\n    \"lastname\" : \"Brown\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}");
		//requestSpecification.contentType("application/json");
		//Response response= requestSpecification.post();
		//ValidatableResponse validateResponse=response.then().log().all();
		//ValidatableResponse validateResponse=response.then().log().all();
		//validateResponse.statusCode(300);
		//validateResponse.statusCode(200);
	
		RestAssured.
		given().
		log().
		all().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		body("{\r\n    \"firstname\" : \"Jim\",\r\n    \"lastname\" : \"Brown\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}").
		contentType(ContentType.JSON).
		post().
		then().
		log().
		all().
		statusCode(200);
		
		
	}

}
