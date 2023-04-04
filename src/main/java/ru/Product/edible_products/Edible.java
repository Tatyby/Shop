package ru.Product.edible_products;

import ru.Product.Product;

public class Edible extends Product {
    public Edible(String name, int quantity, int price) {
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
