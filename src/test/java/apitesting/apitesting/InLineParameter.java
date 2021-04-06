package apitesting.apitesting;

import io.restassured.RestAssured;

public class InLineParameter {

	public static void main(String[] args) {
		RestAssured.given().
		log().all().baseUri("https://restful-booker.herokuapp.com").
		basePath("{basepath}/{bookingID}").pathParam("basepath","booking").pathParam("bookingID", 11).
		when().get("https://restful-booker.herokuapp.com/{basepath}/{bookingID}","booking",11).
		then().log().all();

	}

}
