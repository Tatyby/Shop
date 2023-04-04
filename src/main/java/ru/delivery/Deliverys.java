package ru.delivery;

import java.util.concurrent.TimeUnit;

public class Deliverys implements Delivery {
    private int sekondSleep = 3;

    @Override
    public void deliveryStatus() {

        System.out.println("Заказ собран...");
        sleep(sekondSleep);
        System.out.println("Заказ передан курьеру...");
        sleep(sekondSleep);
        System.out.println("Заказ доставлен...");
    }

    private void sleep(int x) {
        try {
            TimeUnit.SECONDS.sleep(x);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
