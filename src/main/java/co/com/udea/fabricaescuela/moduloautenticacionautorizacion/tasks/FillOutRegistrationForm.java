package co.com.udea.fabricaescuela.moduloautenticacionautorizacion.tasks;

import co.com.udea.fabricaescuela.moduloautenticacionautorizacion.userinterfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class FillOutRegistrationForm implements Task {

    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String identification;
    private final String email;
    private final String password;

    public FillOutRegistrationForm(String firstName, String lastName, String phone, String identification, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.identification = identification;
        this.email = email;
        this.password = password;
    }

    public static FillOutRegistrationForm withRequiredData(String firstName, String lastName, String phone, String identification, String email, String password) {
        return new FillOutRegistrationForm(firstName, lastName, phone, identification, email, password);
    }

   

  

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(firstName).into(RegisterPage.FIRST_NAME_FIELD),
            Enter.theValue(lastName).into(RegisterPage.LAST_NAME_FIELD),
            Enter.theValue(phone).into(RegisterPage.PHONE_FIELD),
            Enter.theValue(identification).into(RegisterPage.IDENTIFICATION_FIELD),
            Enter.theValue(email).into(RegisterPage.EMAIL_FIELD),
            Enter.theValue(password).into(RegisterPage.PASSWORD_FIELD),
            Click.on(RegisterPage.MARK_TERMINES_AND_CONDITION_REGISTER_SESION),
            Click.on(RegisterPage.MARK_AUTORIZED_POLITICS_AND_PRIVACE_REGISTER_SESION)
        );
    }
}
