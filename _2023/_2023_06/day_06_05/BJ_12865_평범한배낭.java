package com.ssafy._2023._2023_06.day_06_05;

import java.util.*;
import java.io.*;


public class BJ_12865_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        // 물건의 개수 N, 수용 무게 K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2차원 dp 배열 선언
        int[][] dp = new int[N + 1][K + 1];

        // 물건의 개수가 1 ~ N개 일 때,
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            // 물건의 무게, 물건의 가치
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 수용가능한 가방의 무개 K까지
            for (int j = 0; j <= K; j++) {
                // 수용 가능한 무게일 경우..
                if (j >= W) {
                    // 이전 물건을 담은 경우와, 해당 물건을 수용하기 전 가치와 해당 물건의 가치의 합 중 더 큰 것을 가져간다.
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W] + V);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // K무게를 담을 수 있는 가방에 N개의 물건을 모두 최적으로 담았을 때
        System.out.println(dp[N][K]);
    }
}