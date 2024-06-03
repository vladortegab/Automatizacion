package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.interactions.EnterThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class FindOutThe implements Task {
    private final String email;
    private final String password;

    public FindOutThe(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(EnterThe.credentials(email, password));
    }

    public static FindOutThe credentials(String email, String password) {
        return Tasks.instrumented(FindOutThe.class, email, password);
    }
 
}
