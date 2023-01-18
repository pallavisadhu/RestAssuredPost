package restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class PostReq {
		
	@SuppressWarnings("unchecked")
	@Test
	public void testCase_Post() {
		
		JSONObject request = new JSONObject();
		request.put("number", 16);
	    System.out.println("Request"+request);
	    System.out.println("To string"+request.toJSONString());
	    Response res = 
	    RestAssured.given().
        header("Content-Type","application/json").
        contentType(ContentType.JSON).
        accept(ContentType.JSON).
        body(request.toJSONString()).
        when().
        post("https://9im32ep0x3.execute-api.us-east-2.amazonaws.com/test/execute");
	    
	    System.out.println(res.getBody().asString());
	    System.out.println(res.getStatusCode());
	    Assert.assertEquals(res.getStatusCode(), 200);	    	    

	}

}
