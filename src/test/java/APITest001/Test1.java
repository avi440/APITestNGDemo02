package APITest001;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.Test;

public class Test1 {
	
	int id;

	@Test(priority=1)
	void getUsers() {  
		given()
		.when()  
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("page",equalTo(2))
		.log().all();
	}

	@Test(priority=2)
	void createUsers() {  
		HashMap data = new HashMap();
		String randomName =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 8);
		String randomJob =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 5);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%: "+randomName+"&&&&:"+randomJob);
		data.put("name", randomName);
		data.put("job", randomJob);
		id = given()
			.contentType("application/json")
			.body(data)
		.when()  
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
//		.then()
//			.statusCode(201)
//		//		.body("page",equalTo(2))
//			.assertThat().body("name", equalTo(randomName))
//			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods= {"createUsers"})
	void updateUsers() {  
		
		System.out.println("(((((((((((((((((((((("+id);
		HashMap data = new HashMap();
		String randomName =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 8);
		String randomJob =  UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "").substring(0, 5);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%: "+randomName+"&&&&:"+randomJob);
		data.put("name", randomName);
		data.put("job", randomJob);
		given()
			.contentType("application/json")
			.body(data)
		.when()  
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
		//		.body("page",equalTo(2))
			.assertThat().body("name", equalTo(randomName))
			.log().all();
	}
	
	@Test(priority=3, dependsOnMethods= {"createUsers"})
	void deleteUsers() {  
		
		given()

		.when()  
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)	
			.log().all();
		
	}

}
