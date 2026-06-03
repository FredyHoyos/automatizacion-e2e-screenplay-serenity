package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.TITLE_CREATE_ACCOUNT;

public class AccountCreatedThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Pequeña espera segura para permitir que la página actualice su DOM.
            Wait.aLittelBitTime(1000);
            // Busca el mensaje de confirmacion sin forzar excepción si no aparece.
            java.util.List<WebElementFacade> elems = BrowseTheWeb.as(actor).findAll(TITLE_CREATE_ACCOUNT);
            if (elems == null || elems.isEmpty()) {
                return false;
            }

            String msgFromPage = elems.get(0).getText();
            return msgFromPage != null && msgFromPage.toLowerCase().contains("account created!");
        } catch (Throwable e) {
            // Cualquier excepcion o AssertionError se interpreta como que el mensaje no esta visible.
            return false;
        }
    }

    public static AccountCreatedThe isVisible() {
        return new AccountCreatedThe();
    }
}