package ru.job4j.stream;

/**
 * Анкета клиента описывается моделью
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
