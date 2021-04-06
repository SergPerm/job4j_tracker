package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("AImpl task", 2),
                new Job("Reboot server", 1),
                new Job("Reboot server", 3)
        );
        System.out.println(jobs);
        Collections.sort(jobs);
        System.out.println(jobs);
        Collections.sort(jobs, new SortByNameJob());
        System.out.println(jobs);
        Comparator<Job> cmpNamePriority = new JobDescByNameDown().
                thenComparing(new JobDescByPriorityUp());
        Collections.sort(jobs, cmpNamePriority);
        System.out.println(jobs);
    }
}

