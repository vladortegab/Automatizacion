package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions.ClickGoogle;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions.EnterThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BarraNavegacion;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BotonPerfil;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginGoogle;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage.LINK_INICIAR_SESION_HOMEPAGE;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class OpcionesInicioSesionStepDefinition_Sprint2 {
    private static final Logger logger = LoggerFactory.getLogger(OpcionesInicioSesionStepDefinition_Sprint2.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature: Opciones de Inicio de Sesion con Google");
    }

    @Given("que estoy en la pagina de inicio de sesion Orden8")
    public void estoyEnLaPaginaDeInicioDeSesionOrden8() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));
        usuario.attemptsTo(Click.on(LoginPage.LINK_INICIAR_SESION_HOMEPAGE));
        
    }

    @When("hago clic en el boton de inicio de sesion con Google")
    public void hagoClicEnElBotonDeInicioDeSesionConGoogle() {
        usuario.attemptsTo(Click.on(LoginGoogle.CLICK_GOOGLE));

    }

    @Then("debo ser redirigido automaticamente al flujo de autenticacion de Google")
    public void deboSerRedirigidoAutomaticamenteAlFlujoDeAutenticacionDeGoogle() {
        // Implementación de la verificación debo ser redirigido automaticamente al flujo de autenticacion de Google
    }

    @Then("despues de completar el flujo de autenticacion en Google")
    public void despuesDeCompletarElFlujoDeAutenticacionEnGoogle() {
        // Implementación de la verificación de despues de completar el flujo de autenticacion en Google
        
    }

    @Then("deberia de redirigirme de vuelta a la pagina de inicio de sesion de manera automatica")
    public void deberiaDeRedirigirmeDeVueltaALaPaginaDeInicioDeSesionDeManeraAutomatica() {
        // Implementación de la verificación deberia de redirigirme de vuelta a la pagina de inicio de sesion de manera automatica

    }
}
