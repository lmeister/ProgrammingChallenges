package advprog.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static int counter;
    static Map<Integer, String> resultExpressionMap = new HashMap<>();

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Value?");
        int value = scn.nextInt();

        counter = 0;

        System.out.println("Divide And Conquer: " + divideAndConquer(value, 9, 9));
        System.out.println("Counter: " + counter);
        counter = 0;
        System.out.println("Branch and Bound: " + branchAndBound(value, 9, 9));
        System.out.println("Counter: " + counter);
        counter = 0;
        System.out.println("Dynamic Programming: " + dynamicProgramming(value, 9, 9));
        System.out.println("Counter: " + counter);
    }

    private static String divideAndConquer(int target, int number, Integer tailValue) {
        String expression = "";
        counter++;

        // Abbruchbedingung
        if (number == tailValue.toString().length()) {
            if (target == tailValue) {
                return tailValue.toString();
            }
            return null;
        }

        // + operator
        String temp = divideAndConquer(target - tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            return expression;
        } else {
            // - operator
            temp = divideAndConquer(target + tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                return expression;
            } else {
                // join operator
                temp = divideAndConquer(target, number, Integer.valueOf(Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1).concat(tailValue.toString())));
                if (temp != null) {
                    expression = temp;
                    return expression;
                } else {
                    return null;
                }
            }
        }
    }

    private static String branchAndBound(int target, int number, Integer tailValue) {
        String expression = "";
        counter++;

        // Abbruchbedingung
        if (number == tailValue.toString().length()) {
            if (target == tailValue) {
                return tailValue.toString();
            }
            return null;
        }

        StringBuilder largestJoinNumber = new StringBuilder();
        for (int i = 1; i <= number ; i++) {
            largestJoinNumber.append(i);
        }

        if (Integer.parseInt(largestJoinNumber.toString()) < target) {
            return null;
        }

        // + operator
        String temp = branchAndBound(target - tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            return expression;
        } else {
            // - operator
            temp = branchAndBound(target + tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                return expression;
            } else {
                // join operator
                temp = branchAndBound(target, number, Integer.valueOf(Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1).concat(tailValue.toString())));
                if (temp != null) {
                    expression = temp;
                    return expression;
                } else {
                    return null;
                }
            }
        }
    }

    private static String dynamicProgramming(int target, int number, Integer tailValue) {
        String expression = "";
        counter++;

        // Abbruchbedingung
        if (number == tailValue.toString().length()) {
            if (target == tailValue) {
                return tailValue.toString();
            }
            return null;
        }

        // Abbruchbedingung Map
        if (resultExpressionMap.containsKey(target)) {
            return resultExpressionMap.get(target);
        }

        // + operator
        String temp = dynamicProgramming(target - tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            resultExpressionMap.put(target, expression);
            return expression;
        } else {
            // - operator
            temp = dynamicProgramming(target + tailValue, number - tailValue.toString().length(), number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                resultExpressionMap.put(target, expression);
                return expression;
            } else {
                // join operator
                temp = dynamicProgramming(target, number, Integer.valueOf(Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1).concat(tailValue.toString())));
                if (temp != null) {
                    expression = temp;
                    resultExpressionMap.put(target, expression);
                    return expression;
                } else {
                    return null;
                }
            }
        }
    }
}
