package Com.RunnerPackage;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Feature/fileadocument.feature", // Update the path to match your project structure
    glue = {"com.stepdefinition"},
    plugin = {"pretty", "html:target/cucumber-reports"},
     tags = " @FileADocumentObjection"
		)
public class Runner {
	
	
	

}



