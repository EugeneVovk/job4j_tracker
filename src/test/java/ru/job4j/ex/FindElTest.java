package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FindElTest {

    @Test
    public void whenElEquals0() throws ElementNotFoundException {
        String[] array = {"cat", "dog", "frog", "cow"};
        int rsl = FindEl.indexOf(array, "cat");
        assertThat(rsl, is(0));
    }

    @Test
    public void whenElEquals2() throws ElementNotFoundException {
        String[] array = {"cat", "dog", "frog", "cow"};
        int rsl = FindEl.indexOf(array, "frog");
        assertThat(rsl, is(2));
    }

    @Test
    public void whenElEquals3() throws ElementNotFoundException {
        String[] array = {"cat", "dog", "frog", "cow"};
        int rsl = FindEl.indexOf(array, "cow");
        assertThat(rsl, is(3));
    }

    @Test(expected = ElementNotFoundException.class)
    public void whenNotFindEl() throws ElementNotFoundException {
        String[] array = {"cat", "dog", "frog", "cow"};
        FindEl.indexOf(array, "dinosaur");
    }
}