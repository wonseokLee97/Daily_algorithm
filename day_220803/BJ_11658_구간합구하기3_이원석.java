package com.ssafy.day_220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_11658_구간합구하기3_이원석 {

    static int x1;
    static int x2;
    static int y1;
    static int y2;
    static int N;
    static int[][] arr;
    static int sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        dp = new int[N][N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 100만

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i - 1][j] = dp[i - 1][j - 1] + arr[i - 1][j - 1];
            }
        } // 100만


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 5) {
                int w = Integer.parseInt(st.nextToken());
                x1 = Integer.parseInt(st.nextToken());
                y1 = Integer.parseInt(st.nextToken());
                x2 = Integer.parseInt(st.nextToken());
                y2 = Integer.parseInt(st.nextToken());
                get_sum();

            } else {
                int w = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                for (int j = y; j < N + 1; j++) {
                    dp[x - 1][j] += c - arr[x - 1][y - 1];
                }

                arr[x - 1][y - 1] = c;
            }
        }
    }

    public static void get_sum() {
        StringBuilder sb = new StringBuilder("");
        sum = 0;

        if (x1 == x2 && y1 == y2) {
            sb.append(arr[x1 - 1][y1 - 1]);
        } else {
            for (int i = x1; i < x2 + 1; i++) {
                sum += dp[i - 1][y2] - dp[i - 1][y1 - 1];
            }
            sb.append(sum);
        }
        System.out.println(sb);
    }
}
