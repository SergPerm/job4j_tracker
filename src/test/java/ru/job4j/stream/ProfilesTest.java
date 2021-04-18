package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenCollectProfileToAddress() {
        List<Profile> recourse = List.of(
                new Profile(new Address("Perm", "motor", 7, 2)),
                new Profile(new Address("Bryansk", "requi", 4, 1))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.collect(recourse);
        assertEquals(Address.class, rsl.get(0).getClass());
    }

    @Test
    public void whenSortCollectProfileToAddress() {
        List<Profile> recourse = List.of(
                new Profile(new Address("Perm", "motor", 7, 2)),
                new Profile(new Address("Bryansk", "requi", 4, 1)),
                new Profile(new Address("Perm", "motor", 7, 2)),
                new Profile(new Address("Bryansk", "requi", 4, 1))
        );
        Profiles profiles = new Profiles();
        List<Address> rsl = profiles.sortCollect(recourse);
        assertThat(rsl.size(), is(2));
    }

}