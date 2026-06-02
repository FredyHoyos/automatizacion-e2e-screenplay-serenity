package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.TITLE_CREATE_ACCOUNT;

public class AccountCreatedThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String message = BrowseTheWeb.as(actor).find(TITLE_CREATE_ACCOUNT).getText();
        Wait.aLittelBitTime(2000);
        return message.toLowerCase().contains("account created");
    }

    public static AccountCreatedThe isVisible() {
        return new AccountCreatedThe();
    }
}