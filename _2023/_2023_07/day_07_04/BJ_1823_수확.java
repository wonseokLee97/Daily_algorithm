package com.ssafy._2023._2023_07.day_07_04;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BJ_1823_수확 {

    static Deque<Integer> deque;
    static int N, max_val, arr[], dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 벼의 개수
        N = sc.nextInt();
        arr = new int[N + 1];
        max_val = Integer.MIN_VALUE;
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();

            // i 부터 i 까지의 최대 수확량은 마지막에 수확한 경우
            dp[i][i] = arr[i] * N;
        }


    }
}

// 백트래킹 문제같다..
// 5개의 벼를 수확할 때.. (1, 2, 3, 4, 5)
// 1 3 1 5 2
// 3 1 5 2
// 1 5 2
// 5 2
// 2
// []

// 2
// 5 2

//[0, 0, 0, 0, 0, 0]
//[0, 15, 0, 0, 0, 0]
//[0, 0, 5, 0, 0, 0]
//[0, 0, 0, 25, 0, 0]
//[0, 0, 0, 0, 10, 0]
//[0, 0, 0, 0, 0, 0]
