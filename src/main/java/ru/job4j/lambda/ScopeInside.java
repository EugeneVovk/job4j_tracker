package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Код, который складывает числа массива
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int total = 0;
        for (int num : numbers) {
            int finalTotal = total;
            total = add(
                    () -> finalTotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
    }
