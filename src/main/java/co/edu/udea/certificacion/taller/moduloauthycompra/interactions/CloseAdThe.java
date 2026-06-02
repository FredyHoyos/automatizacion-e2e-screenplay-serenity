package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class CloseAdThe implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver()).executeScript(
            "var selectors = [" +
                "'button[aria-label=\\'Close\\']'," +
                "'button.close'," +
                "'.close'," +
                "'[data-dismiss=\\'modal\\']'," +
                "'button[contains(.,\\'Close\\')]'" +
            "];" +
            "selectors.forEach(function(selector){" +
                "try { document.querySelectorAll(selector).forEach(function(node){ if (node && node.click) { node.click(); } }); } catch (e) {}" +
            "});" +
            "document.querySelectorAll('ins.adsbygoogle, iframe[id^=\\'aswift\\'], iframe[title*=\\'advert\\'], [id*=\\'ad\\'], [class*=\\'ad\\']').forEach(function(node){ node.remove(); });"
        );
    }

    public static CloseAdThe now() {
        return Tasks.instrumented(CloseAdThe.class);
    }
}