package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.*;


public class RegAuthThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(SIGNUP_LOGIN_BTN));
    }

    public static RegAuthThe buyer(){
        return Tasks.instrumented(RegAuthThe.class);
    }
    
}
