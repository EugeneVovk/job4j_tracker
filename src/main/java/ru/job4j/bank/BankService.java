package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный сервис
 * это Java класс, который предоставляет основную Бизнес-Логику
 */
public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод должен добавить пользователя в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * метод должен добавить новый счет к пользователю
     *
     * @param passport - паспорт пользователя
     * @param account  - счёт пользователя
     */
    public void addAccount(String passport, Account account) {
        /*Первоначально пользователя нужно найти по паспорту.
        Для этого нужно использовать метод findByPassport.
        После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
        В этом методе должна быть проверка, что такого счета у пользователя еще нет.
         */
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        if (user.getPassport().equals(passport)) {
            list.add(account);
        }
    }

    /**
     * метод ищет пользователя по номеру паспорта
     */
    public User findByPassport(String passport) {
        /*Здесь нужно использовать перебор всех элементов через цикл for-each и метод Map.keySet*/
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.contains(user.getPassport())) {
                rsl = user;
            }
        }

        return rsl;
    }

    /**
     * метод ищет счет пользователя по реквизитам
     */
    public Account findByRequisite(String passport, String requisite) {
        /*Сначала нужно найти пользователя по паспорту с помощью метода findByPassport.
        Потом получить список счетов этого пользователя и в нем найти нужный счет.
        Поскольку метод findByPassport может вернуть null,
        то прежде чем получать список аккаунтов,
        требуется проверить что метод findByPassport вернул отличное от null значение.
         */
        User user = findByPassport(passport);
        List<Account> list = users.get(user);
        Account rsl = null;
        if (user != null) {
            for (Account account : list) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт
     *
     * @param amount - количество денег на счёте srcAccount
     * @return - Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false.
     */
    public boolean transferMoney(String scrPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account scr = findByRequisite(scrPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (scr != null && dest != null && scr.getBalance() >= amount) {
            dest.setBalance(dest.getBalance() + amount);
            scr.setBalance(scr.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    public static void main(String[] args) {
        User user1 = new User("3434", "Petr Arsentev");
        BankService bank = new BankService();
        bank.addUser(user1);
        bank.addAccount(user1.getPassport(), new Account("5546", 150D));
        bank.addAccount(user1.getPassport(), new Account("5546", 100D));
        System.out.println(user1.getPassport() + " - " + user1.getUsername());

    }
}
