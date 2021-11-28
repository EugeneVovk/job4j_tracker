package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage2 {

    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    /**
     * Отфильтруем все задачи, где в имени есть слово BUG и сохраним ее в коллекцию List.
     */
    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("Bug #1", 100),
                new Task("Task #2", 100),
                new Task("Bug #3", 100)
        );
        /* Мы получаем из коллекции Stream или поток элементов.
        Каждый элемент передается в метод filter().
        Метод filter() принимает объект Predicate<Task>.
        Если метод возвращает true, то элемент передается дальше.
        .collect позволяет полученный результат сохранить в коллекции типа List.
         */
        List<Task> bugs = tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .collect(Collectors.toList());
        bugs.forEach(System.out::println);
        /*Допустим, что нам нужно получить только имена задач.
        Для этого нужно применить метод map().*/
        tasks.stream()
                .filter(task -> task.name.contains("Bug"))
                .map(task -> task.name)
                .forEach(System.out::println);
        /*Давайте теперь посчитаем общее время, потраченное на все задачи.
          Каждое значение task.spent складывает с начальным значением - 0L.*/
        long total = tasks.stream()
                .map(task -> task.spent)
                .reduce(0L, Long::sum);
        System.out.println(total);
    }
}
