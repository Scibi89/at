import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/features/"},
        plugin = {"pretty", "html:target/cukes"},
        tags = "@Selected",
        glue = {"com.functional", "com.config"})
public class RunTest {}
