package ru.job4j.lambda;

import java.util.function.Predicate;

/**
 * Вам нужно дописать лямбда выражение, которое проверяет, что число четное и положительное
 */
public class PredicateCheckEvenAndPositive {

    public static boolean check(int num) {
        return check(n -> (n % 2 == 0 && n > 0), num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }
}
