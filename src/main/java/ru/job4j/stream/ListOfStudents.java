package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfStudents {

    public static Map<String, Student> studentList(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        key -> key.getSurname(),
                        value -> value,
                        (existing, replacement) -> existing
                ));
    }
}
