package utilities;

import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
import java.util.Map;

import io.restassured.specification.RequestSpecification;

public class APIcall {
	private static final String apiURL = PropertiesReader.readProperty("apiUrl");
	private static String token;

	@SuppressWarnings("unchecked")
	public static String login(String email, String password) {
		try {
			RestAssured.baseURI = apiURL;
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json");
			request.header("Accept", "application/json");
			JSONObject requestBody = new JSONObject();
			requestBody.put("email", email);
			requestBody.put("password", password);
			request.body(requestBody.toJSONString());
			Response response = request.post("/auth/login");

			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			Assert.assertEquals(statusCode, 200);

			String jsonString = response.asString();
			token = JsonPath.from(jsonString).get("content");
		} catch (AssertionError e) {
			System.out.println("Failed to login");
		}
		return token;
	}

	public static void updateProfile(String pathImage, String city, String aboutMe, String interest) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Accept", "application/json");
		request.multiPart("file", new File(pathImage));
		request.param("city", city);
		request.param("aboutMe", aboutMe);
		request.param("interest", interest);
		Response response = request.post("/profile/update");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	public static void updatePP(String pathImage) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Accept", "application/json");
		request.multiPart("file", new File(pathImage));
		Response response = request.post("/profile/update");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void applyEvent(int eventId) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.queryParam("eventId", eventId);
		Response response = request.post("/event/apply");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void cancelApplicationEvent(int eventId) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.header("Accept", "application/json");
		request.queryParam("eventId", eventId);
		Response response = request.post("/event/cancel");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void acceptApplicant(int applicantId) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");;
		request.queryParam("applicantId", applicantId);
		Response response = request.post("/applicant/accept");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void cancelApplicant(int applicantId) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.queryParam("applicantId", applicantId);
		Response response = request.post("/applicant/cancel-accepted");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void rejectApplicant(int applicantId) {
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.queryParam("applicantId", applicantId);
		Response response = request.post("/applicant/reject");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void cancelEvent(int eventId){
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.queryParam("eventId", eventId);
		Response response = request.post("/event/creator-cancel");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	public static void editEvent(Map<String, Object> body){
		RestAssured.baseURI = apiURL;
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer " + token);
		request.header("Content-Type", "application/json");
		request.body(body);
		Response response = request.post("/event/edit");
		String jsonString = response.asString();
		System.out.println(jsonString);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
