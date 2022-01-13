package ru.job4j.stream;

import java.util.List;

public class User3 {

    private final String name;
    private final List<Bill> bills;

    public User3(String name, List<Bill> bills) {
        this.name = name;
        this.bills = bills;
    }

    public String getName() {
        return name;
    }

    public List<Bill> getBills() {
        return bills;
    }
}
