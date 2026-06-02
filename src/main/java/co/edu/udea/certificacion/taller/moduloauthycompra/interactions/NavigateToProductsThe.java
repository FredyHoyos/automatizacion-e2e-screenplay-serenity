package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.PRODUCTS_BTN;

public class NavigateToProductsThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(PRODUCTS_BTN));
        Wait.aLittelBitTime(1000);
    }

    public static NavigateToProductsThe page(){
        return Tasks.instrumented(NavigateToProductsThe.class);
    }
}