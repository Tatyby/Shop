package ru.Product;

import java.util.List;

public class Basket {
    public void basket(List<Product> list) {
        int sumProduct = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.isEmpty()) {
                System.out.println((i + 1) + " Наименование: " + list.get(i).getName() +
                        ", Количество " + list.get(i).getQuantity()
                        + ", Цена за единицу: " + list.get(i).getPrice() +
                        ", Общая стоимость товара: " + list.get(i).getPrice() * list.get(i).getQuantity());
            }
        }
        System.out.println("Стоимость корзины: ");
        for (int i = 0; i < list.size(); i++) {
            sumProduct += list.get(i).getPrice() * list.get(i).getQuantity();
        }
        System.out.println(sumProduct);
    }
}
