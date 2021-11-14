package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindTest {

    @Test
    public void whenOThenOne() {
        String[] data = {"one", "two", "three"};
        String rsl = Find.get(data, 0);
        String expected = "one";
        assertEquals(expected, rsl);
    }

    @Test(expected = IllegalArgumentException.class)
    public void when3ThenThrowExc() {
        String[] data = {"one", "two", "three"};
        Find.get(data, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenMinus1ThenThrowExc() {
        String[] data = {"one", "two", "three"};
        Find.get(data, -1);
    }
}