package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс выводит на консоль список имен.
 * Если имя больше 10 символов, то вывод обрезается.
 * <p>
 * С лямбдами в Java связано еще одно упрощение.
 * Нам нужно вывести несколько элементов списка. Это можно сделать через метод forEach().
 * Метод forEach принимает объект Consumer, который описан через лямбда.
 * Интерфейс java.function. Consumer имеет абстрактный метод.
 * Мы убрали аргументы из лямбда и из вызываемого метода.
 * Вызов метода(ссылки на метод) cutOut идет через двойное двоеточие (::).
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = RefMethod::cutOut;
        names.forEach(out);
    }

    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "..");
        } else {
            System.out.println(value);
        }
    }
}
