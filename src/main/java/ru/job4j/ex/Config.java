package ru.job4j.ex;

public class Config {
    public static void load(String path) {

        if (path != null) {
            System.out.println("Load config by " + path);
        } else {
            throw new IllegalArgumentException("Path could not by null.");
        }
    }

    public static void main(String[] args) {
        load("jdbc://localhost:8080");
    }
}
