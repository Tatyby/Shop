package ru.Product;

public class Product implements Products {
    private String name;
    private int quantity; // количество
    private int price;

    public Product(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Продукт: " +
                "Наименование = " + name +
                ", Количество в шт.= " + quantity +
                ", стоимость за единицу = " + price + " руб./шт.";
    }
}
