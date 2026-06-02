package co.edu.udea.certificacion.taller.moduloauthycompra.tasks;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.AuthenticateThe;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LogEnterThe implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AuthenticateThe.buyer());
    }

    //public static EnterThe information(User user)
    public static LogEnterThe information(){
        return Tasks.instrumented(LogEnterThe.class);
    }
 
}