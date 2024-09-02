package com.ssafy._2023._2023_06.day_06_05;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2579_계단오르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }

        if (N == 1) {
            System.out.println(arr[1]);
            return;
        }

        // 첫 번째 계단의 최대값
        dp[1] = arr[1];

        // 두 번째 계단의 최대값
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i < N + 1; i++) {
            // i + 1번 계단에서는
            // 1. (현재 계단 + 이전 계단) + (이이이전 계단까지의 최대거리)
            // 2. 현재 계단 + (이이전 계단까지의 최대거리)
            dp[i] = arr[i] + Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[N]);
    }
}
