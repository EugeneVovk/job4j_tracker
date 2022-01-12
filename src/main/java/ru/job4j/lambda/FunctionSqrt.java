package ru.job4j.lambda;

import java.util.function.Function;

/**
 * Вам нужно дописать лямбда выражение, которое извлекает корень квадратный из числа
 */
public class FunctionSqrt {

    public static double calculate(double x) {
        return calculate(Math::sqrt, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}
