package co.edu.udea.certificacion.taller.moduloauthycompra.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class StepDefinition {

    @Before
    public void config(){
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
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("selecciona la opcion de registro")
    public void seleccionaLaOpcionDeRegistro() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("completa el formulario correctamente")
    public void completaElFormularioCorrectamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("la cuenta debe crearse exitosamente")
    public void laCuentaDebeCrearseExitosamente() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
