package ru.Product.technic;

import ru.Product.Product;

public class Technic extends Product {
    public Technic(String name, int quantity, int price) {
        super(name, quantity, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getQuantity() {
        return super.getQuantity();
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setQuantity(int quantity) {
        super.setQuantity(quantity);
    }

    @Override
    public void setPrice(int price) {
        super.setPrice(price);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
