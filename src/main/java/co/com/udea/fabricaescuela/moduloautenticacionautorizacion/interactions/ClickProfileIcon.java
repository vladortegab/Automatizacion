package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.BotonPerfil.*;

public class ClickProfileIcon implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(NOMBRE_PROFILE_ICON),
                Click.on(PROFILE_ICON)

        );
    }

    public static ClickProfileIcon option() {
        return new ClickProfileIcon();
    }
}
