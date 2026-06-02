package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.CREATE_ACCOUNT_BUTTON;

public class TrySubmitButPreventSubmission implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Este script intercepta el evento submit antes de que el navegador
        // procese el envio normal del formulario.
        // Se usa para probar validaciones sin navegar a la siguiente pantalla.
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver()).executeScript(
            "(function(){ var btn = document.querySelector('[data-qa=\\'create-account\\']'); if(btn){ var form = btn.closest('form'); if(form){ form.addEventListener('submit', function(e){ e.preventDefault(); }, {capture:true}); } } })();"
        );

        // Se hace click en el boton para disparar la validacion del formulario
        // y forzar el intento de envio, pero sin completar la accion final.
        actor.attemptsTo(Click.on(CREATE_ACCOUNT_BUTTON));
    }

    public static TrySubmitButPreventSubmission now(){
        return Tasks.instrumented(TrySubmitButPreventSubmission.class);
    }
}
