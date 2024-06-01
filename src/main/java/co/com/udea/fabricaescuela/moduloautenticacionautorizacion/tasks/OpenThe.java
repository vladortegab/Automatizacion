package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Tasks;

public class OpenThe implements Task {
    private PageObject page;

    public OpenThe(PageObject page) {
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }

    public static OpenThe browser(PageObject page) {
        return Tasks.instrumented(OpenThe.class, page);
    }
}
