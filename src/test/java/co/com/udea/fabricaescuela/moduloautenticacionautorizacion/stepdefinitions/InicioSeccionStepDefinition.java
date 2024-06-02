package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
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
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class InicioSeccionStepDefinition {
    private static final Logger logger = LoggerFactory.getLogger(InicioSeccionStepDefinition.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Accediendo a la pagina de inicio de sesión");
    }

    @Given("que estoy en la pagina de inicio de sesion")
    public void queEstoyEnLaPaginaDeInicioDeSesion() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));
    }

    @When("ingreso mi correo electronico y contrasena")
    public void ingresoMiCorreoElectronicoYContrasena() {
        usuario.attemptsTo(FindOutThe.credentials("animatrix88@gmail.com", "Torre123*"));
    }

    @When("hago clic en el boton Iniciar Sesion")
    public void hagoClicEnElBotonIniciarSesion() {
        usuario.attemptsTo(Click.on(LoginPage.LINK_BOTON_INICIAR_SESION_HOMEPAGE));
    }

    @Then("deberia ver un indicador de carga mientras se verifican mis credenciales")
    public void deberiaVerUnIndicadorDeCargaMientrasSeVerificanMisCredenciales() {
        // Implementar la verificación del indicador de carga si es necesario
    }

    @Then("deberia ser redirigido a la pagina principal de la aplicacion")
    public void deberiaSerRedirigidoALaPaginaPrincipalDeLaAplicacion() {
        usuario.should(seeThat("El boton de perfil esta visible",
                actor -> WebElementQuestion.the(LoginPage.LINK_PERFIL_SESION).answeredBy(actor).isVisible()));
    }

   /*  @Then("deberia permitir cerrar sesion correctamente")
    public void deberiaCerrarSesionCorrectamente() {
        usuario.attemptsTo(Click.on(LoginPage.LINK_BOTON_CERRAR_SESION_HOMEPAGE));
    } */
}
