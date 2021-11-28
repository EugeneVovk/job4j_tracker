package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void addAddresses() {
        List<Profile> clients = List.of(
                new Profile(new Address("Big city", "Big street", 10, 723)),
                new Profile(new Address("Medium city", "Medium street", 2, 20)),
                new Profile(new Address("Small city", "Small street", 1, 4))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(clients);
        List<Address> expected = List.of(
                new Address("Big city", "Big street", 10, 723),
                new Address("Medium city", "Medium street", 2, 20),
                new Address("Small city", "Small street", 1, 4)
        );
        assertEquals(expected, rsl);
    }

}