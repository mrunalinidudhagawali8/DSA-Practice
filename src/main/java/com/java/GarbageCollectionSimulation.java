package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GarbageCollectionSimulation {

    public static void main(String[] args) throws InterruptedException {
        List<Object> container = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            byte[] b = new byte[1024 * 100]; // ~100 KB each
            container.add(b);

            if (i % 100 == 0) {
                Thread.sleep(10); // slow down a bit
            }
        }

        System.out.println("Done allocating");
        Thread.sleep(10000); // give GC time to run before exit
    }
}
