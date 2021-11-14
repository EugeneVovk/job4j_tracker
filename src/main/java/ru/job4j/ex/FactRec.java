package ru.job4j.ex;

/**
 * java.lang.StackOverflowError - ошибка связана с переполнением области памяти stack.
 * В ней хранятся ссылки на объекты, локальные переменные и вызовы функций.
 * Часто можно увидеть при использовании рекурсии.
 * <p>
 * Решение проблемы. Поиск логической ошибки в коде.
 */
public class FactRec {

    public static int calc(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return calc(n - 1) * n;
    }

    public static void main(String[] args) {
        int rsl = calc(5);
        System.out.println(rsl);
    }
}
