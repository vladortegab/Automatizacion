package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
//import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.Keys;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks.OpenThe;

import static co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage.*;


public class ClickGoogle implements Interaction {
 private PageObject page;
    private String url;

    public ClickGoogle(PageObject page) {
        this.page = page;
    }

    public ClickGoogle(String url) {
        this.url = url;
    }
   

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(LINK_INICIAR_SESION_HOMEPAGE)
           
            

        );
        if (url != null) {
            actor.attemptsTo(Open.url(url));
        } else {
            actor.attemptsTo(Open.browserOn(page));
        }
    }
     public static OpenThe browser(PageObject page) {
        return Tasks.instrumented(OpenThe.class, page);
    }

    public static OpenThe url(String url) {
        return Tasks.instrumented(OpenThe.class, url);
    }

    
}
