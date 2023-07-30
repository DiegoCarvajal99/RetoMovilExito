package app.exito.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/app.exito.features/agregar_producto.feature",
        glue = "app.exito.stepDefinitions",
        snippets = SnippetType.CAMELCASE
)

public class AgregarProductoRunner {
}
