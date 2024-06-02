package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RegisterPage extends PageObject {
    public static final Target ANYTHING_PAGE_REGISTRO_HOMEPAGE = Target.the("CUALQUIER LUGAR HOMEPAGE")
    .locatedBy("//main[@class='flex-grow bg-gray-100']");
    public static final Target LINK_INICIAR_SESION_HOMEPAGE = Target.the("LINK INICIAR SESION HOMEPAGE")
    .locatedBy("//a[contains(@class,'flex items-center')]");
    
    public static final Target LINK_BOTON_REGISTRO_HOMEPAGE = Target.the("LINK REGISTRO SESION HOMEPAGE")
    //.located(By.name("a"));
    .locatedBy("//a[contains(@class,'underline text-center')]");
        
}
