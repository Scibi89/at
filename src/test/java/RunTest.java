import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    monochrome = true,
    features = {"src/test/features/Test.feature"},
    plugin = {"pretty", "html:target/cukes"},
    tags = {"@Selected"},
    glue = {"com.functional.steps"})
public class RunTest {

}
