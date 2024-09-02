package com.ssafy._2024_07.BJ_2294_동전2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 종류
        int k = Integer.parseInt(st.nextToken()); // 총합
        int[] dp = new int[10001];
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i <= n; i++) {
            // 동전의 값 부터 시작
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }

        if (dp[k] == Integer.MAX_VALUE - 1) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
//        j % coin, j / coin
// 6일때..    1         1
// 7일때..    2         1
// 8일때..    3         1

// 100,000,000

// 1, 5, 12

// 1*15, (5,5,5), (12,1,1,1)...

//     0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
//  0  0  0  0  0  0  0  0  0  0  0   0   0   0   0   0   0
//  1  0  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
//  5  0  0  0  0  0  1  2  3  4  5   2   0   0   0   0   1
// 12  0  0  0  0  0  0  0  0  0  0   0   0   1   2   3

//4 15
//1
//3
//5
//12