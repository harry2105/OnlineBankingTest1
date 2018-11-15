import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredPut {
	
	 @Test
	    public void validate_response_headers_test() {
	        RestAssured.baseURI = "https://reqres.in";
	        RequestSpecification httpRequest = RestAssured.given();
	        httpRequest.header("Content-Type", "application/json");
	        // Create new JSON Object
	       // httpRequest.formParam("name", "morphus");
	        JsonObject data = new JsonObject();
	        data.addProperty("name", "morpheus");
	        data.addProperty("job", "zion resident");
	        httpRequest.body(data.toString());
	        Response response = httpRequest.put("/api/users/2");
	        
	        System.out.println(response.getStatusCode());
			System.out.println(response.getStatusLine());
			System.out.println("Headers are =>  "+response.getHeaders());
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
	     
	 }

}
