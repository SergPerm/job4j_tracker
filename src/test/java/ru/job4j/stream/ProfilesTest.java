package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectProfileToAddress() {
        List<Profile> recourse = List.of(
                new Profile(new Address("Perm")),
                new Profile(new Address("Bryansk"))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(recourse);
        assertEquals(Address.class, rsl.get(0).getClass());
    }

}