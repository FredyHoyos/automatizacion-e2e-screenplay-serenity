package co.edu.udea.certificacion.taller.moduloauthycompra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
public class SauceLabPageObject {

    private SauceLabPageObject() {
    }


       // Navbar
    public static final Target SIGNUP_LOGIN_BTN = Target.the("signup login button")
        .locatedBy("//a[@href='/login']");

    public static final Target PRODUCTS_BTN = Target.the("products button")
        .locatedBy("//a[@href='/products']");

    public static final Target CART_BTN = Target.the("cart button")
        .locatedBy("//a[@href='/view_cart']");

    // Login
    public static final Target LOGIN_EMAIL = Target.the("login email")
        .locatedBy("//input[@data-qa='login-email']");

    public static final Target LOGIN_PASSWORD = Target.the("login password")
        .locatedBy("//input[@data-qa='login-password']");

    public static final Target LOGIN_BUTTON = Target.the("login button")
        .locatedBy("//button[@data-qa='login-button']");

    // Signup paso 1
    public static final Target SIGNUP_NAME = Target.the("signup name")
        .locatedBy("//input[@data-qa='signup-name']");

    public static final Target SIGNUP_EMAIL = Target.the("signup email")
        .locatedBy("//input[@data-qa='signup-email']");

    public static final Target SIGNUP_BUTTON = Target.the("signup button")
        .locatedBy("//button[@data-qa='signup-button']");

    // Signup paso 2
    public static final Target GENDER_MR = Target.the("gender mr")
        .locatedBy("//input[@id='id_gender1']");

    public static final Target PASSWORD = Target.the("password")
        .locatedBy("//input[@data-qa='password']");

    public static final Target DAYS = Target.the("days")
        .locatedBy("//select[@data-qa='days']");

    public static final Target MONTHS = Target.the("months")
        .locatedBy("//select[@data-qa='months']");

    public static final Target YEARS = Target.the("years")
        .locatedBy("//select[@data-qa='years']");

    public static final Target FIRST_NAME = Target.the("first name")
        .locatedBy("//input[@data-qa='first_name']");

    public static final Target LAST_NAME = Target.the("last name")
        .locatedBy("//input[@data-qa='last_name']");

    public static final Target ADDRESS = Target.the("address")
        .locatedBy("//input[@data-qa='address']");

    public static final Target COUNTRY = Target.the("country")
        .locatedBy("//select[@data-qa='country']");

    public static final Target STATE = Target.the("state")
        .locatedBy("//input[@data-qa='state']");

    public static final Target CITY = Target.the("city")
        .locatedBy("//input[@data-qa='city']");

    public static final Target ZIPCODE = Target.the("zipcode")
        .locatedBy("//input[@data-qa='zipcode']");

    public static final Target MOBILE_NUMBER = Target.the("mobile number")
        .locatedBy("//input[@data-qa='mobile_number']");

    public static final Target CREATE_ACCOUNT_BUTTON = Target.the("create account button")
        .locatedBy("//button[@data-qa='create-account']");

    public static final Target TITLE_CREATE_ACCOUNT = Target.the("Confirmation account created")
        .locatedBy("//*[contains(text(),'Account Created!')]");

    // Cuenta creada
    public static final Target CONTINUE_BUTTON = Target.the("continue button")
        .locatedBy("//a[@data-qa='continue-button']");

    // Anuncio
    public static final Target AD_IFRAME = Target.the("ad iframe")
        .locatedBy("//iframe[@id='aswift_1']");

    // Login exitoso
    public static final Target TITLE_LOG_IN = Target.the("Confirmation log in")
       .locatedBy("//*[contains(text(),'Logged in as')]");

    // Productos
    public static final Target ADD_TO_CART_FIRST = Target.the("add to cart first product")
        .locatedBy("(//a[@data-product-id='1' and contains(@class,'add-to-cart')])[1]");

    public static final Target CONTINUE_SHOPPING_BTN = Target.the("continue shopping")
        .locatedBy("//button[contains(@class,'close-modal')]");

    // Carrito
    public static final Target PROCEED_TO_CHECKOUT_BTN = Target.the("proceed to checkout")
        .locatedBy("//a[contains(@class,'check_out')]");

    public static final Target COMMENT_BOX = Target.the("comment box")
        .locatedBy("//textarea[@name='message']");

    public static final Target PLACE_ORDER_BTN = Target.the("place order button")
        .locatedBy("//a[contains(text(),'Place Order')]");

    // Pago
    public static final Target NAME_ON_CARD = Target.the("name on card")
        .locatedBy("//input[@data-qa='name-on-card']");

    public static final Target CARD_NUMBER = Target.the("card number")
        .locatedBy("//input[@data-qa='card-number']");

    public static final Target CARD_CVC = Target.the("card cvc")
        .locatedBy("//input[@data-qa='cvc']");

    public static final Target EXPIRY_MONTH = Target.the("expiry month")
        .locatedBy("//input[@data-qa='expiry-month']");

    public static final Target EXPIRY_YEAR = Target.the("expiry year")
        .locatedBy("//input[@data-qa='expiry-year']");

    public static final Target PAY_BUTTON = Target.the("pay button")
        .locatedBy("//button[@data-qa='pay-button']");

    // Confirmacion
    public static final Target ORDER_CONFIRMATION = Target.the("order confirmation")
        .locatedBy("//h2[@data-qa='order-placed']");

    // Validaciones
    public static final Target INFO_EMAIL_EXIST = Target.the("EXISTING EMAIL ADDRESS")
        .locatedBy("//*[contains(text(),'Email Address already exist!')]");

    public static final Target INFO_SECOND_FORM = Target.the("Second form")
        .locatedBy("//*[contains(text(),'Enter Account Information')]");
}