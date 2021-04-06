package apitesting.apitesting;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;

public class InLineParameter4 {

	public static void main(String[] args) {
		
		Map<String,Object> pathParameter = new HashMap<String,Object>();
		pathParameter.put("basepath", "booking");
		pathParameter.put("bookingID", "11");
		
		
		RestAssured.given().
		log().all().baseUri("https://restful-booker.herokuapp.com/").basePath("{basepath}/{bookingID}").pathParams(pathParameter).
		when().get("https://restful-booker.herokuapp.com/{basepath}/{bookingID}","booking",11).
		then().log().all();
		
		
	}

}
