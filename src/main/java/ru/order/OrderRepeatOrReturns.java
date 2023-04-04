package ru.order;

import java.io.FileReader;
import java.io.IOException;

public class OrderRepeatOrReturns implements Order{

    public void repeatOrReturnOrder() {
        System.out.println("Ваш заказ: ");
        try {
            FileReader fileReader = new FileReader(nameFile);
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
            fileReader.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
