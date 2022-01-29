package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Класс SqlTracker будет подключаться к базе данных,
 * создавать в ней записи, редактировать, читать и удалять.
 * Класс SqlTracker реализовывает интерфейс Store,
 * а также интерфейс AutoCloseable, т.к. нам нужно обеспечить
 * закрытие ресурса - подключения к базе данных.
 * Помимо реализованных методов интерфейсов есть метод init():
 * <p>
 * Для считывания файлов используйте ClassLoader.
 * Данный класс позволяет искать ресурсы в папке resources.
 * Метод getResourcesAsStream() возвращает поток ввода для файла,
 * который находится в папке resources, с указанным именем.
 * <p>
 * Для вставки и получения даты используйте методы JDBC
 * setTimestamp(), getTimestamp().
 * Ниже приведен пример преобразования Timestamp и LocalDateTime
 * - Из Timestamp в LocalDateTime:
 * long millis=System.currentTimeMillis();
 * Timestamp timestamp = new Timestamp(millis);
 * LocalDateTime localDateTime = timestamp.toLocalDateTime();
 * - Из LocalDateTime в Timestamp:
 * Timestamp timestampFromLDT = Timestamp.valueOf(localDateTime);
 */
public class SqlTracker implements Store, AutoCloseable {

    private Connection conn;

    public void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            conn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement = conn.prepareStatement(
                "insert into items(name, created) values(?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement statement = conn.prepareStatement(
                "update items set name = ?, created = ? where id = ?;")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement statement = conn.prepareStatement(
                "delete from items where id = ?;")) {
            statement.setInt(1, id);
            rsl = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(
                "select * from items;")) {
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    list.add(findBy(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(
                "select * from items where name like ?;")) {
            statement.setString(1, key);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    list.add(findBy(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement statement = conn.prepareStatement(
                "select * from items where id = ?;")) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    item = findBy(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    private Item findBy(ResultSet rs) throws SQLException {
        return new Item(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getTimestamp("created").toLocalDateTime());
    }
}