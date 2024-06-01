package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FindOutThe implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.worldToFind());
    }

    public static FindOutThe wordKey() {
        return Tasks.instrumented(FindOutThe.class);
    }
}
