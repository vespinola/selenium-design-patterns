package com.udemy.seleniumdesign.executearound;

import java.util.function.Consumer;

public class SampleConsumer {
    public static void main(String[] args) {
       test(System.out::println);
    }

    private static void test(Consumer<String> consumer) {
        String s = "udemy";
        consumer.accept(s);
    }
}
