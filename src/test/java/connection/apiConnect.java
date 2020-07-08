package connection;

import org.json.simple.JSONObject;
import org.junit.Test;
import org.testng.Assert;

import base.PropertiesReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.specification.RequestSpecification;

public class apiConnect {

	static String baseURL = PropertiesReader.readProperty("apiUrl");
	private static String token;
	
	private static final String eventId = "";
	private static final String title = "Automate Event";
	private static final String city = "Jember, Jawa Timur";
	private static final String startDateTime = "29-07-2020 12:30";
	private static final String finishDateTime = "29-07-2020 12:30";
	private static final String minimumAge = "18";
	private static final String maximumAge = "45";
	private static final String companionGender = "B";
	private static final String additionalInfo = "Automate Created";
	
	public static void main(String[] args) {
		login_OK();
		checkCurrentMyEvent();
		createEvent();
		applyEvent();
	}	


	@SuppressWarnings("unchecked")
	public static void login_OK(){
		try {
			RestAssured.baseURI = PropertiesReader.readProperty("apiUrl");
			RequestSpecification request = RestAssured.given();

			request.header("Content-Type", "application/json");
			request.header("Accept", "application/json");

			JSONObject requestBody = new JSONObject(); 
			requestBody.put("email","dummy2@mail.com");
			requestBody.put("password","R3st@mu");
			request.body(requestBody.toJSONString());
			System.out.println(requestBody.toJSONString());

			Response response = request.post("/auth/login");

			int statusCode = response.getStatusCode();
			String jsonString = response.asString();
			System.out.println(statusCode);
			
			// Assert that correct status code is returned.
			Assert.assertEquals(statusCode /*actual value*/,200 /*expected value*/, "Correct status code returned");

			token = JsonPath.from(jsonString).get("content");
			System.out.println(token);

		}catch(AssertionError e){
			System.out.println("Failed to login");
		}

	}

	public static void checkCurrentMyEvent() {

		RestAssured.baseURI = PropertiesReader.readProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");

		Response response = request.get("/event/my-event-current");

		String jsonString = response.asString();
		System.out.println(jsonString);
		
		List<Map<String, String>> event = JsonPath.from(jsonString).get("content.eventId");
		Assert.assertTrue(event.size() > 0);
		System.out.println(event);
	}
	
	@SuppressWarnings("unchecked")
	public static void createEvent() {
		RestAssured.baseURI = PropertiesReader.readProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		
		JSONObject requestBody = new JSONObject(); 
		requestBody.put("title",title);
		requestBody.put("city",city);
		requestBody.put("startDateTime",startDateTime);
		requestBody.put("finishDateTime",finishDateTime);
		requestBody.put("minimumAge",minimumAge);
		requestBody.put("maximumAge",maximumAge);
		requestBody.put("companionGender",companionGender);
		requestBody.put("additionalInfo",additionalInfo);	
		request.body(requestBody.toJSONString());

		Response response = request.post("/event/create");
		int statusCode = response.getStatusCode();
		String jsonString = response.asString();
		System.out.println(jsonString);
		Assert.assertEquals(statusCode /*actual value*/,200 /*expected value*/, "Event has created");
	}
	
	@SuppressWarnings("unchecked")
	public static void updateEvent() {
		RestAssured.baseURI = PropertiesReader.readProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		
		JSONObject requestBody = new JSONObject(); 
		requestBody.put("eventId",eventId);
		requestBody.put("title",title);
		requestBody.put("city",city);
		requestBody.put("startDateTime",startDateTime);
		requestBody.put("finishDateTime",finishDateTime);
		requestBody.put("minimumAge",minimumAge);
		requestBody.put("maximumAge",maximumAge);
		requestBody.put("companionGender",companionGender);
		requestBody.put("additionalInfo",additionalInfo);	
		request.body(requestBody.toJSONString());

		Response response = request.post("/event/create");
		int statusCode = response.getStatusCode();
		String jsonString = response.asString();
		System.out.println(jsonString);
		Assert.assertEquals(statusCode /*actual value*/,200 /*expected value*/, "Event has created");
	}
	
	public static void applyEvent() {
		RestAssured.baseURI = PropertiesReader.readProperty("apiUrl");
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.param("eventId", eventId);
		
		Response response = request.post("/event/apply");

		String jsonString = response.asString();
		System.out.println(jsonString);
	}
	
}
