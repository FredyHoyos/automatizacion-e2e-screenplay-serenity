package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.INFO_SECOND_FORM;

public class EnterAccountInfoThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Busca el bloque que contiene el titulo "Enter Account Information".
            // Si no existe, no se lanza error y la validacion devuelve false.
            java.util.List<WebElementFacade> elems = BrowseTheWeb.as(actor).findAll(INFO_SECOND_FORM);
            if (elems == null || elems.isEmpty()) {
                // Si el bloque no aparece, significa que no se puede continuar.
                return false;
            }

            // Lee el texto del primer elemento visible.
            String msgFromPage = elems.get(0).getText();
            // Pequeña espera para asegurar que el contenido ya se estabilizo.
            Wait.aLittelBitTime(2000);

            // Confirma si el bloque realmente muestra el texto esperado.
            return msgFromPage != null && msgFromPage.contains("Enter Account Information");
        } catch (Exception e) {
            // Si ocurre cualquier problema al buscar el elemento, se toma como ausente.
            return false;
        }
    }

    public static EnterAccountInfoThe isVisible() {
        return new EnterAccountInfoThe();
    }
}

