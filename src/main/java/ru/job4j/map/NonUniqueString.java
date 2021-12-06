package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Метод принимает массив строк, в котором строки могут повторяться.
 * Необходимо перебрать массив строк и сложить их в карту.
 * При этом должны выполниться следующие условия:
 * 1. Ключом является строка.
 * 2. Значением будет булево переменная.
 * 3. Если строка встречается в массиве 2 и более раз,
 * то булево значение должно быть true.
 * В ином случае - должно принимать значение false.
 */
public class NonUniqueString {

    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strings) {
            map.computeIfPresent(str, (k, v) -> true);
            map.putIfAbsent(str, false);
        }
        return map;
    }
}
