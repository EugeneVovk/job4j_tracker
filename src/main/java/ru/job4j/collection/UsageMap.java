package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        /*Вставить данные в карту можно используя метод put.*/
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        /*Обновление пары.*/
        map.put("parsentev@yandex.ru", "Petr Arsentev Sergeevich");
        /*Удаление происходит по ключу через метод remove(key)*/
        map.remove("parsentev@yandex.ru");
        /*Вывести все элементы на печать или итерироваться по элементам.*/
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
        map.put("eugenevovk@gmail.com", "Vovk Evgeniy Nokolaevich");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
