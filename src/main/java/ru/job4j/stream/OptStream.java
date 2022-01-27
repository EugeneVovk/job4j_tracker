package ru.job4j.stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Терминальные методы поиска в Stream API возвращают объект Optional.
 * Методы поиска могут вернуть null.
 * C null объектом в потоке данных работать уже нельзя,
 * поэтому все null оборачиваются в Optional.
 * Рассмотрим метод поиска числа в массиве.
 * Метод findFirst вернет первый элемент отфильтрованного потока.
 * Если отфильтрованный поток пустой, то нужно вернуть null.
 * Поэтому здесь используется Optional.
 */
public class OptStream {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        Optional<Integer> rsl = stream
                .filter(e -> e == 5)
                .findFirst();
        if (rsl.isPresent()) {
            System.out.println(rsl.get());
        } else {
            System.out.println("Element not found.");
        }
    }
}
