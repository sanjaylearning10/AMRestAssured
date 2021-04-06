package apitesting.apitesting;

import io.restassured.RestAssured;

public class PathParameter {

	public static void main(String[] args) {
		RestAssured.given().
		log().all().baseUri("https://restful-booker.herokuapp.co").
		basePath("{basepath}/{bookingID}").pathParam("basepath","booking").pathParam("bookingID", 11).
		when().get().
		then().log().all();

	}

}
