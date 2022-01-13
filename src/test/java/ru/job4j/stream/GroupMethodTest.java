package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GroupMethodTest {
    @Test
    public void test() {
        User2 u1 = new User2(10, "Ivan");
        User2 u2 = new User2(10, "Boris");
        User2 u3 = new User2(15, "Semen");
        User2 u4 = new User2(20, "Petr");
        Map<Integer, List<User2>> expect = Map.of(
                10, List.of(u1, u2),
                15, List.of(u3),
                20, List.of(u4)
        );
        assertEquals(expect, GroupMethod.groupBy(
                List.of(u1, u2, u3, u4)
        ));
    }
}