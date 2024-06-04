package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class AssignAdminPermissions implements Task {

    private static final Logger logger = LoggerFactory.getLogger(AssignAdminPermissions.class);
    private final String userEmail;

    public AssignAdminPermissions(String userEmail) {
        this.userEmail = userEmail;
    }

    public static AssignAdminPermissions toUser(String userEmail) {
        return Tasks.instrumented(AssignAdminPermissions.class, userEmail);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Usar XPath dinámico para buscar el correo proporcionado
        String userEmailXPath = String.format("//td[text()='%s']", userEmail);
        logger.info("Buscando el correo electrónico con XPath: {}", userEmailXPath);

        Target NEXT_PAGE_BUTTON = Target.the("Next page button")
                .locatedBy("//div[contains(@class,'flex justify-center')]"); // Actualiza este XPath según sea necesario

        boolean userFound = false;

        while (!userFound) {
            List<WebElement> emailElements = driver.findElements(By.xpath(userEmailXPath));
            if (!emailElements.isEmpty() && emailElements.get(0).isDisplayed()) {
                WebElement emailElement = emailElements.get(0);
                userFound = true;
                logger.info("Correo electrónico encontrado: {}", userEmail);

                // Encuentra el botón en la misma fila que el correo electrónico
                WebElement rowElement = emailElement.findElement(By.xpath("./ancestor::tr"));
                WebElement roleButton = rowElement
                        .findElement(By.xpath(".//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));

                roleButton.click();

                actor.attemptsTo(
                        Click.on(Target.the("Role dropdown")
                                .locatedBy("(//li[@role='menuitem'])[2]")),
                        Click.on(Target.the("Administrator option")
                                .locatedBy("//li[@role='menuitem' and text()='Administrador']")),
                        Click.on(Target.the("Administrator confirme")
                                .locatedBy(
                                        "//button[text()='Cancelar']/following-sibling::button")));

            } else {
                logger.warn("Correo electrónico no encontrado en la página actual, pasando a la siguiente página.");
                // Esperar hasta que el botón de siguiente página sea clicable
                try {
                    WebElement nextPageButton = wait.until(ExpectedConditions
                            .elementToBeClickable(By.xpath(NEXT_PAGE_BUTTON.getCssOrXPathSelector())));
                    nextPageButton.click();
                } catch (Exception waitException) {
                    logger.error("El botón de siguiente página no está disponible.", waitException);
                    break; // Salir del bucle si el botón no está disponible
                }
            }
        }
    }
}
