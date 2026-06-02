package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.COMMENT_BOX;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.PLACE_ORDER_BTN;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.PROCEED_TO_CHECKOUT_BTN;

public class ProceedToCheckoutThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PROCEED_TO_CHECKOUT_BTN));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Enter.theValue("Compra feliz" ).into(COMMENT_BOX));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Click.on(PLACE_ORDER_BTN));
        Wait.aLittelBitTime(2000);
    }

    public static ProceedToCheckoutThe page(){
        return Tasks.instrumented(ProceedToCheckoutThe.class);
    }
}