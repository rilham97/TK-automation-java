package stepsDef;
import base.BaseDriver;
import io.cucumber.java.*;
public class Hooks {
	BaseDriver driver = new BaseDriver();
	@Before
	public void beforeScenario() {
		System.out.println("This will run before the Scenario");
		driver.setUp();
	}
	
	@After
	public void afterScenario() {
		System.out.println("This will run after the Scenario");
		driver.tearDown();
	}
}
