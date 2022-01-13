package ru.job4j.stream;

public class Pair {

    private final User3 user;
    private final Bill bill;

    public Pair(User3 user, Bill bill) {
        this.user = user;
        this.bill = bill;
    }

    public User3 getUser() {
        return user;
    }

    public Bill getBill() {
        return bill;
    }
}
