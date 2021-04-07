package apitesting.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GenricRequestSpecification {

	public static void main(String[] args) {
		RequestSpecification requestSpecification;
		requestSpecification=RestAssured.given().
		baseUri("https://restful-booker.herokuapp.com/").
		basePath("booking").
		contentType(ContentType.JSON);
		
		
		RestAssured.given().spec(requestSpecification).
		body("{\r\n    \"firstname\" : \"Jim\",\r\n    \"lastname\" : \"Brown\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}").
		when().post().then().log().all().assertThat().statusCode(200);
	}

}
