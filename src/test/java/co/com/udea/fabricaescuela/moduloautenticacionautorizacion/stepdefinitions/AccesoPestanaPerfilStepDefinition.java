package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BotonPerfil;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage;
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
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class AccesoPestanaPerfilStepDefinition {
    public final Actor usuario = Actor.named("usuario");

    private static final Logger logger = LoggerFactory.getLogger(AccesoPestanaPerfilStepDefinition.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        logger.info("Accediendo a la página");
    }

    
     @Given("que el usuario esta autenticado en la plataforma")
     public void queElUsuarioEstaAutenticadoEnLaPlataforma() {
      usuario.attemptsTo(OpenThe.browser(new LoginPage()));
      if
      (!WebElementQuestion.the(LoginPage.LINK_PERFIL_SESION).answeredBy(usuario).
      isVisible()) {
      usuario.attemptsTo(
      FindOutThe.credentials("animatrix88@gmail.com", "Torre123*")
      );
      }
     }
     
/*     @Given("que el usuario esta autenticado en la plataforma")
    public void queElUsuarioEstaAutenticadoEnLaPlataforma() {
        usuario.should(seeThat("El usuario esta autenticado ", WebElementQuestion.the(BotonPerfil.NOMBRE_PROFILE_ICON),
        isVisible()));
    } */

    @When("haga clic en el icono de perfil en la barra de navegacion")
    public void hagaClicEnElIconoDePerfilEnLaBarraDeNavegacion() {
        usuario.attemptsTo(Click.on(BotonPerfil.NOMBRE_PROFILE_ICON));
    }

    @Then("se desplegara un menu con varias opciones, incluida la opcion de Perfil")
    public void seDesplegaraUnMenuConVariasOpcionesIncluidaLaOpcionDePerfil() {
        usuario.should(seeThat("Despliegue de opciones visible", WebElementQuestion.the(BotonPerfil.OPTIONS_PERFIL),
                isVisible()));
    }

    @And("al hacer clic en Perfil, se dirigira al usuario a la pestana de perfil")
    public void alHacerClicEnPerfilSeDirigiraAlUsuarioALaPestanaDePerfil() {
        usuario.attemptsTo(Click.on(BotonPerfil.PROFILE_ICON));
    }

    @And("se cargaran los datos personales actuales del usuario Nombre, Apellidos, Telefono, Identificacion y Correo Electronico")
    public void seCargaranLosDatosPersonalesActualesDelUsuarioNombreApellidosTelefonoContrasenaYCorreoElectronico() {
        usuario.should(seeThat("El campo de Nombre esta visible", WebElementQuestion.the(BotonPerfil.NOMBRE_FIELD),
                isVisible()));
        usuario.should(seeThat("El campo de Apellidos esta visible",
                WebElementQuestion.the(BotonPerfil.APELLIDOS_FIELD), isVisible()));
        usuario.should(seeThat("El campo de Telefono esta visible", WebElementQuestion.the(BotonPerfil.TELEFONO_FIELD),
                isVisible()));
        usuario.should(seeThat("El campo de Identificacion esta visible",
                WebElementQuestion.the(BotonPerfil.IDENTIFICACION_FIELD), isVisible()));
        usuario.should(seeThat("El campo de Correo Electronico esta visible",
                WebElementQuestion.the(BotonPerfil.CORREO_ELECTRONICO_FIELD), isVisible()));
    }

    @And("aparece visible el boton de Edicion")
    public void apareceVisibleElBotonDeEdicion() {
        usuario.should(seeThat("El Boton de Edicion está visible", WebElementQuestion.the(BotonPerfil.EDICION_BOTON),
                isVisible()));

    }
}
