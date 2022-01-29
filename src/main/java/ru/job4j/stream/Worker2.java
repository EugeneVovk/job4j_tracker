package ru.job4j.stream;

import java.util.LinkedList;
import java.util.List;

public class Worker2 {

    private final String passport;
    private List<Child> children;

    public Worker2(String passport, List<Child> children) {
        this.passport = passport;
        this.children = children;
    }

    public String getPassport() {
        return passport;
    }

    public List<Child> getChildren() {
        return children;
    }
}
