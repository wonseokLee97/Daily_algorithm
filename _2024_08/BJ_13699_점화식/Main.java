package com.ssafy._2024_08.BJ_13699_점화식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i < 36; i++) {
            dp[i] = dp[0] * dp[i - 1];

            for (int j = 1; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        System.out.println(dp[N]);
    }
}


// t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)

// t(2)=t(0)*t(1) + t(1)*t(0)=2
// t(3)=t(0)*t(2) + t(1)*t(1) + t(2)*t(0)=5
// t(4)=t(0)*t(3) + t(1)*t(2) + t(2)*t(1) + t(3)*t(0)