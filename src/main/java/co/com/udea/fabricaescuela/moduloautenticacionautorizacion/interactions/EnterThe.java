package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
//import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.LoginPage.*;


public class EnterThe implements Interaction {
    private final String email;
    private final String password;

    public EnterThe(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(LINK_INICIAR_SESION_HOMEPAGE),
            Enter.theValue(email).into(TITLE_CORREO_INICIO_SESION).thenHit(Keys.RETURN),
            Enter.theValue(password).into(TITLE_PASSWORD_INICIO_SESION).thenHit(Keys.RETURN),
            Click.on(MARK_TERMINES_AND_CONDITION_INICIO_SESION),
            Click.on(MARK_AUTORIZED_POLITICS_AND_PRIVACE_INICIO_SESION),
            Click.on(LINK_BOTON_INICIAR_SESION_HOMEPAGE)
            

        );
    }

    public static EnterThe credentials(String email, String password) {
        return new EnterThe(email, password);
    }
}
