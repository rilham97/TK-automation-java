package runner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		// Location your feature files 
		features = {"src/test/resources/features"},
		// Which tags
		tags = {"@Positive or @Negative"},
		// Location your step definition 
		glue = {"stepsDef"},
		// Output the report
		plugin = {"json:target/cucumber-reports/LoginUI.json"}
		)

public class RunnerTest {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		System.out.println("Cucumber Test Class Before");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickle.getPickle());
	}
	
	@DataProvider
	public Object[][] scenarios() {
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass(){
		testNGCucumberRunner.finish();
	}
}
