package co.edu.udea.certificacion.taller.moduloauthycompra.stepdefinitions;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.CompletePaymentThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.CompleteRegistrationThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.ContinueThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.RegAuthThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.NavigateToProductsThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.ProceedToCartThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.ProceedToCheckoutThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.RegisterThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.SelectProductThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.Payment;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.Product;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.OrderConfirmationThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.AccountCreatedThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.tasks.OpenThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces.SauceLabPageObject.TITLE_CREATE_ACCOUNT;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class E2EHappyPathStepDefinition {

    public final Actor buyer = Actor.named("Juanito");
    private final User user = User.defaultUser();
    private final Product product = Product.blueTop();
    private final Payment payment = Payment.defaultPayment();

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        buyer.can(BrowseTheWeb.with(theDriver));
    }

    @Given("que el usuario abre la pagina de Automation Exercise")
    public void queElUsuarioIngresaALaPagina() {
        buyer.attemptsTo(OpenThe.browser());
    }

    @When("el usuario crea un usuario nuevo")
    public void elUsuarioCreaUnUsuarioNuevo() {
        buyer.attemptsTo(RegAuthThe.buyer());
        buyer.attemptsTo(RegisterThe.with(user));
    }

    @When("completa el formulario de registro con sus datos personales")
    public void completaElFormularioDeRegistroConSusDatosPersonales() {
        buyer.attemptsTo(CompleteRegistrationThe.with(user));
    }

    @When("confirma la creacion de la cuenta")
    public void confirmaLaCreacionDeLaCuenta() {
        // Espera explícita a que el título de 'Account Created!' sea visible antes de afirmar.
        buyer.attemptsTo(WaitUntil.the(TITLE_CREATE_ACCOUNT, isVisible()).forNoMoreThan(10).seconds());
        GivenWhenThen.then(buyer).should(seeThat(AccountCreatedThe.isVisible()));
        buyer.attemptsTo(ContinueThe.page());
    }

    @When("navega a la seccion de productos")
    public void navegaALaSeccionDeProductos() {
        buyer.attemptsTo(NavigateToProductsThe.page());
    }

    @When("agrega el producto Blue Top al carrito")
    public void agregaElProductoBlueTopAlCarrito() {
        buyer.attemptsTo(SelectProductThe.with(product));
    }

    @When("procede al carrito de compras")
    public void procedeAlCarritoDeCompras() {
        buyer.attemptsTo(ProceedToCartThe.page());
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        buyer.attemptsTo(ProceedToCheckoutThe.page());
    }

    @When("ingresa los datos de pago")
    public void ingresaLosDatosDePago() {
        buyer.attemptsTo(CompletePaymentThe.with(payment));
    }

    @Then("la orden de compra debe confirmarse exitosamente")
    public void laOrdenDeCompraDebeConfirmarseExitosamente() {
        GivenWhenThen.then(buyer).should(seeThat(OrderConfirmationThe.isVisible()));
    }
}