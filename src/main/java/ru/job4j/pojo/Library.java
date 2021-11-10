package ru.job4j.pojo;

import java.util.Arrays;

/**
 * 1. Создайте модель данных "Книга" с полями: имя и количество страниц. ru.job4j.pojo.Book.
 * 2. Создайте класс ru.job4j.pojo.Library и в нем метод main.
 * 3. В методе main создайте 4 объекта Book. Добавьте их в массив.
 *    Сделайте одну книгу с именем "Clean code".
 * 4. Выведите содержимое массива на консоль через цикл for + index.
 * 5. Переставьте местами книги с индексом 0 и 3. Выведите содержимое массива на консоль.
 * 6. Добавьте цикл с выводом книг с именем "Clean code".
 * 7. Залейте код, оставьте ссылку на коммит, измените ответственного на Петра Арсентьева.
 *
 * Проверяйте название так
 * if ("Clean code".equals(shelf2[i].getName())) {
 * это позволит избежать NPE если название книги не будет задано
 */
public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Java. Полное руководство", 1488);
        Book book2 = new Book("Java. Библиотека профессионала", 864);
        Book book3 = new Book("Изучаем Java", 720);
        Book book4 = new Book("Философия Java", 1168);
        Book book5 = new Book("Clean code", 464);
        Book[] shelf = new Book[4];
        shelf[0] = book1;
        shelf[1] = book2;
        shelf[2] = book3;
        shelf[3] = book4;
        Library.info(shelf);
        Library.swap(shelf);
        Library.info(shelf);
        Book[] shelf2 = Arrays.copyOf(shelf, shelf.length + 1);
        shelf2[4] = book5;
        Library.info(shelf2);
        for (int i = 0; i < shelf2.length; i++) {
            String name = shelf2[i].getName();
            if ("Clean code".equals(shelf2[i].getName())) {
                System.out.println(name + " - " + shelf2[i].getPage());
            }
        }
    }

    public static void info(Book[] shelf) {
        for (int index = 0; index < shelf.length; index++) {
            System.out.println(shelf[index].getName() + " - " + shelf[index].getPage());
        }
        System.out.println();
    }

    public static void swap(Book[] shelf) {
        Book tmp = shelf[0];
        shelf[0] = shelf[3];
        shelf[3] = tmp;
    }
}
