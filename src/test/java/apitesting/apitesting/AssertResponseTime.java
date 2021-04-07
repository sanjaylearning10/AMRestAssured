package apitesting.apitesting;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AssertResponseTime {

	public static void main(String[] args) {
		Response Response = RestAssured.given().baseUri("https://restful-booker.herokuapp.com/").basePath("booking")
				.body("{\r\n    \"firstname\" : \"Jim\",\r\n    \"lastname\" : \"Brown\",\r\n    \"totalprice\" : 111,\r\n    \"depositpaid\" : true,\r\n    \"bookingdates\" : {\r\n        \"checkin\" : \"2018-01-01\",\r\n        \"checkout\" : \"2019-01-01\"\r\n    },\r\n    \"additionalneeds\" : \"Breakfast\"\r\n}")
				.contentType(ContentType.JSON).post();

		long responsetime = Response.time();
		System.out.println("responsetime " + responsetime);

		long responsetime1 = Response.timeIn(TimeUnit.SECONDS);
		System.out.println("responsetime1 " + responsetime1);

		long responsetime2 = Response.getTime();
		System.out.println("responsetime2 " + responsetime2);

		long responsetime3 = Response.getTimeIn(TimeUnit.SECONDS);
		System.out.println("responsetime3 " + responsetime3);

		Response.then().time(Matchers.lessThan(5000L));

		Response.then().time(Matchers.both(Matchers.greaterThan(2000L)).and(Matchers.lessThan(5000L)));

	}

}
