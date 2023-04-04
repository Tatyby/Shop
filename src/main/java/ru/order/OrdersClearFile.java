package ru.order;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OrdersClearFile implements Order {
    public void clearFile() {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(Paths.get(nameFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
