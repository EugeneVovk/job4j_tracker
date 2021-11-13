package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        new Fact().calc(-1);
    }

    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorials of negative integers are undefined");
        }
        int rsl = 1;
        for (int i = 1; i <= n; i++) {
            rsl *= i;
        }
        return rsl;
    }
}
