package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;


public class RegAuthThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        //actor.attemptsTo(WaitUntil.the(SIGNUP_LOGIN_BTN, isClickable()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(SIGNUP_LOGIN_BTN));
    }

    public static RegAuthThe buyer(){
        return Tasks.instrumented(RegAuthThe.class);
    }
    
}
