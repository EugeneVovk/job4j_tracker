package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String program;

    public Programmer(String name, String surname, String education,
                      int birthday, String task, String program) {
        super(name, surname, education, birthday, task);
        this.program = program;
    }

    public void writeCode(Engineer task, String program) {
        System.out.println("I can write the program " + program
                + " and I can do " + task);
    }

    public void writeCode() {
        System.out.println("I can write a program");
    }
}
