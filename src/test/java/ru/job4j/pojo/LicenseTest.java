package ru.job4j.pojo;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.Date;

public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        first.setOwner("Petr");
        first.setModel("a8");
        first.setCreated(new Date());
        License second = new License();
        second.setCode("audio");
        second.setOwner("Petr");
        second.setModel("a8");
        second.setCreated(new Date());
        assertThat(first, is(second));
    }
}