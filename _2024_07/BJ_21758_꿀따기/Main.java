package com.ssafy._2024_07.BJ_21758_꿀따기;

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
        int[] arr = new int[N];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }


        // b의 위치
        int max_val = Integer.MIN_VALUE;

        // 벌통이 0이고, 벌1은 오른쪽 끝 고정
        int total;
        // 벌2가 움직인다.
        for (int i = 1; i < N - 1; i++) {
            total = 0;
            // 벌1의 위치: N-1
            // 벌2의 위치: i
            // 벌통의 위치: 0
            total += dp[N] - dp[0] - arr[N - 1] - arr[i]; // 0 ~ N-1 (R)
            total += dp[i + 1] - dp[0] - arr[i]; // i ~ 0 (R)
            max_val = Math.max(max_val, total);
        }

        // 벌통이 N - 1이고, 벌1은 왼쪽 끝 고정
        // 벌2가 움직인다.
        for (int i = 1; i < N - 1; i++) {
            total = 0;
            // 벌1의 위치: 0
            // 벌2의 위치: i
            // 벌통의 위치: N-1
            total += dp[N] - dp[0] - arr[0] - arr[i]; // 0 ~ N-1
            total += dp[N] - dp[i] - arr[i]; // i ~ N-1
            max_val = Math.max(max_val, total);
        }



        // 벌의 위치는 양쪽 끝 - b가 1과 N-1 사이인경우
        for (int i = 1; i < N - 1; i++) {
            total = 0;
            // 0~b
            total += dp[i + 1] - dp[0] - arr[0];
            // b~n-1 R
            total += dp[N] - dp[i] - arr[N - 1];
            max_val = Math.max(max_val, total);
        }


        // a = 0이면 b1는 N, b2는 N-1
        // b  a  a
        // 9  9  4  1  4  9  9
        // 9 18 22 23 27 36 45

        // a / a+b / a+b+c / a+b+c+d
        // 3~4 구간의 누적합을 구하려면 dp[4] - dp[2]
        // 1~3 = dp[3] - dp[0] - arr[1];
        // 3~7-R = dp[7] - dp[2] - arr[7];
        // 45 - 18 = 27 - 9 = 18

        // 1~7 = dp[7] - dp[0] - arr[1];
        // 3~7 = dp[7] - dp[2] - arr[3 - 1];
        // 45 - 18 - 4 = 23


//        for (int i = 0; i < N; i++) {
//            int total = 0;
//
//            System.out.println(i);
//
//            if (i == 0) { // 오른쪽에 몰려있거나! - b가 0인 경우,
//                // b~N-1 R
//                total += dp[N] - dp[0] - arr[N - 1] - arr[N - 2];
//                System.out.println(total);
//                // b~N-2 R
//                total += dp[N - 1] - dp[0] - arr[N - 2];
//                System.out.println(total);
//            } else if (i == N - 1) { // 왼쪽에 몰려있거나, - b가 N - 1인 경우,
//                // 0 ~ b
//                total += dp[N] - dp[0] - arr[0] - arr[1];
//                System.out.println(total);
//                // 1 ~ b
//                total += dp[N] - dp[1] - arr[1];
//                System.out.println(total);
//            } else { // 벌의 위치는 양쪽 끝 - b가 1과 N-1 사이인경우
//                // 0~b
//                total += dp[i + 1] - dp[0] - arr[0];
//                System.out.println(dp[i + 1] + ", " + dp[0] + ", " + arr[0]);
//                System.out.println(total);
//                // b~n-1 R
//                total += dp[N] - dp[i - 1] - arr[N - 1];
//                System.out.println(total);
//            }
//
//            System.out.println(total);
//            System.out.println("+============+");
//
//            max_val = Math.max(max_val, total);
//        }

        System.out.println(max_val);
    }
}

