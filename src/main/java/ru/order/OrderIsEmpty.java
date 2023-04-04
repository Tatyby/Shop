package ru.order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OrderIsEmpty implements Order {
    public Boolean isEmptyOrder() {
        try {
            File file = new File(nameFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (br.readLine() != null) {
                return true;
            }
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
