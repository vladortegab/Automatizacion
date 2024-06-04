package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BarraNavegacion {
    public static final Target INDICACION_BARRA_NAVEGACION = Target.the("INDICACION_BARRA NAVEGACION")
            .locatedBy("//div[contains(@class,'MuiTypography-root MuiTypography-h6')]");

    public static final Target BARRA_NAVEGACION = Target.the("BARRA NAVEGACION")
            .locatedBy("//header[contains(@class,'MuiPaper-root MuiPaper-elevation')]//div");

    public static final Target ENLACES_MODULOS = Target.the("ENLACES OTROS MODULOS")
            .locatedBy("//div[contains(@class,'flex gap-4')]");
}
