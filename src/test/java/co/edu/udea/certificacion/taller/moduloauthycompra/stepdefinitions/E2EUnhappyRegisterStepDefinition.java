package co.edu.udea.certificacion.taller.moduloauthycompra.stepdefinitions;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.CompleteRegistrationFillOnly;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.TrySubmitButPreventSubmission;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.RegAuthThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.RegisterThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.EnterAccountInfoThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.AccountCreatedThe;
import static org.hamcrest.Matchers.is;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class E2EUnhappyRegisterStepDefinition {

    public final Actor buyer = Actor.named("Alicia");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config() {
        buyer.can(BrowseTheWeb.with(theDriver));
    }





    // Escenario 1: Intentar registrarse con un correo ya registrado
    @When("el usuario intenta registrarse con nombre {string} y correo {string}")
    public void elUsuarioIntentaRegistrarseConNombreYCorreo(String nombre, String correo) {
        User user = new User();
        user.setName(nombre);
        user.setEmail(correo);

        buyer.attemptsTo(RegAuthThe.buyer());
        buyer.attemptsTo(RegisterThe.with(user));
    }

    @Then("debe mostrarse el mensaje de correo existente")
    public void debeMostrarseElMensajeDeCorreoExistente() {
        // Según la regla: si NO aparece 'Enter Account Information' => la prueba pasó (no dejó seguir)
        GivenWhenThen.then(buyer).should(seeThat(EnterAccountInfoThe.isVisible(), is(false)));
    }




    // Escenario 2: Intentar registrarse sin diligenciar campos obligatorios
    @When("el usuario intenta registrarse sin diligenciar el campo {string}")
    public void elUsuarioIntentaRegistrarseSinDiligenciarElCampo(String campo) {
        User user = new User();
        if ("name".equalsIgnoreCase(campo)) {
            user.setName("");
            user.setEmail("correo-prueba@gmail.com");
        } else {
            user.setName("Ana");
            user.setEmail("");
        }

        buyer.attemptsTo(RegAuthThe.buyer());
        buyer.attemptsTo(RegisterThe.with(user));
    }

    @Then("el navegador no debe permitir continuar con la creacion de la cuenta")
    public void elNavegadorNoDebePermitirContinuarConLaCreacionDeLaCuenta() {
        // Según la regla: para este escenario, si NO aparece 'Account Created!' => la prueba pasó (no dejó crear cuenta)
        GivenWhenThen.then(buyer).should(seeThat(AccountCreatedThe.isVisible(), is(false)));
    }





    // Escenario 3: Intentar registrarse sin diligenciar campos obligatorios en la segunda parte del formulario
    @When("el usuario completa el formulario dejando vacio el campo {string}")
    public void elUsuarioCompletaElFormularioDejandoVacioElCampo(String campo) {
        User user = User.defaultUser();
        switch (campo.toLowerCase()) {
            case "password":
                user.setPassword("");
                break;
            case "first_name":
                user.setFirstName("");
                break;
            case "last_name":
                user.setLastName("");
                break;
            case "address":
                user.setAddress("");
                break;
            case "state":
                user.setState("");
                break;
            case "city":
                user.setCity("");
                break;
            case "zipcode":
                user.setZipcode("");
                break;
            case "mobile_number":
                user.setMobileNumber("");
                break;
            default:
                break;
        }

        buyer.attemptsTo(RegAuthThe.buyer());
        buyer.attemptsTo(RegisterThe.with(user));
        buyer.attemptsTo(CompleteRegistrationFillOnly.with(user));
        buyer.attemptsTo(TrySubmitButPreventSubmission.now());
    }

    @Then("no debe mostrarse la confirmacion de creacion de cuenta")
    public void noDebeMostrarseLaConfirmacionDeCreacionDeCuenta() {
        GivenWhenThen.then(buyer).should(seeThat(AccountCreatedThe.isVisible(), is(false)));
    }
}