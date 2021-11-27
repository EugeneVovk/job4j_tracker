package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает сервис банковских переводов (основную Бизнес-Логику)
 *
 * @version 1.0
 */
public class BankService {
    /**
     * Поле принимает всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в систему
     * Этот метод принимает один параметр: пользователя.
     * По умолчанию к этому user нужно добавить пустой список - new ArrayList<Account>().
     * В методе есть проверка, что такого пользователя еще нет в системе.
     * Если он есть, то нового добавлять не надо.
     *
     * @param user пользователь, т.е. объект класса User.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый счет к пользователю
     * Первоначально пользователя нужно найти по паспорту используя метод findByPassport.
     * После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
     * В этом методе есть проверка, что такого счета у пользователя еще нет.
     *
     * @param passport номер паспорта пользователя
     * @param account  счёт пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     * Используем перебор всех элементов через цикл for-each и метод Map.keySet.
     *
     * @param passport номер паспорта пользователя
     * @return Метод возвращает пользователя или null,
     * если такого пользователя нет
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * Находим пользователя по паспорту с помощью метода findByPassport.
     * Потом получаем список счетов этого пользователя и в нем находим нужный счет.
     * Поскольку метод findByPassport может вернуть null,
     * то прежде чем получать список аккаунтов, проверяем
     * что метод findByPassport вернул отличное от null значение.
     *
     * @param passport  номер паспорта пользователя
     * @param requisite реквизиты пользователя
     * @return метод возвращает нужный счёт или null, если в такого счёта нет
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account rsl = null;
        if (user != null) {
            List<Account> list = users.get(user);
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
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * Метод принимает на вход данные (паспорт и реквизиты) отправителя и получателя,
     * а также сумму перевода
     *
     * @param scrPassport   паспорт пользователя, кто делает перевод
     * @param srcRequisite  реквизиты пользователя, кто делает перевод
     * @param destPassport  паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount        количество денег на счёте srcAccount
     * @return Если счёт не найден или не хватает денег на счёте srcAccount
     * (с которого переводят), то метод должен вернуть false, иначе true
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
