package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FillOutRegistrationForm;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.OpenUrl;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Boton_para_Iniciar_SesionStepDefinition_Sprint1 {
    private static final Logger logger = LoggerFactory.getLogger(Boton_para_Iniciar_SesionStepDefinition_Sprint1.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature: Boton de inicio de sesion");
    }

    @Given("que estoy en cualquier pagina de la aplicacion Inicio")
    public void queEstoyEnCualquierPaginaDeLaAplicacionInicio() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));
    }

    @Then("deberia ver el boton de inicio de sesion")
    public void deberiaVerElBotonDeInicioDeSesion() {
        usuario.should(seeThat(WebElementQuestion.the(LoginPage.LINK_INICIAR_SESION_HOMEPAGE), isVisible()));
    }
    
}


