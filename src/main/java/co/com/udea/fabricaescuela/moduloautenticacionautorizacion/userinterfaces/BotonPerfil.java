package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BotonPerfil extends PageObject {

    public static final Target NOMBRE_PROFILE_ICON = Target.the("CLICK NOMBRE PERFIL")
            .locatedBy("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
    public static final Target PROFILE_ICON = Target.the("BOTON CLICK PERFIL")
            .locatedBy("//li[@role='menuitem']");
    public static final Target OPTIONS_PERFIL = Target.the("OPCIONES PERFIL")
            .locatedBy("//ul[contains(@class,'MuiList-root MuiList-padding')]");
    public static final Target NOMBRE_FIELD = Target.the("CAMPO NOMBRE PERFIL")
            .locatedBy("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]");
    public static final Target APELLIDOS_FIELD = Target.the("CAMPO APELLIDOS PERFIL")
            .locatedBy("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]");
    public static final Target TELEFONO_FIELD = Target.the("CAMPO TELEFONO PERFIL")
            .locatedBy("//input[@value='3206399431']");
    public static final Target IDENTIFICACION_FIELD = Target.the("CAMPO IDENTIFICACION PERFIL")
            .locatedBy("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");
    public static final Target CORREO_ELECTRONICO_FIELD = Target.the("CAMPO CORREO ELECTRONICO PERFIL")
            //.located(By.id(":r5:"));
            .locatedBy("//input[@value='animatrix88@gmail.com']");
    public static final Target EDICION_BOTON = Target.the("BOTON EDICION PERFIL")
            .locatedBy("//button[contains(@class,'mb-3 h-10')]");

}
