import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/cucumber.html"},
        tags = "@Selected",
        glue = {"com.functional", "com.config"},
        publish = true)
public class RunTest {}
