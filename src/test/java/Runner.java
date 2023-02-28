import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions (

        plugin = {"pretty", "html:build/reports/feature.html"}, //mapeando endereço do relatório Cucumber
        features = {"src/test/resources/features/usuario.feature"} // Informando qual feature sera executada na Runner
)
public class Runner {

}
