package advprog.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        test_summeAllerUngeraden_1();
        test_summeAllerUngeraden_2();
    }

    public static void incrementCounter() {
        long i = 0;
        long stopTime = System.currentTimeMillis() + 1000;
        while (System.currentTimeMillis() <= stopTime) {
            i++;
        }
        System.out.println(i);
    }

    public static int summeAllerUngeraden(List<Integer> zahlen) {
        int summe = 0;
        for (int zahl : zahlen) {
            if (zahl % 2 != 0) {
                summe += zahl;
            }
        }

        return summe;
    }

    public static void test_summeAllerUngeraden_1() {
        List<Integer> zahlen = Arrays.asList(1, 2, 3, 4, 5);
        equalityCheck((1 + 3 + 5), summeAllerUngeraden(zahlen), "test_summeAllerUngeraden_1");
    }

    public static void test_summeAllerUngeraden_2() {
        List<Integer> zahlen = Arrays.asList(9, 11, 3, -1);
        equalityCheck((9 + 11 + 3 + (-1)), summeAllerUngeraden(zahlen), "test_summeAllerUngeraden_2");
    }

    public static void equalityCheck(int expected, int actual, String name) {
        System.out.print("Test " + name + " has " );
        if (expected == actual) {
            System.out.println("PASSED.");
        } else {
            System.out.println("FAILED. \n\tExpected: " + expected + ", Actual: " + actual);
        }
    }

}
