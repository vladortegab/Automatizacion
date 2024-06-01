package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.GooglePage.TITLE_UDEA_HOMEPAGE;

public class Validation implements Question<String> {

    public Validation() {
    }

    @Override
    public String answeredBy(Actor actor) {
        String msg = BrowseTheWeb.as(actor).find(TITLE_UDEA_HOMEPAGE).getText();
        return msg;
    }

    public static Validation theSite() {
        return new Validation();
    }

}