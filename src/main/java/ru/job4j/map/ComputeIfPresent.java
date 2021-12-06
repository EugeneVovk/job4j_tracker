package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Метод принимает два отображения, которые имеют одинаковый размер:
 * 1. Ключ - тип Integer, значение - тип String.
 * При этом значение - это Имя, ключ - возрастающая последовательность, начиная с 1
 * 2. Ключ - тип Integer, значение - тип String.
 * При этом значение - это Фамилия, ключ - возрастающая последовательность, начиная с 1
 * Необходимо пройтись по первому отображению и к значению имени добавить значение фамилии,
 * чтобы на выходе получилось отображение - ключ(число) - значение(строка - имя + фамилия).
 */
public class ComputeIfPresent {

    public static Map<Integer, String> collectData(
            Map<Integer, String> name, Map<Integer, String> surname) {
        for (int id : name.keySet()) {
            name.computeIfPresent(id, (key, value) -> value + " " + surname.get(id));
        }
        return name;
    }

    public static void main(String[] args) {
        Map<Integer, String> name = new HashMap<>(Map.of(1, "Bill", 2, "Donald"));
        Map<Integer, String> surname = new HashMap<>(Map.of(1, "Clinton", 2, "Trump"));
        Map<Integer, String> rsl = ComputeIfPresent.collectData(name, surname);
        rsl.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
