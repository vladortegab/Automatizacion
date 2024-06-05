package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.ActualizarDatosTasks;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FillOutRegistrationForm;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.ActualizarDatos;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BarraNavegacion;
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
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FillOutRegistrationForm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class ActualizacionDatosPersonales_Sprint2 {
    private final Actor usuario = Actor.named("usuario");

    private static final Logger logger = LoggerFactory.getLogger(ActualizacionDatosPersonales_Sprint2.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();
        logger.info("Feature: Actualizacion de Datos Personales");
    }

    @Given("Soy un usuario registrado")
    public void soyUnUsuarioRegistrado() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));
        usuario.attemptsTo(FindOutThe.credentials("animatrix88@gmail.com", "Torre123*"));
    }

    @When("Accedo a mi perfil en la aplicación web")
    public void accedoAMiPerfilEnLaAplicacionWeb() {
        usuario.attemptsTo(Click.on(BotonPerfil.NOMBRE_PROFILE_ICON));
    }

    @Then("Deberia ver un boton para editar mi perfil")
    public void deberiaVerUnBotonParaEditarMiPerfil() {
        usuario.should(seeThat("Despliegue de opciones visible", WebElementQuestion.the(BotonPerfil.OPTIONS_PERFIL),
        isVisible()));
    }

    @And("hacer clic en Perfil, se dirigira al usuario a la pestana de perfil")
    public void HacerClicEnPerfilSeDirigiraAlUsuarioALaPestanaDePerfil() {
        usuario.attemptsTo(Click.on(BotonPerfil.PROFILE_ICON));
    }

   

    @When("Modifico mis datos personales: nombre, apellido, numero de telefono y contrasena")
    public void modificoMisDatosPersonales() {
        usuario.attemptsTo(
                ActualizarDatosTasks.withRequiredDataActualizar("NuevoNombre", "NuevoApellido", "3135076578",
                        "actualcorreo@hotmail.com*"));

    }

    @And("Guardo los cambios")
    public void guardoLosCambios() {
        usuario.attemptsTo(Click.on(ActualizarDatos.BOTON_GUARDAR_CAMBIOS));
    }

    @Then("Deberian actualizarse mis datos personales en el sistema")
    public void deberianActualizarseMisDatosPersonalesEnElSistema() {
        usuario.should(seeThat("Datos actualizados correctamente",
                actor -> WebElementQuestion.the(ActualizarDatos.CONFIRMACION_DATOS).answeredBy(actor).isVisible()));
        // Puedes agregar más validaciones según sea necesario
    }

}
