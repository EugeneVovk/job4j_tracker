package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> list = users.get(user.get());
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта
     *
     * @param passport номер паспорта пользователя
     * @return Метод возвращает пользователя или null,
     * если такого пользователя нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
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
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return Optional.empty();
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
        Optional<Account> scr = findByRequisite(scrPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (scr.isPresent() && dest.isPresent() && scr.get().getBalance() >= amount) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            scr.get().setBalance(scr.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}
