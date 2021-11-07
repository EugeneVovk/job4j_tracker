package ru.job4j.pojo;

public class Student {
    private String lastName;
    private String firstName;
    private String patronymic;
    private int group;
    private int admission;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getAdmission() {
        return admission;
    }

    public void setAdmission(int admission) {
        this.admission = admission;
    }
}
