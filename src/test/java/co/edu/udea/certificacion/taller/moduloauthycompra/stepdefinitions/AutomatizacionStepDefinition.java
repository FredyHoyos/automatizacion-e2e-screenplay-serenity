package co.edu.udea.certificacion.taller.moduloauthycompra.stepdefinitions;

import co.edu.udea.certificacion.taller.moduloauthycompra.questions.ValidationThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.tasks.EnterThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.tasks.OpenThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class AutomatizacionStepDefinition {

    public final Actor Buyer = Actor.named("Juanito");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        Buyer.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    /*
    @Given("This method is responsible for parameterizing the instantiation of chromedriver")
    public void thisMethodIsResponsibleForParameterizingTheInstantiationOfChromedriver() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.browserOn().thePageNamed("pages.swaglabsUrl"));
    }
     */

    @Given("que el usuario ingresa a la pagina")
    public void queElUsuarioIngresaALaPagina() {
        Buyer.attemptsTo(OpenThe.browser());
        //throw new io.cucumber.java.PendingException();
    }
    @When("selecciona la opcion de registro")
    public void seleccionaLaOpcionDeRegistro() {
        // Esto es para el login
        Buyer.attemptsTo(EnterThe.information());
        //throw new io.cucumber.java.PendingException();
    }
    @When("completa el formulario correctamente")
    public void completaElFormularioCorrectamente() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("la cuenta debe crearse exitosamente")
    public void laCuentaDebeCrearseExitosamente() {
        //tambien hacerlo con validacion de Matcher cuando se devuelva un string y no un bool.
        GivenWhenThen.then(Buyer).should(seeThat(ValidationThe.productsPage()));
        //throw new io.cucumber.java.PendingException();
    }


}
