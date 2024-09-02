package com.ssafy._2024_08.BJ_11170_0의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] dp = new int[1000001];
        dp[0] = 1;
        dp[10] = 1;
        dp[100] = 2;
        dp[1000] = 3;
        dp[10000] = 4;

        for (int i = 11; i <= 1000000; i++) {
            dp[i] = dp[i / 10];

            if (i % 10 == 0) {
                dp[i]++;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int total = 0;
            for (int j = N; j <= M; j++) {
                total += dp[j];
            }

            System.out.println(total);
        }
    }
}

// 0이 있는 숫자.
// origin: 0 1 2 3 4 5 6 7 8 9 10 11 12 .. 20 .. 100
// divide: 0 1 2 3 4 5 6 7 8 9  0  1  2 ..  0 ..   0

// origin: 101 .. 1001
// divide:   1 ..    1
//     몫:  10*10+1 ...  10*100+1