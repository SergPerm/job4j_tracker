package ru.job4j.gc.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WeakDemo {

    public static void main(String[] args) throws InterruptedException {
//        example1();
//        example2();
        example3();
    }

    private static void example1() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed1");
            }
        };
        WeakReference<Object> weak = new WeakReference<>(object);
        object = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(weak.get());
    }

    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new WeakReference<Object>(new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Removed2!");
                }
            }));
        }
        System.gc();
        TimeUnit.SECONDS.sleep(3);
    }
    private static void example3() throws InterruptedException {
        Object object = new Object() {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("Removed3");
            }
        };
        System.out.println("object after create " + object);
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        WeakReference<Object> weak = new WeakReference<>(object, queue);
        System.out.println("weak from object " + weak);
        object = null;

        System.gc();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("from link " + weak.get());
        WeakReference weakFromPoll = (WeakReference)queue.poll();
        System.out.println("weak from queue " + weakFromPoll);
    }
}