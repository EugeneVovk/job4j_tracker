package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = (left, right) -> {
            return Integer.compare(left.getSize(), right.getSize());
        };
        Arrays.sort(atts, comparator);

        Comparator<String> cmpSize = (left, right) -> {
            return Integer.compare(left.length(), right.length());
        };
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> {
            return Integer.compare(right.length(), left.length());
        };

        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };
        Comparator<String> numStr = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return first - second;
        };
        Comparator<Attachment> comp = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return left.getSize() - right.getSize();
        };
    }
}
