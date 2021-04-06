package apitesting.apitesting;

import io.restassured.RestAssured;

public class InLineParameter3 {

	public static void main(String[] args) {
		
		
		//Request URI:	https://restful-booker.herokuapp.co/booking/11 
		RestAssured.given().
		log().all().pathParam("basepath1","booking").
		when().get("https://restful-booker.herokuapp.com/{basepath}/{bookingID}","booking",11).
		then().log().all();
		
		
	}

}
