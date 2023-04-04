package ru.order;

import ru.Product.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OrderCreate implements Order {
    public void createOrder(List<Product> list) {

        try {
            FileWriter writer = new FileWriter(nameFile, false);
            for (Product product : list) {
                String name = product.getName();
                int quantity = product.getQuantity();
                int price = product.getPrice() * product.getQuantity();


                writer.write("Наименование: " + name + " количество: " + quantity + " Общей стоимостью: " +
                        price);
                writer.write('\n');
            }
            int sumProduct = 0;
            for (int i = 0; i < list.size(); i++) {
                sumProduct += list.get(i).getPrice() * list.get(i).getQuantity();
            }
            writer.write("Общая стоимость корзины: " + sumProduct);
            writer.write('\n');

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
