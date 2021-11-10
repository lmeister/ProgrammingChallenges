package de.leonm;

import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1633 Your task is to count the number of ways to construct sum n
 * by throwing a dice one or more times. Each throw produces an outcome between 1 and 6.
 * <p>
 * For example, if n=3, there are 4 ways: 1 + 1 + 1 1 + 2 2 + 1 3
 * <p>
 * INPUT: The only input line has an integer n. OUTPUT: Print the number of ways modulo 10^9 + 7.
 * CONSTRAINTS: 1 ≤ n ≤ 10^6
 * <p>
 * Example: Input 3 -> Output 4
 * <p>
 * Time limit 1.00s, Memory limit 512mb
 */
public class DiceCombinations {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter an integer between 1 and 10^6");
        long input = scn.nextLong();

        long answer = bruteForceRecursive(input);
        System.out.println(answer);
    }

    private static long dynamicProgrammingSolution(long input) {
        long solution = 0;

        return solution;
    }

    private static long bruteForceRecursive(long input) {
      long solution = 0;

      if (input < 0) {
        return 0;
      }
      if (input == 0) {
        return 1;
      }

      for (long firstRoll = 0; firstRoll <= 6; firstRoll++) {
        solution += bruteForceRecursive(input - firstRoll);
      }
      return solution;
    }
}
