package ru.job4j.oop;

/**
 * В Java ключевым словом static помечают члены (поля и методы),
 * которые принадлежат классу, а не экземпляру этого класса.
 */
public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return Math.abs(x - a);
    }

    public int divide(int a) {
        return a == 0 ? 0 : x / a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        int a = 2;
        Calculator calc = new Calculator();
        System.out.println(
                Calculator.sum(a)
        );
        System.out.println(
                calc.multiply(a)
        );
        System.out.println(
                minus(a)
        );
        System.out.println(
                calc.divide(a)
        );
        System.out.println(
                calc.sumAllOperation(a)
        );
    }
}
