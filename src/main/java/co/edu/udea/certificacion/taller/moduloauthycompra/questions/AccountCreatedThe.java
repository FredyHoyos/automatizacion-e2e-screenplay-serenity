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
            // Busca el mensaje de confirmacion de cuenta creada sin forzar error si no aparece.
            java.util.List<WebElementFacade> elems = BrowseTheWeb.as(actor).findAll(TITLE_CREATE_ACCOUNT);
            if (elems == null || elems.isEmpty()) {
                // Si no se encuentra el mensaje, la respuesta es false.
                return false;
            }

            // Obtiene el texto visible del primer resultado encontrado.
            String msgFromPage = elems.get(0).getText();
            // Espera breve para evitar leer el DOM antes de que termine de renderizar.
            Wait.aLittelBitTime(2000);

            // Verifica que el texto contenga el mensaje esperado de exito.
            return msgFromPage != null && msgFromPage.contains("Account Created!");
        } catch (Exception e) {
            // Cualquier excepcion se interpreta como que el mensaje no esta visible.
            return false;
        }
    }

    public static AccountCreatedThe isVisible() {
        return new AccountCreatedThe();
    }
}