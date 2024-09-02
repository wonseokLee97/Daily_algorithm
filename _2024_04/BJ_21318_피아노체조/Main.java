package com.ssafy._2024_04.BJ_21318_피아노체조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
//            if (i == N - 1) {
//                if (arr[i] < arr[i - 1]) {
//                    dp[i] = dp[i - 1] + 1;
//                } else {
//                    dp[i] = dp[i - 1];
//                }
//
//                break;
//            }

            // i가 i+1 보다 큰 경우..
            if (arr[i] > arr[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = dp[i];
            }
        }

//        System.out.println(Arrays.toString(dp));

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            sb.append(dp[y] - dp[x]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}


// x부터 y 까지의 실수를 누적하는 DP

// i와 i+1을 비교하여 숫자가 더 작은 경우 실수를 누적하자.

// 1 2 3 3 4 1 10 8 1
// 0 0 0 0 0 1  1 2 3