package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.models.Payment;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.CARD_CVC;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.CARD_NUMBER;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.EXPIRY_MONTH;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.EXPIRY_YEAR;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.NAME_ON_CARD;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.PAY_BUTTON;

public class CompletePaymentThe implements Interaction {

    private final Payment payment;

    public CompletePaymentThe(Payment payment) {
        this.payment = payment;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(NAME_ON_CARD, isVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Enter.theValue(payment.getNameOnCard()).into(NAME_ON_CARD));
        actor.attemptsTo(Enter.theValue(payment.getCardNumber()).into(CARD_NUMBER));
        actor.attemptsTo(Enter.theValue(payment.getCvc()).into(CARD_CVC));
        actor.attemptsTo(Enter.theValue(payment.getExpiryMonth()).into(EXPIRY_MONTH));
        actor.attemptsTo(Enter.theValue(payment.getExpiryYear()).into(EXPIRY_YEAR));
        actor.attemptsTo(Click.on(PAY_BUTTON));
        Wait.aLittelBitTime(1000);
    }

    public static CompletePaymentThe with(Payment payment){
        return Tasks.instrumented(CompletePaymentThe.class, payment);
    }
}
