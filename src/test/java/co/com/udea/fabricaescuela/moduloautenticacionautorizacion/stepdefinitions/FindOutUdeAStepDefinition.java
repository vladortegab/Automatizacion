package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.questions.Validation;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.GooglePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindOutUdeAStepDefinition {
    public final Actor student = Actor.named("usuario");
    private static final Logger logger = LoggerFactory.getLogger(FindOutUdeAStepDefinition.class);

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void setup() {
        student.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
        logger.info("Accediendo a la pagina");
    }

    @Given("I am in the google page")
    public void iAmInTheGooglePage() {
        student.attemptsTo(OpenThe.browser(new GooglePage()));
    }

    @When("I search U de A word in the Google search eng")
    public void iSearchUDeAWordInTheGoogleSearchEng() {
        student.attemptsTo(FindOutThe.wordKey());
    }

    @Then("I can see the official udea link")
    public void iCanSeeTheOfficialUdeaLink() {
        GivenWhenThen.then(student).should(GivenWhenThen.seeThat(Validation.theSite(), Matchers.containsString("Actualidad")));
    }
}
