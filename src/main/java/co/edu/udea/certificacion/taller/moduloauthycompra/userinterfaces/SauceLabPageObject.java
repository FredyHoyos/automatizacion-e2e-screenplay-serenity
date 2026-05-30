package co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
public class SauceLabPageObject {

    public static final Target INPUT_USER_TEXT = Target.the("Text user")
            .locatedBy("//*[@data-qa='login-email']");

    public static final Target INPUT_PASSWORD_TEXT = Target.the("Text password")
            .locatedBy("//*[@data-qa='login-password']");

    public static final Target BUTTON_LOG_IN = Target.the("Button log in")
            .locatedBy("//*[@data-qa='login-button']");

    public static final Target TITLE_LOG_IN = Target.the("Text password")
            .locatedBy("//*[contains(text(),'Logged in as')]");

}