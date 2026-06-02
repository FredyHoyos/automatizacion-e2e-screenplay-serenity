package co.edu.udea.certificacion.taller.moduloauthycompra.interactions;

import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.*;

public class CompleteRegistrationThe implements Interaction {

    private final User user;

    public CompleteRegistrationThe(User user) {
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Wait.aLittelBitTime(3000);
        actor.attemptsTo(Click.on(GENDER_MR));
        actor.attemptsTo(Enter.theValue(user.getPassword()).into(PASSWORD));
        actor.attemptsTo(SelectFromOptions.byVisibleText("10").from(DAYS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("October").from(MONTHS));
        actor.attemptsTo(SelectFromOptions.byVisibleText("1995").from(YEARS));
        actor.attemptsTo(Enter.theValue(user.getFirstName()).into(FIRST_NAME));
        actor.attemptsTo(Enter.theValue(user.getLastName()).into(LAST_NAME));
        actor.attemptsTo(Enter.theValue(user.getAddress()).into(ADDRESS));
        actor.attemptsTo(SelectFromOptions.byVisibleText(user.getCountry()).from(COUNTRY));
        actor.attemptsTo(Enter.theValue(user.getState()).into(STATE));
        actor.attemptsTo(Enter.theValue(user.getCity()).into(CITY));
        actor.attemptsTo(Enter.theValue(user.getZipcode()).into(ZIPCODE));
        actor.attemptsTo(Enter.theValue(user.getMobileNumber()).into(MOBILE_NUMBER));
        Wait.aLittelBitTime(1000);
        actor.attemptsTo(Click.on(CREATE_ACCOUNT_BUTTON));
    }

    public static CompleteRegistrationThe with(User user) {
        return Tasks.instrumented(CompleteRegistrationThe.class, user);
    }
}