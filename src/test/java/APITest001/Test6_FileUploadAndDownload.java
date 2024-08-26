package APITest001;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Test6_FileUploadAndDownload {
	
	//it'll not work but knowledge
	
	@Test
	void singleFileUpload() 
	{
	    File myfile = new File("C:\\AutomationPractice\\Test1.txt");

	    given()
	        .multiPart("file", myfile)
	        .contentType("multipart/form-data")
	    .when()
	        .post("http://localhost:8080/uploadFile")
	    .then()
	        .statusCode(200)
	        .body("fileName", equalTo("Test1.txt"))
	        .log().all();
	}
	
	@Test
	void multipleFilesUpload()
	{
	    File myfile1 = new File("C:\\AutomationPractice\\Test1.txt");
	    File myfile2 = new File("C:\\AutomationPractice\\Test2.txt");

	    given()
	        .multiPart("files", myfile1)
	        .multiPart("files", myfile2)
	        .contentType("multipart/form-data")
	    .when()
	        .post("http://localhost:8080/uploadMultipleFiles")
	    .then()
	        .statusCode(200)
	        .body("[0].fileName", equalTo("Test1.txt"))
	        .body("[1].fileName", equalTo("Test2.txt"))
	        .log().all();
	    
	}
	
	//Approch22
	
	@Test
	void multipleFilesUpload002()
	{
	    File myfile1 = new File("C:\\AutomationPractice\\Test1.txt");
	    File myfile2 = new File("C:\\AutomationPractice\\Test2.txt");
	    
	    File filer[] = {myfile1,myfile2};

	    given()
	        .multiPart("files", filer)
	        .contentType("multipart/form-data")
	    .when()
	        .post("http://localhost:8080/uploadMultipleFiles")
	    .then()
	        .statusCode(200)
	        .body("[0].fileName", equalTo("Test1.txt"))
	        .body("[1].fileName", equalTo("Test2.txt"))
	        .log().all();
	    
	}
	
	//Approch22
	
		@Test
		void downloadFile()
		{
		 

		    given()
		     
		    .when()
		        .post("http://localhost:8080/uploadMultipleFiles.Test1.txt")
		    .then()
		        .statusCode(200)
		        .log().all();
		    
		}

}
