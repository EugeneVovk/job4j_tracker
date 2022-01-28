package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FilterObjectTest {

    @Test
    public void test() {
        List<User> users = List.of(
                new User("Ivan", 20),
                new User("Boris", 19),
                new User("Benjamin", 18)
        );
        User user = FilterObject.filter(users).iterator().next();
        assertEquals("Boris", user.getName());
        assertEquals(19, user.getAge());
    }

}