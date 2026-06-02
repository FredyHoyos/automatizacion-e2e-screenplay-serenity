package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.*;


public class RegisterThe implements Interaction {

    private final User user;

    public RegisterThe(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        
        actor.attemptsTo(Enter.theValue(user.getName()).into(SIGNUP_NAME));
        Wait.aLittelBitTime(2000);

        actor.attemptsTo(Enter.theValue(user.getEmail()).into(SIGNUP_EMAIL));
        Wait.aLittelBitTime(2000);

        actor.attemptsTo(Click.on(SIGNUP_BUTTON));
        Wait.aLittelBitTime(2000);
    }

    public static RegisterThe with(User user){
        return Tasks.instrumented(RegisterThe.class, user);
    }
    
}
