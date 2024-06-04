package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.stepdefinitions;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.FindOutThe;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BarraNavegacion;
import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BotonPerfil;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class VisibleBarraNavegacionStepDefinition_Sprint2 {
    private static final Logger logger = LoggerFactory.getLogger(VisibleBarraNavegacionStepDefinition_Sprint2.class);

    @Managed(driver = "chrome")
    public WebDriver theDriver;

    private final Actor usuario = Actor.named("usuario");

    @Before
    public void setup() {
        setTheStage(new OnlineCast());
        usuario.can(BrowseTheWeb.with(theDriver));
        ThucydidesWebDriverSupport.getDriver().manage().window().maximize();

        logger.info("Feature:Creación de Barra de Navegación");
    }
     @Given("que estoy en una pagina de la aplicacion web")
    public void estoyEnUnaPaginaDeLaAplicacionWeb() {
        usuario.attemptsTo(OpenThe.browser(new LoginPage()));
    }

    @When("observo la barra de navegacion")
    public void observoLaBarraDeNavegacion() {
        // No se realiza ninguna acción específica para observar la barra de navegación,
        // ya que todas las acciones se realizarán en los pasos Then.
    }

    @Then("deberia haber una indicacion visual clara del elemento activo")
    public void deberiaHaberUnaIndicacionVisualClaraDelElementoActivo() {
         usuario.should(seeThat("Indicacion de barra navegacion es visible", WebElementQuestion.the(BarraNavegacion.INDICACION_BARRA_NAVEGACION),
                isVisible()));
    }

    @Then("deberia ver la barra de navegacion")
    public void deberiaVerLaBarraDeNavegacion() {
        usuario.should(seeThat("Barra de navegacion es visible", WebElementQuestion.the(BarraNavegacion.BARRA_NAVEGACION),
        isVisible()));
    }

    @Then("deberia estar ubicada en la parte superior de la pagina")
    public void deberiaEstarUbicadaEnLaParteSuperiorDeLaPagina() {
        usuario.should(seeThat("Barra de navegacion ubicada parte superior", WebElementQuestion.the(BarraNavegacion.BARRA_NAVEGACION),
        isVisible()));
    }

    @Then("deberia ver enlaces a los diferentes modulos de la aplicacion web")
    public void deberiaVerEnlacesALosDiferentesModulosDeLaAplicacionWeb() {
        usuario.should(seeThat("Enlaces otros Modulos ", WebElementQuestion.the(BarraNavegacion.ENLACES_MODULOS),
        isVisible()));    }
}
