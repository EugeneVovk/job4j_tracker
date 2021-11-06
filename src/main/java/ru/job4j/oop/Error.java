package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void info() {
        System.out.println(this.active
                + " - " + this.status
                + " - " + this.message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 1, "AE");
        Error error3 = new Error(false, 0, "NPE");
        Error error4 = new Error(false, 0, "OBE");
        error1.info();
        error2.info();
        error3.info();
        error4.info();
    }
}
