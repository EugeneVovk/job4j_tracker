package ru.job4j.ex;

/**
 * Все исключения (проверяемые и непроверяемые) в основе иерархии
 * наследуются от класса java.lang.Exception.
 * Давайте сделаем наследника UserInputException.
 * Класс java.lang.Exception имеет конструктор по умолчанию.
 * Я рекомендую всегда добавлять конструктор с текстом.
 * При использовании вашего исключения нужно будет добавить детальную информацию
 * о возникновении исключения, а не просто получить пустой вывод.
 */
public class UserInputException extends Exception {

    public UserInputException(String msg) {
        super(msg);
    }
}
