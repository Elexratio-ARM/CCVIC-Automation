package Com.RunnerPackage;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Feature/fileadocument.feature", // Update the path to match your project structure
    glue = {"com.stepdefinition"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    tags = "@CivilSubmitSubpoenaedMaterial or @CivilSubpoenaedNotFound or @CivilObjectToComplyWithTheSubpoena or @CrimeSubpoenaedNotFound or @CrimeObjectToComplyWithTheSubpoena or @CrimeRespondTo32CApplication or @AppealSubpoenaedNotFound or @AppealObjectToComplyWithTheSubpoena or @AppealRespondTo32CApplication "
)
public class Runner {
}
