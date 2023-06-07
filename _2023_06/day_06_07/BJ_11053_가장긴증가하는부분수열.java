package com.ssafy._2023_06.day_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] num = new int[N];
        int max_val = Integer.MIN_VALUE;

        Arrays.fill(dp, 1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // i 번째 숫자를 기준으로 더 작은 숫자들의 경우
                if (num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            max_val = Math.max(max_val, dp[i]);
        }

        System.out.println(max_val);
    }
}
