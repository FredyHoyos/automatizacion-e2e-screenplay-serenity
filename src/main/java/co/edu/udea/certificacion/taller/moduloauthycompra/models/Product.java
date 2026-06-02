package co.edu.udea.certificacion.taller.moduloauthycompra.models;

public class Product {
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public static Product blueTop() {
        return new Product("Blue Top");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}