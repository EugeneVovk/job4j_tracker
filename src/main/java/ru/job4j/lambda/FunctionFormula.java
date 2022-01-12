package ru.job4j.lambda;

import java.util.function.Function;

/**
 * Вам нужно дописать лямбда выражение, которое будет подставлять переданное число в формулу
 * <p>
 * num * num + 2 * num + 1
 */
public class FunctionFormula {

    public static double calculate(double x) {
        Function<Double, Double> formula = num -> num * num + 2 * num + 1;
        return calculate(formula, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }
}
