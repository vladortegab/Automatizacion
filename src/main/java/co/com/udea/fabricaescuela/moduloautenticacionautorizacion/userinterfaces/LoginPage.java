package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target LINK_INICIAR_SESION_HOMEPAGE = Target.the("LINK INICIAR SESION HOMEPAGE").locatedBy("//a[contains(@class,'flex items-center')]");
    public static final Target TITLE_CORREO_INICIO_SESION = Target.the("TITLE CORREO INICIO SESION").located(By.name("userEmail"));
    public static final Target TITLE_PASSWORD_INICIO_SESION = Target.the("TITLE PASSWORD INICIO SESION").located(By.name("userPassword"));
    public static final Target MARK_TERMINES_AND_CONDITION_INICIO_SESION = Target.the("MARCAR TERMINOS Y CONDICIONES").locatedBy("//input[@class='PrivateSwitchBase-input mui-1m9pwf3']");
    public static final Target MARK_AUTORIZED_POLITICS_AND_PRIVACE_INICIO_SESION = Target.the("MARCAR ACUERDO POLITICA DE PRIVACIDAD").locatedBy("(//input[@class='PrivateSwitchBase-input mui-1m9pwf3'])[2]");
    public static final Target LINK_BOTON_INICIAR_SESION_HOMEPAGE = Target.the("LINK BOTON INICIAR SESION HOMEPAGE").locatedBy("//button[contains(@class,'bg-blue-500 text-center')] ");
    public static final Target LINK_PERFIL_SESION = Target.the("BOTON PERFIL SESION ACTUAL").locatedBy("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]");
    public static final Target LINK_BOTON_CERRAR_SESION_HOMEPAGE = Target.the("BOTON CIERRE SESION ACTUAL").locatedBy("//button[contains(@class,'MuiButtonBase-root MuiButton-root')] ");
}

