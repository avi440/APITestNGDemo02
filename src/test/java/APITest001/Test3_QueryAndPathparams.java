package APITest001;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;


public class Test3_QueryAndPathparams {
	
	@Test
	void QueryAndPathparams() {
	given()
		.pathParam("myPath", "users")// Path params
		.queryParam("page",2) // queryParam
		.queryParam("id",7)
	
	.when()  
	.get("https://reqres.in/api/{myPath}")
	.then()
	.statusCode(200)
//		.body("page",equalTo(2))
//	.assertThat().body("name", equalTo(randomName))
	.log().all();
	}

}
