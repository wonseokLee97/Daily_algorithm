package com.ssafy._2024_07.BJ_1003_피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            dp[i][0] += dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] += dp[i - 1][1] + dp[i - 2][1];
        }


        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }
}

// fibo(0) = 1:0, 0:1
// fibo(1) = 1:1, 0:0
// fibo(2) = fibo(1) + fibo(0) -> 1과 0을 호출
//         = 1:1, 0:1

// fibo(3) = fibo(2) + fibo(1) -> (1과 0을 호출) + 1을 호출
//         = 1:2, 0:1

// fibo(4) = fibo(3) + fibo(2) -> (1과 0을 호출 + 1을 호출) + (1과 0을 호출)
//         = 1:3, 0:2