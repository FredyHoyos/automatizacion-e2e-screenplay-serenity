package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateToProductsThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().thePageNamed("pages.productsUrl"));
        Wait.aLittelBitTime(2000);
    } 

    public static NavigateToProductsThe page(){
        return Tasks.instrumented(NavigateToProductsThe.class);
    }
}