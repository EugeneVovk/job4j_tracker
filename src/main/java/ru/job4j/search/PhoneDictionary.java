package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> people = new ArrayList<>();

    public void add(Person person) {
        this.people.add(person);
    }

    /**
     * Вернуть список всех пользователей,
     * которые содержат key в любых полях
     *
     * @param key - Поиск ключа.
     * @return - Список подошедших пользователей.
     */
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (key.contains(person.getName())
                    || key.contains(person.getSurname())
                    || key.contains(person.getPhone())
                    || key.contains(person.getAddress())) {
                result.add(person);
            }
        }
        return result;
    }
}
