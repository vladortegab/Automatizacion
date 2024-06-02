package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;
import io.cucumber.java.Before;
//import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class InicioSeccionStepDefinition {
    public final Actor usuario = Actor.named("usuario");
    private static final Logger logger = LoggerFactory.getLogger(InicioSeccionStepDefinition.class);

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void setup() {
        usuario.can(BrowseTheWeb.with(theDriver));
        setTheStage(new OnlineCast());
        logger.info("Accediendo a la pagina");
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
    }

  
    @Then("deberia ser redirigido a la página principal de la aplicacion")
    public void deberiaSerRedirigidoALaPaginaPrincipalDeLaAplicacion() {

    }
}




