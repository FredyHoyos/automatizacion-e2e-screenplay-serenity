package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.TITLE_LOG_IN;

public class ValidationThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        String msgFromPage = BrowseTheWeb.as(actor).find(TITLE_LOG_IN).getText();

        return msgFromPage.contains("Logged in as");
    }

    public static ValidationThe productsPage(){
        return new ValidationThe();
    }
}