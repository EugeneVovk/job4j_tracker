package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> comp = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return right.length() - left.length();
        };
    }
}
