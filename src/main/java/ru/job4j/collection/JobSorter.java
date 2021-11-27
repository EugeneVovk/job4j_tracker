package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        jobs.sort(new SortByNameJob());
        System.out.println(jobs);
        /*
        Комбинированный компаратор
        В интерфейсе Comparator есть метод с реализацией по умолчанию - thenComparing.
        Этот метод принимает другой компаратор.
        Таким образом, можно соединить или скомбинировать любую сортировку.
         */
        jobs.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobDescByName())
                .thenComparing(new JobDescByPriority());
        jobs.sort(comb);

        List<Job> jobs2 = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X bug", 0)
        );
        jobs2.sort(new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs2);

        Comparator<Job> compareName = Comparator.comparing(Job::getName);
        Comparator<Job> comparePriority = Comparator.comparingInt(Job::getPriority);
        /*Объект combine - это функция высшего порядка.
         Функции высшего порядка - это функции, зависящие от других функций.*/
        Comparator<Job> combine = compareName.thenComparing(comparePriority);

        jobs2.sort(combine);
        System.out.println(jobs2);
    }
}
