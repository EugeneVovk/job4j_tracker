package ru.job4j.validate;

/**
 * Валидация - это проверка параметров метода.
 * Если параметры не верные, то выполнить метод нельзя.
 * Например, метод деления на 0.
 * Если делитель равен 0, то деление выполнить нельзя.
 */
public class DivByZero {

    public static int div(int first, int second) {
        int rsl = -1;
        if (second == 0) {
            System.out.println("Div by zero, return def value -1");
        } else {
            rsl = first / second;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int rsl = div(10, 0);
        System.out.println(rsl);
    }
}
