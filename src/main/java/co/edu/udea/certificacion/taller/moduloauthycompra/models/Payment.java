package co.edu.udea.certificacion.taller.moduloauthycompra.models;

public class Payment {
    private String nameOnCard;
    private String cardNumber;
    private String cvc;
    private String expiryMonth;
    private String expiryYear;

    public Payment() {
    }

    public Payment(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvc = cvc;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }

    public static Payment defaultPayment() {
        return new Payment("Juan Perez", "4111111111111111", "123", "12", "2028");
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public void setExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public String getExpiryYear() {
        return expiryYear;
    }

    public void setExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }
}