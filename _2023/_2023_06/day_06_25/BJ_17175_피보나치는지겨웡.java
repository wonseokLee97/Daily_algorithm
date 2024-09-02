package com.ssafy._2023._2023_06.day_06_25;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_17175_피보나치는지겨웡 {

    static long cnt, dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new long[51];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;


        for (int i = 4; i <= 50; i++) {
            dp[i] = dp[i - 2] + dp[i - 1] + 1;
        }

        System.out.println(dp[N] % 1000000007);
    }

    public static int fibonacci(int n) {

        cnt++;

        if (n < 2) {
            return n;
        }

        return fibonacci(n - 2) + fibonacci(n - 1);
    }
}


// n이 5라면..
// dp[5] = dp[3] + dp[4];

// dp[3] = dp[1] + dp[2];
// dp[4] = dp[2] + dp[3];