package ru.job4j.stream;

import java.util.List;

/**
 * Класс Pupil описывает ученика.
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Pupil{"
                + "name='" + name + '\''
                + ", subjects=" + subjects
                + '}';
    }
}
