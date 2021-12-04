package ru.job4j.stream;

/**
 * Для построения потоков при работе со Stream используется шаблон проектирования Builder
 * Это порождающий шаблон проектирования, который позволяет создавать сложные объекты пошагово.
 * Позволяет использовать один и тот же код построения объекта для получения разных представлений
 * объектов.
 */
public class User {
    private String name;
    private String surname;
    private byte age;
    private String login;
    private String password;
    private boolean activated;
    private String gender;

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", activated=" + activated
                + ", gender='" + gender + '\''
                + '}';
    }

    /* 1. добавляем вложенный статический класс Builder */
    static class Builder {
        /* 2. копируем в наш вложенный класс поля, которые объявлены внутри класса User */
        private String name;
        private String surname;
        private byte age;
        private String login;
        private String password;
        private boolean activated;
        private String gender;

        /* 3. добавление методов, которые будут инициализировать поля,
        объявленные внутри вложенного класса и при этом возвращать тип Builder */
        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildLogin(String login) {
            this.login = login;
            return this;
        }

        Builder buildPassword(String password) {
            this.password = password;
            return this;
        }

        Builder buildActivated(boolean activated) {
            this.activated = activated;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

       /* 4. Последний элемент реализации шаблона -
       метод, который построит нам готовый объект и вернет его экземпляр */
        User build() {
            User user = new User();
            user.name = name;
            user.surname = surname;
            user.age = age;
            user.login = login;
            user.password = password;
            user.activated = activated;
            user.gender = gender;
            return user;
        }
    }

    public static void main(String[] args) {
        /* Метод build() мы уже будем вызывать для того,
        чтобы вернуть готовый объект.
        Его поведение схоже с терминальными операциями в Stream API,
        которые возвращают результат из потока, а не поток, как это делают конвейерные методы
         */
        User user = new Builder()
                .buildName("name")
                .buildSurname("surname")
                .buildAge((byte) 32)
                .buildLogin("login")
                .buildPassword("password")
                .buildActivated(true)
                .buildGender("male")
                .build();
        System.out.println(user);
    }
}
