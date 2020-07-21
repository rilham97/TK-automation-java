# TK-automation

## ⚠️ Maven Running Configuration
1. Please notice on your BaseDriver.java  
Change your device ID using own device
2. Please notice on your pom.xml
on path `<id>local-maven-repo</id>` please change the path to your local project

For additional please **ignore** `BaseDriver.java` and `pom.xml` when you want to push or pull the project from master.


## Maven Running Configuration
Right-click the pom.xml file and select Run As  Maven build.
![alt text](https://www.vogella.com/tutorials/EclipseMaven/img/xm2e_javaconverttomaven20.png.pagespeed.ic.LJL9xBE1M_.webp)  

Enter `clean install` as Goal.  
For the first build you should run `Maven build`, after that you can run `Maven Test` without run build as long you don't <u>add or change any dependency</u>

## Runner Test Configuration
For @CucumberOptions, the above would look like:

* Run feature or scenario which **only** have tag label tag1 = {"@tag1"}
* Run all feautre or scenario **except** tag1 = {"not tag1"}
* Run feature or scenario which have tag label tag1 **OR** tag2 = {"@tag1 or @tag2"}
* Run feature or scenario which have tag label tag1 **AND** tag2  = {"@tag1 and @tag2"}
* Combianation clause tags = {"@tag1 and (@tag2 or @tag3)"}

## API Request using Rest Assured

1. Configuration
Add the below dependency to your POM.xml:

		<dependency>
			<groupId>io.rest-assured</groupId>
			<artifactId>rest-assured</artifactId>
			<version>4.3.1</version>
		</dependency>

In order to create JSON objects in the code, we will add a Simple JSON library in the classpath. You can add the below dependency to your POM.xml:

		<dependency>
			<groupId>com.googlecode.json-simple</groupId>
			<artifactId>json-simple</artifactId>
			<version>1.1.1</version>
		</dependency>

Let us understand testing a POST web service using an example. We will take a look at a login web service. Web service details are
!(image)[https://ibb.co/645xJFx]

Step 1: Create a Request pointing to the Service Endpoint

     RestAssured.baseURI ="https://restapi.demoqa.com/customer";
     RequestSpecification request = RestAssured.given();

 
Step 2: Create a JSON request body which contains all the fields
			
      JSONObject requestBody = new JSONObject();
      requestBody.put("email", email);
      requestBody.put("password", password);
			
 
**JSONObject** is a class that is present in `org.json.simple package`. This class is a programmatic representation of a **JSON string**.  Take a look at the Request JSON above for our test web service, you will notice that there are multiple nodes in the JSON. Each node can be added using the **JSONObject.put(String, String)** method. 
Once you have added all the nodes you can get the String representation of JSONObject by calling **JSONObject.toJSONString()** method.

Step 3: Add JSON body in the request and send the Request

      // Add a header stating the Request body is a JSON
      request.header("Content-Type", "application/json");
      
      // Add the Json to the body of the request
      request.body(requestBody.toJSONString());
      
      // Post the request and check the response
      Response response = request.post("/auth/login");
      
This web service accepts a JSON body. By this step, we have created our JSON body that needs to be sent. In this step, we will simply add the JSON String to the body of the HTTP Request and make sure that the `Content-Type header` field has a value of `application/json`.   

Step 4: Validate the Response

	int statusCode = response.getStatusCode();
	System.out.println(statusCode);
	Assert.assertEquals(statusCode, 200);

Now that we have sent the Request and received a Response, let us validate Status Code.

Step 5: Get token value from response body
      
	//Covert the json become string
	String jsonString = response.asString();
	token = JsonPath.from(jsonString).get("content");

More documentaion about Rest assured can be access here:

https://www.toolsqa.com/rest-assured/post-request-using-rest-assured/
https://www.toolsqa.com/rest-assured/read-json-response-body-using-rest-assured/


### To Do
1. Screenshoot listener on cucumber report
2. API call ✅
3. DB call ✅
4. Dynamic device ✅
5. Move to Flutter Driver script
