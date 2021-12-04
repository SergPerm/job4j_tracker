package ru.job4j.tdd.template;

import org.hamcrest.core.Is;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleGeneratorTest {

    @Test
    @Ignore
    public void whenProduce() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String result = "I am a Petr Arsentev, Who are you? ";
        assertThat(gen.produce(template, map),
                Is.is(result));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenMapContainMoreKeyThenException() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}! ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        gen.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenMapContainLessKeyThenException() {
        Generator gen = new SimpleGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        gen.produce(template, map);
    }
}