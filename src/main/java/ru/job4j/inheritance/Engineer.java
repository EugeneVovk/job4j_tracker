package ru.job4j.inheritance;

public class Engineer extends Profession {
    private String task;

    public Engineer(String name, String surname, String education, int birthday, String task) {
        super(name, surname, education, birthday);
        this.task = task;
    }

    public String getTask() {
        return task;
    }

    public void solveTask(String task) {
        System.out.println("I can do the " + task);
    }

    public void solveTask() {
        System.out.println("I can do the task");
    }
}
