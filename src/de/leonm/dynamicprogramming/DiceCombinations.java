// Has to be removed when submitting to CSES
package de.leonm.dynamicprogramming;

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

    final static long MODULO = (long) (1E9 + 7);

    /**
     * This saves the previously calculated results
     **/
    static long[] memoized;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        //System.out.println("Enter an integer between 1 and 10^6");
        int input = scn.nextInt();

        // Memoization helps decrease the complexity
        // Without dynamic programming (memoization) we have exponential time
        // Memoization allows us "free" recursive calls => Linear time, we're still poly
        memoized = new long[ input + 1];
        memoized[1] = 1L;
        long answer = solve(input);
        System.out.println(answer);
    }

    private static long solve(int input) {
        if (input < 0) {
            return 0;
        } else if (input == 0) {
            return 1;
            // Lookup if we have already calculated the value for this input
        } else if (memoized[input] > 0) {
            return memoized[input];
        }

        long solution = 0;
        for (int firstRoll = 1; firstRoll <= 6; firstRoll++) {
            solution = additionModulo(solution, solve((input - firstRoll)));
        }
        memoized[input] = solution;
        return solution;
    }

    private static long additionModulo(long a, long b) {
        return (a + b) % MODULO;
    }

}
