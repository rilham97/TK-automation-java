package connection;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;

public class apiV2 {
	private static final String eventId = "";
	private static final String title = "Automate Event";
	private static final String city = "Jember, Jawa Timur";
	private static final String startDateTime = "29-07-2020 12:30";
	private static final String finishDateTime = "29-07-2020 12:30";
	private static final String minimumAge = "18";
	private static final String maximumAge = "45";
	private static final String companionGender = "B";
	private static final String additionalInfo = "Automate Created";
	
	public static void postRequest(String endpoint) {
		RestAssured.defaultParser = Parser.JSON;
		HashMap<String, String> requestBody = new HashMap<>();
		requestBody.put("eventId",eventId);
		requestBody.put("title",title);
		requestBody.put("city",city);
		requestBody.put("startDateTime",startDateTime);
		requestBody.put("finishDateTime",finishDateTime);
		requestBody.put("minimumAge",minimumAge);
		requestBody.put("maximumAge",maximumAge);
		requestBody.put("companionGender",companionGender);
		requestBody.put("additionalInfo",additionalInfo);	
				given()
						.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
				with()
						.body(requestBody).
				when()
						.post("http://chippermitrais.ddns.net/auth/login").
				then()
						.contentType(ContentType.JSON).extract().response();
	}

	public static void main(String[] args) {



	}
}
