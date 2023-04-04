package ru.filter;

import ru.Product.Product;

import java.util.List;

public interface Filters {
     List<Product> filterСategories(List<Product> list, String number);
}
