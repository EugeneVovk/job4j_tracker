package ru.job4j.stream;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2.5. Сборка элементов.
 * Сборка в произвольную реализацию Collection
 * <p>
 * Методы toList(), toSet() формируют нам уже заданную коллекцию.
 * toList() создает ArrayList, toSet() создает HashSet.
 * Если нам нужно использовать заданную нами коллекцию мы можем использовать
 * методы collect() и Collectors.toCollection()
 * <p>
 * Например,
 * List<Integer> result = List.of(1, 2).stream()
 * .collect(Collectors.toCollection(LinkedList::new));
 * В качестве аргумента мы указываем создание пустой коллекции,
 * в которую будут собираться наши значения.
 * В примере выше мы получим реализацию List, но только теперь LinkedList.
 * <p>
 * Ваша задача создать из стрима коллекцию LinkedHashSet
 */
public class CollectToAnyCollection {
    public static Set<Integer> collect(Stream<Integer> data) {
        return data.collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
