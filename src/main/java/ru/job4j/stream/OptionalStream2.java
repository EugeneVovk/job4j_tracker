package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 9.5. Optional и Stream. Метод stream()
 * В классе Optional есть методы, которые помогают работать со стримами.
 * Например, метод stream(), если значение существует,
 * то этот метод создает стрим из этого значения,
 * если нет, то возвращает пустой стрим.
 * <p>
 * Ваша задача найти тел. номера пользователя с заданным id,
 * которые начинаются с region.
 */
public class OptionalStream2 {

    public static List<PhoneNumber> collectNumber(List<User1> users, int id, String region) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .flatMap(user -> user.getNumbers().stream())
                .filter(phone -> phone.getPhone().startsWith(region))
                .collect(Collectors.toList());
    }
}
