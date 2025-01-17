package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Необходимо заполнить пропуски (обозначены ...) так,
 * чтобы в консоль были выведены все значения отображения по ключу.
 * При этом необходимо использовать метод keySet() и get().
 */
public class KeySet {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>(
                Map.of(
                        1, "root@root",
                        2, "local@local",
                        3, "host@host"
                )
        );
        for (int key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
