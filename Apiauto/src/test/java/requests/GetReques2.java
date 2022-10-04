package requests;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;
import static org.hamcrest.Matchers.*;


public class GetReques2 {
	@Test
	public void test() {
		given()
		    .get("https://reqres.in/api/users?page=2").
		
		then()
		     .statusCode(200)
		     .body("data.id[0]", equalTo(7));
		
		
		
	}

}
