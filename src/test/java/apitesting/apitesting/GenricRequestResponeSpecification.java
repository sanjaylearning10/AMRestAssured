package apitesting.apitesting;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GenricRequestResponeSpecification {

	public static void main(String... args) {

		ResponseSpecification responseSpecification;
		RequestSpecification requestSpecification;

		requestSpecification = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.body("{\r\n    \"firstname\" : \"Jim\",\r\n    \"lastname\" : \"Brown\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}")
				.contentType(ContentType.JSON);

		responseSpecification = RestAssured.expect();
		responseSpecification.contentType(ContentType.JSON).statusCode(200).time(Matchers.lessThan(5000L));

		RestAssured.given(requestSpecification, responseSpecification).post().then().log().all();
	}

}
