package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.ActualizarDatos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Task;

public class ActualizarDatosTasks implements Task {
    

    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public ActualizarDatosTasks(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public static ActualizarDatosTasks withRequiredDataActualizar(String firstName, String lastName, String phone,  String email) {
        return new ActualizarDatosTasks(firstName, lastName, phone,  email );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(ActualizarDatos.CAMPO_NOMBRE),
            Enter.theValue(lastName).into(ActualizarDatos.CAMPO_APELLIDO),
            Enter.theValue(phone).into(ActualizarDatos.CELULAR),
            Enter.theValue(email).into(ActualizarDatos.CORREO)
        );
    }
}
