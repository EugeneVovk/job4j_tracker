package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String bodyPart;

    public Surgeon(String name, String surname, String education,
                   int birthday, String diagnosis, String bodyPart) {
        super(name, surname, education, birthday, diagnosis);
        this.bodyPart = bodyPart;
    }

    public void surgery(Doctor diagnosis, String bodyPart) {
        System.out.println("My name is " + getName()
                + ". I'm a " + getEducation()
                + ". I can surgery " + bodyPart
                + " and can heal " + diagnosis);
    }

    public void surgery() {
        System.out.println("I can surgery");
    }
}
