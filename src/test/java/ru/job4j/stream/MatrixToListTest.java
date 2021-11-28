package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void matrix1() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> rsl = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, rsl);
    }

    @Test
    public void matrix2() {
        Integer[][] matrix = {
                {1},
                {2, 3},
                {4, 5, 6}
        };
        List<Integer> rsl = MatrixToList.matrixToList(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, rsl);
    }
}
