package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        /*
        С помощью интерфейса Supplier создадим строку и выведем ее в консоль
         */
        Supplier<String> sup = () -> "New String For Interface";
        System.out.println(sup.get());

        /*
        С помощью интерфейса Supplier создадим HashSet строк из списка
         */
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup2 = () -> new HashSet<>(list);
        Set<String> strings = sup2.get();
        for (String s : strings) {
            System.out.println(s);
        }

        /*
        С помощью интерфейса Consumer создадим строку и выведем ее в консоль
         */
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());

        /*
        С помощью интерфейса BiConsumer создадим строку и выведем ее в консоль
         */
        BiConsumer<String, String> consumer2 = (s1, s2) -> System.out.println(s1 + s2);
        consumer2.accept(sup.get(), " and Second String");

        /*
        Важно понимать – параметры в BiConsumer могут быть разных типов
         */
        BiConsumer<Integer, String> consOthers = (s1, s2) -> System.out.println(s1 + s2);
        int i = 1;
        for (String s : strings) {
            consOthers.accept(i++, " is " + s);
        }

        /*
        Проверим не является ли передаваемая строка пустой
         */
        Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));

        /*
        В данном случае мы проверяем что в нашей строке содержится передаваемое число,
        которое мы предварительно преобразуем в строку.
         */
        BiPredicate<String, Integer> cond = (s, num) -> s.contains(num.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));

        /*
        Попробуем прочитать символ с определенным индексом в строке
         */
        Function<String, Character> func = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + func.apply("first"));
        System.out.println("Третий символ в строке: " + func.apply("second"));

        /*
        Давайте попробуем воспользоваться возможностями Bi-формы функционального интерфейса,
        при этом типы принимаемых значений не будут совпадать:
         */
        BiFunction<String, Integer, String> biFunc =
                (s, num) -> s.concat(" ").concat(num.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));

        /*
        Используем функциональный интерфейс UnaryOperator для того, чтобы перевернуть строку
         */
        UnaryOperator<StringBuilder> sb = b -> b.reverse();
        System.out.println("Строка после реверса: "
                + sb.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: "
                + sb.apply(new StringBuilder("tset rof gnirtS")));

        /*
        Применение BinaryOperator рассмотрим на примере объединения двух строк
         */
        BinaryOperator<StringBuilder> builder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}
