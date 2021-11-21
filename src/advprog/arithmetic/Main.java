package advprog.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {

    static int counter;
    static Map<Integer, String> resultExpressionMap = new HashMap<>();

    public static void main(String[] args) throws ScriptException {
        Scanner scn = new Scanner(System.in);
        char[] operators = {'+', '-', ' '};
        System.out.println("Target value?");
        int value = scn.nextInt();

        System.out.println("Bruteforce: " + bruteforce(operators, value));
        System.out.println("Counter: " + counter);
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

    /**
     * Bruteforces a math expression that evaluates to the result. Works with any amount of
     * operators, needs to be adjusted for more digits, though.
     *
     * @param operators The possible operations as char array
     * @param target
     * @return math expression that evaluates to result
     * @throws ScriptException
     */
    private static String bruteforce(char[] operators, int target) throws ScriptException {
        String expression = "";
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                    for (int l = 0; l < operators.length; l++) {
                        for (int r = 0; r < operators.length; r++) {
                            for (int t = 0; t < operators.length; t++) {
                                for (int z = 0; z < operators.length; z++) {
                                    for (int u = 0; u < operators.length; u++) {
                                        expression = "1" + operators[i]
                                            + "2" + operators[j]
                                            + "3" + operators[k]
                                            + "4" + operators[l]
                                            + "5" + operators[r]
                                            + "6" + operators[t]
                                            + "7" + operators[z]
                                            + "8" + operators[u]
                                            + "9";
                                        counter++;
                                        expression = expression
                                            .replaceAll("\\s+", ""); // remove whitespaces
                                        // Definitely not a good idea to evaluate a string like this
                                        // Joys of javascript though
                                        if ((int) engine.eval(expression) == target) {
                                            return expression;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return "No solution found.";
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
        String temp = divideAndConquer(target - tailValue, number - tailValue.toString().length(),
            number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            return expression;
        } else {
            // - operator
            temp = divideAndConquer(target + tailValue, number - tailValue.toString().length(),
                number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                return expression;
            } else {
                // join operator
                temp = divideAndConquer(target, number, Integer.valueOf(
                    Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1)
                        .concat(tailValue.toString())));
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
        for (int i = 1; i <= number; i++) {
            largestJoinNumber.append(i);
        }
        // Check if our targest is larger than the largest number we can generate
        if (Integer.parseInt(largestJoinNumber.toString()) < target) {
            return null;
        }

        // + operator
        String temp = branchAndBound(target - tailValue, number - tailValue.toString().length(),
            number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            return expression;
        } else {
            // - operator
            temp = branchAndBound(target + tailValue, number - tailValue.toString().length(),
                number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                return expression;
            } else {
                // join operator
                temp = branchAndBound(target, number, Integer.valueOf(
                    Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1)
                        .concat(tailValue.toString())));
                if (temp != null) {
                    expression = temp;
                    return expression;
                } else {
                    return null;
                }
            }
        }
    }

    // Doesn't work properly yet
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
        String temp = dynamicProgramming(target - tailValue, number - tailValue.toString().length(),
            number - tailValue.toString().length());
        if (temp != null) {
            expression = temp + "+" + tailValue;
            resultExpressionMap.put(target, expression);
            return expression;
        } else {
            // - operator
            temp = dynamicProgramming(target + tailValue, number - tailValue.toString().length(),
                number - tailValue.toString().length());
            if (temp != null) {
                expression = temp + "-" + tailValue;
                resultExpressionMap.put(target, expression);
                return expression;
            } else {
                // join operator
                temp = dynamicProgramming(target, number, Integer.valueOf(
                    Integer.toString(Character.getNumericValue(tailValue.toString().charAt(0)) - 1)
                        .concat(tailValue.toString())));
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
