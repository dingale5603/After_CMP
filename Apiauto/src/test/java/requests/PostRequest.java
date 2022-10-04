package requests;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostRequest {
@Test
	public void post() {
	    
		JSONObject reqbody=new JSONObject();
		reqbody.put("name", "rekha");
		reqbody.put("job", "housewife");
		 
		RestAssured 
		   .given()
		          .baseUri("https://reqres.in/")
		          .body(reqbody.toJSONString())
		          .accept(ContentType.JSON)
		          .header("ContentType","application/json")
		          
		   .when()
		        . post("api/users")
		   .then()
		        .statusCode(201)
		        .log().all()
		        .contentType("application/json");
	}
}
