package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class LoginAsAdmin {
    public static final Target NOMBRE_ROLES_ICON = Target.the("CLICK ROLES PERFIL")
            .locatedBy("//a[@href='/role-management']");

    public static final Target ASIGNO_PERMISO_ROL_ADMIN = Target.the("ASIGNO PERMISO ROL DE ADMINISTRADOR PERFIL")
            .locatedBy(
                    "//button[text()='Confirmar']");

}
