package com.goIt.Core5.examples;

import lombok.Data;

import java.lang.reflect.Field;

@Data
public class TestApp {


    @Calculated(value = "2+9") // влвсна анотація
    private int test;

    public String getGreeting() {
        return "Hello world";
    }

    public static void main(String[] args) throws IllegalAccessException {

        TestApp testApp = new TestApp();
        System.out.println("app = " + testApp.getTest());
        process(testApp); // оброби обьект чи анотацію
        System.out.println("app = " + testApp.getTest());

    }

    // метод для обробки анотації пробіжиться по сутності знайде всі поля
    private static void process(Object obj) throws IllegalAccessException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Calculated calculated = field.getAnnotation(Calculated.class);

            if (calculated != null) {
                String value = calculated.value();
                String[] valuePatts = value.split("");
                int number1 = Integer.parseInt(valuePatts[0]);
                int number2 = Integer.parseInt(valuePatts[2]);
                int res = number1 + number2;

                field.setInt(obj, res);

            }
        }
    }
}
