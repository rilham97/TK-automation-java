package utilities;

import org.json.simple.JSONObject;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.File;
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
            String jsonString = response.asString();
            int statusCode = response.getStatusCode();
            System.out.println(statusCode);
            Assert.assertEquals(statusCode, 200);
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
}
