package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;

public class ValidateOrderThe implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Placeholder: validar que la orden fue confirmada
        Wait.aLittelBitTime(1000);
    }

    public static ValidateOrderThe buyer(){
        return Tasks.instrumented(ValidateOrderThe.class);
    }
}
