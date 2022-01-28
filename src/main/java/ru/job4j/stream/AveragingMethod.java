package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Группировка элементов и среднее значение.
 * Метод averagingDouble()
 *
 * Collectors.averagingDouble() подсчитывает среднее значение элементов в группе.
 * В качестве аргумента принимает функцию,
 * в которой мы должны указать, как преобразовать элемент в double.
 *
 * Ваша задача найти для каждой компании средний возраст сотрудников.
 */
public class AveragingMethod {
    public static Map<String, Double> averaging(List<Worker> workers) {
        return workers.stream()
                .collect(Collectors.groupingBy(worker -> worker.getCompany().getName(),
                        Collectors.averagingDouble(Worker::getAge)));
    }
}
