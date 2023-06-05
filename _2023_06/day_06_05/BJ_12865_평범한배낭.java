package com.ssafy._2023_06.day_06_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2차원 dp 배열 선언
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            // 무게가 W인 물건의 가치 V
            for (int j = 0; j < K + 1; j++) {
                // 만약 현재 물건의 무게를 담을 수 있는 상황이라면?
                if (j >= W) {
                    // 현재 물건을 담기 이전 까지의 무게(최적의 값)과
                    // 현재 물건을 담은 후의 최적의 값 중에서 최대 값을 저장한다.
                    // ex) i = 2, W = 5, V = 10 인 경우..
                    // 2번째 물건의 무게는 5이다. 5의 무게를 담을 수 있는 상황 전 까지는
                    // 이전 최적의 값들을 저장한다.
                    // 그러나, 5의 무게를 담을 수 있는 상황부터는 j-5 의 최적의 상황에
                    // 5의 무게를 담은 가치와 이전 최적의 값들 중 최대값을 저장한다.
                    dp[i][j] = Math.max(dp[i - 1][j - W] + V, dp[i - 1][j]);
                } else {
                    // 물건을 담기 전 까지는 이전(의 물건을 담은 무게에서의 최적의 값)
                    // 을 최적의 값으로 저장한다.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

//        for (int i = 0; i < N + 1; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(dp[N][K]);
    }
}

//4 7
//3 6
//4 8
//5 12
//6 13

//4 10
//5 10
//4 40
//6 30
//3 50