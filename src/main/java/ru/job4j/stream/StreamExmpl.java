package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExmpl {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-1);
        nums.add(4);
        nums.add(9);
        nums.add(-65);
        nums.add(23);
        nums.add(0);
        nums.add(-14);
        nums.add(4);
        nums.add(12);
        nums.add(-10);
        nums.add(52);
        nums.add(22);
        nums.add(-8);
        nums.add(32);
        nums.add(-112);
        List<Integer> list = nums.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
    }
}
