package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ActualizarDatos {
    public static final Target BOTON_EDITAR_PERFIL = Target.the("botón para editar perfil")
        .located(By.id("//button[contains(@class,'MuiButtonBase-root MuiButton-root')]"));
    
    public static final Target CAMPO_NOMBRE = Target.the("campo para el nombre")
        .located(By.id("//input[@value='%s']"));
    
    public static final Target CAMPO_APELLIDO = Target.the("campo para el apellido")
        .located(By.id("//input[@value='%s']"));
    
    public static final Target CORREO = Target.the("campo para el correo electronico")
        .located(By.id("//input[@value='%s']"));
    
    public static final Target CELULAR = Target.the("campo para el celular")
        .located(By.id("//input[@value='%s']"));
    
    public static final Target BOTON_GUARDAR_CAMBIOS = Target.the("botón para guardar cambios")
        .located(By.id("//button[contains(@class,'my-3 flex')]"));

    public static final Target CONFIRMACION_DATOS = Target.the("confirmacion de datos")
        .located(By.id("boton-guardar-cambios"));    
}