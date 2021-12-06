package ru.job4j.set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Вам необходимо заполнить коллекцию строками от one до five.
 * Потом заполнить пропуски (обозначены ...) так,
 * чтобы в цикле печатались строки пока они есть,
 * при этом на каждой итерации выводилось сообщение,
 * что значение существует в наборе.
 */
public class SetIterator {
    public static void main(String[] args) {
        Set<String> strings = new TreeSet<>(Set.of("one", "two", "three", "four", "five"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println(String.format("Next element exist? - %s.", true));
            System.out.println(iterator.next());
        }
    }
}
