package ru.job4j.stream;

import java.util.List;

public class User1 {

    private int id;
    private List<PhoneNumber> numbers;

    public User1(int id, List<PhoneNumber> numbers) {
        this.id = id;
        this.numbers = numbers;
    }

    public int getId() {
        return id;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }
}
