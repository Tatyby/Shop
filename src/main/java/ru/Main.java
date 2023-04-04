package ru;


import ru.Product.Basket;
import ru.Product.PrintMenu;
import ru.Product.Product;
import ru.Product.clothes.Clothes;
import ru.Product.edible_products.Edible;
import ru.Product.technic.Technic;
import ru.delivery.Deliverys;
import ru.filter.Filter;
import ru.order.OrderCreate;
import ru.order.OrderIsEmpty;
import ru.order.OrderRepeatOrReturns;
import ru.order.OrdersClearFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> list = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();
    public static String end = "end", basketInput = "basket", no = "no", yes = "yes", repeat = "повторить", returnInput = "вернуть";
    public static String input1 = "1", input2 = "2", input3 = "3", input4 = "4";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintMenu printMenu = new PrintMenu();
        Basket basket = new Basket();
        OrdersClearFile orders = new OrdersClearFile();


        list.add(new Edible("Бананы", 10, 2));
        list.add(new Edible("Огурцы", 100, 100));
        list.add(new Edible("Помидоры", 101, 101));
        list.add(new Clothes("Платье", 550, 890));
        list.add(new Clothes("Костюм", 550, 890));
        list.add(new Clothes("Джинсы", 550, 890));
        list.add(new Technic("Телефон", 550, 890));
        list.add(new Technic("Ноутбук", 550, 890));
        list.add(new Technic("Телевизор", 550, 890));

        System.out.println("Cписок возможных товаров: ");

        printList(list);

        printMenu.printMenu();


        while (true) {
            String input = scanner.nextLine();
            if (end.equalsIgnoreCase(input)) {
                break;
            }
            if (input1.equals(input)) {
                listUserWithOutFilter(scanner, basket); //создаем список от пользователя
                input = scanner.nextLine();
                createAnOrderYesNo(input, printMenu, orders);
            }
            if (input2.equals(input)) {
                printMenu.printMenuFilter();
                input = scanner.nextLine();
                Filter filter = new Filter();

                List<Product> listFilter = filter.filterСategories(list, input);
                listFilter.forEach(System.out::println);

                listUserWithFilter(scanner, basket, listFilter);

                input = scanner.nextLine();

                createAnOrderYesNo(input, printMenu, orders);
            }
            if (input3.equals(input)) {
                new Deliverys().deliveryStatus();
                printMenu.printMenuPositions4_5();
            }
            if (input4.equals(input)) {
                System.out.println("напишите \"повторить\" или \"вернуть\" заказ без кавычек");
                input = scanner.nextLine();

                if (input.equalsIgnoreCase(repeat)) {

                    if (new OrderIsEmpty().isEmptyOrder()) {
                        new OrderRepeatOrReturns().repeatOrReturnOrder();

                        System.out.println("Заказ отправлен курьеру");
                        printMenu.printMenuPosition3_5();
                    } else {
                        System.out.println("Список заказов пуст");
                        printMenu.printMenu();
                    }

                }
                if (input.equalsIgnoreCase(returnInput)) {
                    if (new OrderIsEmpty().isEmptyOrder()) {
                        new OrderRepeatOrReturns().repeatOrReturnOrder();

                        new OrdersClearFile().clearFile();

                        System.out.println("спасибо, мы приняли назад Ваш заказ");
                    } else {
                        System.out.println("Список заказов пуст");
                    }
                    printMenu.printMenu();
                }
            }

        }
    }

    public static void printList(List<Product> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(list.get(i));
        }
        System.out.println();
    }

    public static List<Product> listInput(List<Product> list, String input) {
        String[] parts = input.split(" ");
        int inputNumber = Integer.parseInt(parts[0]) - 1; //номер продукта от пользователя
        int inputCount = Integer.parseInt(parts[1]); // количество от пользователя
        int currentPrice = list.get(inputNumber).getPrice(); // текущая цена продукта под вводимым номером
        String nameNumber = list.get(inputNumber).getName();
        listProduct.add(new Product(nameNumber, (inputCount), currentPrice)); //список продуктов от пользователя
        return listProduct;
    }

    public static void listUserWithOutFilter(Scanner scanner, Basket basket) {
        while (true) {
            System.out.println("Введите номер товара и его количество или basket для просмотра корзины");
            String input = scanner.nextLine();
            if (!basketInput.equalsIgnoreCase(input)) {
                listInput(list, input); //составляем список от пользователя
            } else {
                basket.basket(listProduct);
                break;
            }
        }
        System.out.println("Заказать доставку? Yes/No");

    }

    public static void listUserWithFilter(Scanner scanner, Basket basket, List<Product> listFilter) {
        while (true) {
            System.out.println("Введите номер товара и его количество или basket для просмотра корзины");
            String input = scanner.nextLine();
            if (!basketInput.equalsIgnoreCase(input)) {
                listInput(listFilter, input);
            } else {
                basket.basket(listProduct);
                break;
            }
        }
        System.out.println("Заказать доставку? Yes/No");
    }

    public static void createAnOrderYesNo(String input, PrintMenu printMenu, OrdersClearFile orders) {
        if (no.equalsIgnoreCase(input)) {
            System.out.println("ОК, выходим из программы, напишите end");

        }
        if (yes.equalsIgnoreCase(input)) {
            System.out.println("Хорошо, Ваш заказ создан");
            new OrderCreate().createOrder(listProduct);//создали заказ в файле
            printMenu.printMenuPosition3_4_5();
        }
    }


}








