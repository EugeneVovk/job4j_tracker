package ru.job4j.ex;

public class JdbcConfig {

    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("Url could not be null");
        }
    }

    /**
     * Блок try содержит операторы, которые мы хотим выполнить.
     * Блок catch содержит объявление исключение.
     * Если операторы в блоке try вызовут исключение UserInputException,
     * то программа перейдет к выполнению блока catch.
     * В блоке catch написан только один оператор.
     * Этот оператор выведет на консоль стек вызовов методов
     * от начала программы до оператора, который вызвал прерывания.
     */
    public static void main(String[] args) {
        try {
            load("jdbc://localhost:8080");
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}
