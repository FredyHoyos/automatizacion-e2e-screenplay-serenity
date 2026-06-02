package co.edu.udea.certificacion.taller.moduloauthycompra.stepdefinitions;

import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.AuthenticateThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.CompletePaymentThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.NavigateToProductsThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.ProceedToCartThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.ProceedToCheckoutThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.interactions.SelectProductThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.Payment;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.Product;
import co.edu.udea.certificacion.taller.moduloauthycompra.models.User;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.ValidationThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.questions.OrderConfirmationThe;
import co.edu.udea.certificacion.taller.moduloauthycompra.tasks.OpenThe;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

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
    @When("el usuario inicia sesion con su cuenta registrada")
    public void elUsuarioIniciaSesionConSuCuentaRegistrada() {
        buyer.attemptsTo(AuthenticateThe.with(user));
        GivenWhenThen.then(buyer).should(seeThat(ValidationThe.loggedIn()));
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