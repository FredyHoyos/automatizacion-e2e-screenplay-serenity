package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.*;

public class AuthenticateThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //variables en modelo con sus variables
        actor.attemptsTo(Enter.theValue("ejemplo555@gmail.com").into(INPUT_USER_TEXT));
        Wait.aLittelBitTime(2000);

        actor.attemptsTo(Enter.theValue("12345678").into(INPUT_PASSWORD_TEXT));
        Wait.aLittelBitTime(2000);

        actor.attemptsTo(Click.on(BUTTON_LOG_IN));
        Wait.aLittelBitTime(2000);

    }

    public static AuthenticateThe buyer(){
        return Tasks.instrumented(AuthenticateThe.class);
    }
}