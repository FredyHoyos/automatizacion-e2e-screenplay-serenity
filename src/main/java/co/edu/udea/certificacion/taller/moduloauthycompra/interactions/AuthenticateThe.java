package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.LOGIN_BUTTON;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.LOGIN_EMAIL;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.LOGIN_PASSWORD;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.SIGNUP_LOGIN_BTN;

public class AuthenticateThe implements Interaction {

    private final User user;

    public AuthenticateThe(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SIGNUP_LOGIN_BTN));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Enter.theValue(user.getEmail()).into(LOGIN_EMAIL));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Enter.theValue(user.getPassword()).into(LOGIN_PASSWORD));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Click.on(LOGIN_BUTTON));
        Wait.aLittelBitTime(1000);
    }

    public static AuthenticateThe buyer(){
        return Tasks.instrumented(AuthenticateThe.class, User.defaultUser());
    }

    public static AuthenticateThe with(User user){
        return Tasks.instrumented(AuthenticateThe.class, user);
    }
}