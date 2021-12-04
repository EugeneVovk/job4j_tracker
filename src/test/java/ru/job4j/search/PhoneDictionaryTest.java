package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void find() {
        var phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> people = phone.find("Petr");
        assertThat(people.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFind() {
        var phone = new PhoneDictionary();
        phone.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> people = phone.find("Anton");
        assertThat(people, is(empty()));
    }
}