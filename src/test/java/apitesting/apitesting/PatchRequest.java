package apitesting.apitesting;

import io.restassured.RestAssured;

public class PatchRequest {

	public static void main(String[] args) {
		RestAssured.given().log().all().
		baseUri("https://restful-booker.herokuapp.com").basePath("booking/1").
		header("Content-Type", "application/json").header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=").
		body("{\r\n    \"firstname\" : \"sanjay\",\r\n    \"lastname\" : \"Brown\"\r\n}").
		when().patch().then().log().all();

	}

}
