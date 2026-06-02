package co.edu.udea.certificacion.taller.moduloauthycompra.tasks;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.RegAuthThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class RegEnterThe implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(RegAuthThe.buyer());
    }

    //public static EnterThe information(User user)
    public static RegEnterThe information(){
        return Tasks.instrumented(RegEnterThe.class);
    }
 
}