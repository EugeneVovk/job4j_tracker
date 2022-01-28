package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DistinctForObjectTest {

    @Test
    public void test() {
        User user1 = new User("A", 20);
        User user2 = new User("B", 20);
        User user3 = new User("A", 21);
        User user4 = new User("A", 20);
        assertEquals(
                List.of(user1, user2, user3),
                DistinctForObject.distinct(List.of(
                        user1, user2, user3, user4
                ))
        );
    }

}