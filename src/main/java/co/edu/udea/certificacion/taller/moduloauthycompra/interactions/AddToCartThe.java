package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

public class AddToCartThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Placeholder: agregar producto al carrito
        Wait.aLittelBitTime(1000);
    }

    public static AddToCartThe buyer(){
        return Tasks.instrumented(AddToCartThe.class);
    }
}
