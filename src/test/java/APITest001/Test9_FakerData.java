package APITest001;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test9_FakerData {

	// https://github.com/DiUS/java-faker  --> go this site u can see dependency and ALl info
	
	@Test
	void fakerTest() {
	Faker faker = new Faker();

	String name = faker.name().fullName(); // Miss Samanta Schmidt
	String firstName = faker.name().firstName(); // Emory
	String lastName = faker.name().lastName(); // Barton

	String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
	
	String pass = faker.internet().password();
	String phone = faker.phoneNumber().cellPhone();//you can give range also
	String mail = faker.internet().safeEmailAddress();
	
	
	System.out.println("name: "+name);
	System.out.println("firstName: "+firstName);
	System.out.println("lastName: "+lastName);
	System.out.println("streetAddress: "+streetAddress);
	System.out.println("pass: "+pass);
	System.out.println("phone: "+phone);
	System.out.println("mail: "+mail);
	}
}
