package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginGoogle {
     public static final Target CLICK_GOOGLE = Target.the("CLICK BOTON GOOGLE INICIO")
            .locatedBy("//div[contains(@class,'w-44 h-3')]");
}
