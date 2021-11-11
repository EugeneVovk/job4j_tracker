package ru.job4j.tracker;

/**
 * В классе StartUI есть метод init в котором содержится блок из множественного if.
 * Давайте все блоки в условии вынесем в статические методы.
 * Таким образом, мы разбиваем код на функциональные блоки.
 * Это позволит при внесении правок в код сфокусироваться только на одном методе.
 */
public class StartUI {

    /**
     * Метод init() - инициализирует приложение
     * и запускает выполнение различных пользовательских действий
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.parseInt(input.askStr("Select: "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Метод showMenu() - выводит на экран меню доступных пользовательских действий
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindItemByIdAction(),
                new FindItemByNameAction(),
                new ExitProgramAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
