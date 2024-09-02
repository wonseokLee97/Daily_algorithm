package com.ssafy._2024_06.BJ_2688_줄어들지않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // i자리수의 j로 시작하는 수
        long[][] dp = new long[65][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k <= 9; k++) {
                    // i가 2, 두 자리수고 j가 0으로 시작한다면
                    // i가 1, 한 자리수고 j는 0으로 시작하는경우
                    // i가 1, 한 자리수고 j는 1으로 시작하는경우
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long ans = 0;

            for (int j = 0; j <= 9; j++) {
                // N의 자리수에서 j로 시작하는 경우
                ans += dp[N][j];
            }

            System.out.println(ans);
        }
    }
}

//