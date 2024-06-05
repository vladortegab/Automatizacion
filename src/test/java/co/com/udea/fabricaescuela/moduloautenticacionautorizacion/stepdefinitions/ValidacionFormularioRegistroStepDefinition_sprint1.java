package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FillOutRegistrationForm;
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
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
public class ValidacionFormularioRegistroStepDefinition_sprint1 {
    private static final Logger logger = LoggerFactory.getLogger(ValidacionFormularioRegistroStepDefinition_sprint1.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature: Validación de formulario de registro");
    }
    @Given("que estoy en la pagina de registro")
    public void queEstoyEnLaPaginaDeRegistro() {
        usuario.attemptsTo(OpenThe.url("http://localhost:3000/auth/new-account"));
    }

    @When("se registren los datos requeridos para el registro del usuario Nombre, Apellidos, Telefono, Identificacion, Correo Electronico y Contrasena")
    public void seRegistrenLosDatosRequeridosParaElRegistroDelUsuario() {
        //Cambiar datos por otro correo y probar, pero primero borrar este y actualizandolo
        usuario.attemptsTo(
            FillOutRegistrationForm.withRequiredData("Juan", "Perez", "1234567890", "123456791", "JOSE@hotmail.com", "Password123*")
        );


    }

    @Then("intento enviar el formulario completo con todos los campos obligatorios")
    public void intentoEnviarElFormularioCompleto() {
        usuario.attemptsTo(Click.on(RegisterPage.BOTON_REGISTRO_CREACUENTAPAGE));
    }

    @Then("deberia ingresar satisfactoriamente a la interfaz de usuario registrado")
    public void deberiaVerMensajeConfirmacionRegistro() {
         usuario.should(seeThat("El boton de perfil esta visible",
                actor -> WebElementQuestion.the(LoginPage.LINK_PERFIL_SESION).answeredBy(actor).isVisible()));
    }
}
