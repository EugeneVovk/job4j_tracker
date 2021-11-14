package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNegativeNumber() {
        Fact.calc(-1);
    }

    @Test
    public void when5Then120() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is(120));
    }
}