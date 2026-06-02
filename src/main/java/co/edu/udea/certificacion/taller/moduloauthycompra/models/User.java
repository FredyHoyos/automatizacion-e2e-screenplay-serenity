package co.edu.udea.certificacion.taller.moduloauthycompra.models;

import java.util.UUID;

public class User {
    private String name;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;

    public User() {
        // Constructor vacío para permitir creación del modelo y llenado por setters.
    }

    public static User defaultUser() {
        User user = new User();
        user.setName("Juanito");
        user.setEmail("juanito." + UUID.randomUUID().toString().substring(0, 8) + "@gmail.com");
        user.setPassword("Password123");
        user.setFirstName("Juan");
        user.setLastName("Perez");
        user.setAddress("Calle 123 #45-67");
        user.setCountry("India");
        user.setState("Antioquia");
        user.setCity("Medellin");
        user.setZipcode("050001");
        user.setMobileNumber("3001234567");
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
