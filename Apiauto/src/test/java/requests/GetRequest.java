package requests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	@Test
	public void get(){
	RestAssured.
	     given()
	            .baseUri("https://reqres.in/").
	   
	     when()
	           .get("api/users?page=2").
	           
	      then()
	           .statusCode(200)    
	           .contentType("application/json")
	           .log().all();
	
	
}

}
