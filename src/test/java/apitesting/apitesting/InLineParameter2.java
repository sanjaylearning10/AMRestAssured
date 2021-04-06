package apitesting.apitesting;

import io.restassured.RestAssured;

public class InLineParameter2 {

	public static void main(String[] args) {
		
		
		//Request URI:	https://restful-booker.herokuapp.co/booking/booking 
		RestAssured.given().
		log().all().pathParam("basepath","booking").
		when().get("https://restful-booker.herokuapp.com/{basepath}/{bookingID}","booking",11).
		then().log().all();
		
		//when().get("https://restful-booker.herokuapp.com/{basepath}/{bookingID}","booking",11,"sanjay").
		
		//Exception in thread "main" java.lang.IllegalArgumentException: Invalid number of path parameters. Expected 2, was 4. Redundant path parameters are: 11, sanjay.

	}

}
