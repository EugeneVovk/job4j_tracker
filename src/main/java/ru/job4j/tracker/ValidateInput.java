package ru.job4j.tracker;

/**
 * Класс ValidateInput - он получает данные из системы ввода
 * до тех пор, пока не введут правильные символы.
 * <p>
 * Запомните! Если у Вас стоит вопрос, что выбрать -
 * организовать проверку с помощью if() или использовать блок catch с исключением
 * - то выбирать стоит второе. Поскольку такой вариант работает быстрее
 * и нам не требуется писать код для дополнительной проверки.
 */
public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input in) {
        this.out = out;
        this.in = in;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again ");
            }
        } while (invalid);
        return value;
    }
}
