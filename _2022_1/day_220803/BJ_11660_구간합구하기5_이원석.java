package com.ssafy._2022_1.day_220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[0][0];

        // 구해야하는 구간까지 - 이전 구간
        for (int i = 1; i < N + 1; i++) {
            if (i != 1) {
                dp[i][1] = dp[i - 1][N] + arr[i - 1][0];
                dp[i][0] = dp[i - 1][N];
            }
            for (int j = 2; j < N + 1; j++) {
                dp[i][j] = dp[i][j - 1] + arr[i - 1][j - 1];
            }
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                System.out.printf("%d ", dp[i][j]);
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder("");
        for (int m = 0; m < M; m++) {
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2 ; i++) {
                sum += dp[i][y2] - dp[i][y1 - 1];
            }

            sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}

//0 0 0 0 0
//0 1 3 6 10
//10 12 15 19 24
//24 27 31 36 42
//42 46 51 57 64