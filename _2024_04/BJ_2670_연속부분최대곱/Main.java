package com.ssafy._2024_04.BJ_2670_연속부분최대곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        float[] arr = new float[N];
        float[] dp = new float[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Float.parseFloat(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(arr[i - 1], dp[i - 1] * arr[i - 1]);
        }

        float max_val = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            max_val = Math.max(dp[i], max_val);
        }

        System.out.println(Arrays.toString(dp));
        System.out.printf("%.3f", max_val);
        System.out.print(String.format("%.3f",max_val));
    }
}

// 100,000,000

// Math.max(이전 곱연산과 현재 값의 곱, 이전 값과 현재 값의 곱)
//      1.1 | 0.7 | 1.3 | 0.9 | 1.4 | 0.8 | 0.7 | 1.4
//        0   0.77  1.43 1.287 1.8018
//4
//6.1
//4.3
//0.5
//6.1

//3
//1
//1.1
//1.2