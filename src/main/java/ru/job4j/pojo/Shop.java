package ru.job4j.pojo;

/**
 * У значения null нельзя вызывать методы объекта.
 * Это приведет к ошибке NullPointerException.
 * Поэтому, если в коде есть ситуация, что переменная может содержать значение null,
 * а нам нужно с ней работать, то нужно перед выполнением операции проверить,
 * что объект не равен null.
 */
public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            }
        }
    }

    public static int indexOfNull(Product[] products) {
        int index = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                index = i;
                break;
            }
        }
        return index;
    }
}
