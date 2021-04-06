package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameUpAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp().
                thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDownAndPriorityDown() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown().
                thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameEqualsAndPriorityUp() {
        Comparator<Job> cmpNamePriority = new JobDescByNameUp().
                thenComparing(new JobDescByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameEqualsAndPriorityDown() {
        Comparator<Job> cmpNamePriority = new JobDescByNameDown().
                thenComparing(new JobDescByPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}