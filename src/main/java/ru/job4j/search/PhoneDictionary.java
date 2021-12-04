package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

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
        Predicate<Person> predName = person -> key.contains(person.getName());
        Predicate<Person> predSurname = person -> key.contains(person.getSurname());
        Predicate<Person> predPhone = person -> key.contains(person.getPhone());
        Predicate<Person> predAddress = person -> key.contains(person.getAddress());
        Predicate<Person> combine =
                predName.or(predSurname)
                        .or(predPhone)
                        .or(predAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : people) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
