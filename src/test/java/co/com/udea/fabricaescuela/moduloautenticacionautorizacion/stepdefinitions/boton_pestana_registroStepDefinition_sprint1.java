package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class boton_pestana_registroStepDefinition_sprint1 {
    private static final Logger logger = LoggerFactory.getLogger(boton_pestana_registroStepDefinition_sprint1.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature: Botón de Registro en la Barra de Navegación");
    }

    @Given("que estoy en cualquier pagina de la aplicacion")
    public void queEstoyEnCualquierPaginaDeLaAplicacion() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));

    }

    @When("estoy en la pagina de inicio de sesion")
    public void EstoyEnLaPaginaDeInicioDeSesion() {
        usuario.attemptsTo(Click.on(RegisterPage.LINK_INICIAR_SESION_HOMEPAGE));

    }

    @And("hago clic en el boton de registro")
    public void hagoClickEnBotonRegistro() {
        usuario.attemptsTo(Click.on(RegisterPage.LINK_BOTON_REGISTRO_HOMEPAGE));

    }

    @Then("deberia ser redirigido a la pagina de registro")
    public void deberiaSerRedirigidoALaPaginaDeRegistro() {
    }

}
