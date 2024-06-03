package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {
    public static final Target ANYTHING_PAGE_REGISTRO_HOMEPAGE = Target.the("CUALQUIER LUGAR HOMEPAGE")
            .locatedBy("//main[@class='flex-grow bg-gray-100']");
    public static final Target LINK_INICIAR_SESION_HOMEPAGE = Target.the("LINK INICIAR SESION HOMEPAGE")
            .locatedBy("//a[contains(@class,'flex items-center')]");

    public static final Target LINK_BOTON_REGISTRO_HOMEPAGE = Target.the("LINK REGISTRO SESION HOMEPAGE")
            // .located(By.name("a"));
            .locatedBy("//a[contains(@class,'underline text-center')]");

    public static final Target FIRST_NAME_FIELD = Target.the("Campo Nombre")
            .locatedBy("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')]");

    public static final Target LAST_NAME_FIELD = Target.the("Campo Apellidos")
            .locatedBy("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]");

    public static final Target PHONE_FIELD = Target.the("Campo Teléfono")
            .located(By.name("telephoneNumber"));
    public static final Target IDENTIFICATION_FIELD = Target.the("Campo Identificación")
            .locatedBy("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");

    public static final Target EMAIL_FIELD = Target.the("Campo Correo Electrónico")
            .located(By.name("email"));

    public static final Target PASSWORD_FIELD = Target.the("Campo Contraseña")
            .locatedBy("//input[@type='password']");

    public static final Target MARK_TERMINES_AND_CONDITION_REGISTER_SESION = Target.the("MARCAR TERMINOS Y CONDICIONES")
            .locatedBy("//input[@class='PrivateSwitchBase-input mui-1m9pwf3']");

    public static final Target MARK_AUTORIZED_POLITICS_AND_PRIVACE_REGISTER_SESION = Target
            .the("MARCAR ACUERDO POLITICA DE PRIVACIDAD")
            .locatedBy("(//input[@class='PrivateSwitchBase-input mui-1m9pwf3'])[2]");

    public static final Target BOTON_REGISTRO_CREACUENTAPAGE = Target.the("BOTON REGISTRO SESION CREA CUENTA PAGE")
            // .located(By.name("a"));
            .locatedBy("//button[contains(@class,'my-3 flex')]");
}
