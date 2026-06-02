package co.edu.udea.certificacion.taller.moduloauthycompra.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.core.pages.WebElementFacade;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.INFO_EMAIL_EXIST;

public class EmailExistsThe implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        try {
            // Busca todos los elementos que coinciden con el mensaje de correo existente.
            // Se usa findAll para evitar que la prueba falle si el mensaje no aparece.
            java.util.List<WebElementFacade> elems = BrowseTheWeb.as(actor).findAll(INFO_EMAIL_EXIST);
            if (elems == null || elems.isEmpty()) {
                // Si no existe el mensaje, la respuesta es falsa.
                return false;
            }

            // Toma el primer elemento encontrado y lee su texto visible.
            String msgFromPage = elems.get(0).getText();
            // Espera corta para dar tiempo a que el DOM termine de renderizar el mensaje.
            Wait.aLittelBitTime(2000);

            // Verifica que el texto visible contenga el mensaje esperado.
            return msgFromPage != null && msgFromPage.contains("Email Address already exist!");
        } catch (Exception e) {
            // Cualquier error de lectura se interpreta como que el mensaje no apareció.
            return false;
        }
    }

    public static EmailExistsThe isVisible() {
        return new EmailExistsThe();
    }
}

