package co.edu.udea.certificacion.taller.moduloauthycompra.tasks;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.AuthenticateThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class EnterThe implements Task {

    private User user;


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(AuthenticateThe.buyer());
    }

    //public static EnterThe information(User user)
    public static EnterThe information(){
        return Tasks.instrumented(EnterThe.class);
    }
}