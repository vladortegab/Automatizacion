package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.AssignAdminPermissions;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginAsAdmin;
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

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class AsignarPermisosAdministradorStepDefinition_Sprint1 {
    private static final Logger logger = LoggerFactory
            .getLogger(AsignarPermisosAdministradorStepDefinition_Sprint1.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor administrador = Actor.named("administrador");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        administrador.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature: Asignacion de permisos de administrador");
    }

    @Given("que el usuario esta autenticado en la plataforma Orden6")
    public void queElUsuarioEstaAutenticadoEnLaPlataformaOrden6() {
        administrador.attemptsTo(OpenThe.browser(new LoginPage()));
        if (!WebElementQuestion.the(LoginPage.LINK_PERFIL_SESION).answeredBy(administrador).isVisible()) {
            administrador.attemptsTo(
                    FindOutThe.credentials("animatrix88@gmail.com", "Torre123*"));
        }
    }

    @When("me dirijo a la pestana de asignacion de roles")
    public void soyUnAdministradorDeLaAplicacion() {
        administrador.attemptsTo(Click.on(LoginAsAdmin.NOMBRE_ROLES_ICON));
    }

     @Then("asigno permisos de administrador a un usuario registrado")
    public void asignoPermisosDeAdministradorAUnUsuarioRegistrado() {
        administrador.attemptsTo(AssignAdminPermissions.toUser("jhonDario@gmail.com"));
    }

    @And("el usuario seleccionado ahora debe tener permisos de administrador")
    public void elUsuarioSeleccionadoAhoraDebeTenerPermisosDeAdministrador() {
        administrador.attemptsTo(Click.on(LoginAsAdmin.ASIGNO_PERMISO_ROL_ADMIN));

    }
}
