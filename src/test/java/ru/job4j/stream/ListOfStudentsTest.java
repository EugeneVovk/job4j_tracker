package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ListOfStudentsTest {

    @Test
    public void whenStudentList() {
        List<Student> students = List.of(
                new Student(5, "Ivanova"),
                new Student(4, "Petrova"),
                new Student(3, "Sidorov"),
                new Student(5, "Oksakov")
        );
        Map<String, Student> rsl = ListOfStudents.studentList(students);
        Map<String, Student> expected = Map.of(
                "Ivanova", new Student(5, "Ivanova"),
                "Petrova", new Student(4, "Petrova"),
                "Sidorov", new Student(3, "Sidorov"),
                "Oksakov", new Student(5, "Oksakov")
        );
        assertEquals(expected, rsl);
    }

    @Test
    public void whenStudentListExistDuplicate() {
        List<Student> students = List.of(
                new Student(5, "Ivanova"),
                new Student(4, "Petrova"),
                new Student(3, "Sidorov"),
                new Student(2, "Oksakov"),
                new Student(5, "Oksakov")
        );
        Map<String, Student> rsl = ListOfStudents.studentList(students);
        Map<String, Student> expected = Map.of(
                "Ivanova", new Student(5, "Ivanova"),
                "Petrova", new Student(4, "Petrova"),
                "Sidorov", new Student(3, "Sidorov"),
                "Oksakov", new Student(2, "Oksakov")
        );
        assertEquals(expected, rsl);
    }
}