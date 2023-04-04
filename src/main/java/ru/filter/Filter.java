package ru.filter;

import ru.Product.Product;
import ru.Product.clothes.Clothes;
import ru.Product.edible_products.Edible;
import ru.Product.technic.Technic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Filter implements Filters {
   // String input1 = "a", input2 = "b", input3 = "c";

    @Override
    public List<Product> filterСategories(List<Product> list, String number) {

        List<Product> listresult = new ArrayList<>();


        switch (number) {
            case "a":
                listresult = list.stream()
                        .filter(x -> x instanceof Clothes)
                        .collect(Collectors.toList());
                break;
            case "b":
                listresult = list.stream()
                        .filter(x -> x instanceof Technic)
                        .collect(Collectors.toList());
                break;
            case "c":
                listresult = list.stream()
                        .filter(x -> x instanceof Edible)
                        .collect(Collectors.toList());
                break;

        }
        return listresult;
    }


}


