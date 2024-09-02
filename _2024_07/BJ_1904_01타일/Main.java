package com.ssafy._2024_07.BJ_1904_01타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        for (int i = 5; i < 1000001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.println(dp[N] % 15746);
    }
}

// 1, 00

// N=1 -> 1
// N=2 -> 00, 11
// N=3 -> 111, 100, 001


// N=4 -> 1111, 1100, 1001, 0011, 0000
// N-3에서
// 111에 1을 붙이는 경우 - 1111
// 100에 1을 붙이는 경우 - 1001
// 001에 1을 붙이는 경우 - 0011
//
// N-2에서
// 00에 00을 붙이는 경우 - 0000
// 11에 00을 붙이는 경우 - 1100

// N=5 ->
// 1111에서 1을 붙이는 경우 - 11111
// 1100에서 1을 붙이는 경우 - 11001
// 1001에서 1을 붙이는 경우 - 10011
// 0011에서 1을 붙이는 경우 - 00111
// 0000에서 1을 붙이는 경우 - 00001

// 111에서 00을 붙이는 경우 - 11100
// 100에서 00을 붙이는 경우 - 10000
// 001에서 00을 붙이는 경우 - 00100