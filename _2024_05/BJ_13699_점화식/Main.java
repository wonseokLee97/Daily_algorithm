package com.ssafy._2024_05.BJ_13699_점화식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분류: 다이나믹 프로그래밍 (Bottom-To-Top)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[36];
        dp[0] = 1L;
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 5L;

        for (int i = 4; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - (j + 1)];
            }
        }

        System.out.println(dp[N]);
    }
}

// t(1) = t(0) * t(0) = 1
// t(2) = t(0) * t(1) + t(1) * t(0) = 2
// t(3) = t(0) * t(2) + t(1) * t(1) + t(2) * t(0) = 5
// t(4) = t(0) * t(3) + t(1) * t(2) + t(2) * t(1) + t(3) * t(0)
// ...
// t(n) = t(0) * t(n-1) + t(1) * t(n-2) + ... + t(n-1) * t(0)
//          0  /   n-1      1  /   n-2
// 총합이 n-1이 되는
