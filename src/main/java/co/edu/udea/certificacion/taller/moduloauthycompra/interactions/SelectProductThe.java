package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.models.Product;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.ADD_TO_CART_FIRST;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.CONTINUE_SHOPPING_BTN;

public class SelectProductThe implements Interaction {
    public SelectProductThe(Product product) {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Por ahora se usa el primer producto; el modelo deja listo el paso para parametrizarlo luego.
        ((JavascriptExecutor) BrowseTheWeb.as(actor).getDriver()).executeScript(
            "document.querySelectorAll(\"ins.adsbygoogle, iframe[id^='aswift'], [id^='aswift']\").forEach(function(node){ node.remove(); });"
        );
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Click.on(ADD_TO_CART_FIRST));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Click.on(CONTINUE_SHOPPING_BTN));
        Wait.aLittelBitTime(1000);
    }

    public static SelectProductThe with(Product product){
        return Tasks.instrumented(SelectProductThe.class, product);
    }
}
