package com.ssafy.toss;

import java.util.*;

public class po5 {

    // 런타임 에러 빼고는 효율성 테스트 다 통과
    static int[][] dp;
    static int[][] origin;


    public static void main(String[] args) {
        System.out.println(solution(10,10,3,2,7,new int[][] {{2,2},{2,3},{2,4},{6,2},{6,4},{6,3},{3,5}}));

    }
    static public int solution(int A, int B, int C, int D, int N, int[][] Chips) {
        // 케이크: A cm x B cm
        // 직사각형 틀: C cm x D cm
        // 초콜릿 칩: N개
        // 초콜릿 칩의 좌표 xn, yn: (Chips[n-1][0], Chips[n-1][1])
        origin = new int[A][B];
        dp = new int[A+1][B+1];

        for (int i = 0; i < N; i++) {
            origin[Chips[i][0]][Chips[i][1]]++;
        }

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                // 누적합 배열 만들기
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + origin[i][j];
            }
            System.out.println(Arrays.toString(dp[i]));
        }



        int max = 0;

        for (int x = 0 ; x < A-C; x++) {
            for (int y = 0; y < B-D; y++) {
                max = Math.max(range_sum(x, y, x+C, y+D), max);
            }
        }
        for (int x = 0 ; x < A-D; x++) {
            for (int y = 0; y < B-C; y++) {
                max = Math.max(range_sum(x, y, x+D, y+C), max);
            }
        }
        return max;
    }
    private static int range_sum(int x1, int y1, int x2, int y2) {
        x1++;
        x2++;
        y1++;
        y2++;
        return dp[x2][y2] - (dp[x1-1][y2] +dp[x2][y1-1]) + dp[x1-1][y1-1];
    }
}