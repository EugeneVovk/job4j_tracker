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

    public static void main(String[] args) {
        System.out.println(
                Calculator.sum(10)
        );
        Calculator calc = new Calculator();
        System.out.println(
                calc.multiply(5)
        );
    }
}
