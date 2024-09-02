package com.ssafy._2024_08.BJ_14916_거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i < 100001; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        int N = Integer.parseInt(br.readLine());
        int ans = dp[N];

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}


// 2원과 5원으로만 거스름돈을 주어야 한다.

// 1원: -1
// 2원: 2원 1개
// 3원: -1
// 4원: 2원 2개
// 5원: 5원 1개

// 0 1 2 3 4 5 6 7 8 9 10
// 0 0 1 0 2 1 3 2 4 3
// 0 0 1 0 2 1 3 2 4 3 0 0, 0, 0, 0, 0]

// dp[6] 의 경우 6-2 + 6-5
// dp[7] 의 경우 dp[7 - 2] + dp[7 - 5]
// 9원의 경우.. 5원 2원 2원
// dp[7] + 1, dp[4] + 1
// 10원의 경우.. 5원 5원
// dp[8] + 1, dp[5] + 1