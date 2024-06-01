package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(

        features = "src/test/resources/features/find_out_udea_official_site.feature",
        glue = "co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"summary",
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        }
)
public class FindOutUdeAPageRunner {
}
