package com.ssafy._2023._2023_06.day_06_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_17212_달나라토끼를위한구매대금지불도우미 {
    
    static int dp[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[100001];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= 100000; i++) {
            int min_a = Math.min(dp[i - 1] + 1, dp[i - 2] + 1);
            int min_b = Math.min(dp[i - 5] + 1, dp[i - 7] + 1);
//            dp[i - 1], dp[i - 2], dp[i - 5], dp[i - 7]
            dp[i] = Math.min(min_a, min_b);
        }

        System.out.println(dp[N]);
    }
}

// 1원, 2원, 5원, 7원
