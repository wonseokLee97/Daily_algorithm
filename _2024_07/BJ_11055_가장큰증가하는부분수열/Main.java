package com.ssafy._2024_07.BJ_11055_가장큰증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                } else if (arr[i] == arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                } else {
                    dp[i] = Math.max(dp[i], arr[i]);
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(maxVal, dp[i]);
        }

        System.out.println(maxVal);
    }
}

// 1 100 2 50  60 3  5  6  7  8
// 1 101 3 53 113 6 11 17 24 32