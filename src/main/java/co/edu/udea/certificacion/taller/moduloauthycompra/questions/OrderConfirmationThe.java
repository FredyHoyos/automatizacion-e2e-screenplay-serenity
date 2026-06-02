package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.ORDER_CONFIRMATION;

public class OrderConfirmationThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String message = BrowseTheWeb.as(actor).find(ORDER_CONFIRMATION).getText();
        Wait.aLittelBitTime(2000);
        return message.toLowerCase().contains("order placed");
    }

    public static OrderConfirmationThe isVisible() {
        return new OrderConfirmationThe();
    }
}