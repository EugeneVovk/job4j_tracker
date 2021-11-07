package ru.job4j.pojo;

public class ShopDrop {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.getName());
        }
        products[1] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        products[1] = products[2];
        products[2] = null;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }

    /**
     * Метод delete обнуляет ячейку по индексу, которую надо удалить
     * и сдвигает её на место последнего элемента в данном массиве.
     *
     * @param products - массив, который надо отредактировать
     * @param index    - индекс ячейки, которую надо обнулить
     * @return - возвращает отредактированный массив
     */
    public static Product[] delete(Product[] products, int index) {
        for (int i = 0; i < products.length; i++) {
            if (i == index) {
                products[i] = null;
            }
        }
        for (int i = index + 1; i < products.length; i++) {
            Product tmp = products[i - 1];
            products[i - 1] = products[i];
            products[i] = tmp;
        }
        return products;
    }
}
