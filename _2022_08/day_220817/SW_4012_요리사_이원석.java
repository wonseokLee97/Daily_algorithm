package com.ssafy.day_220817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_4012_요리사_이원석 {
    static int N;
    static int[] visited;
    static int[][] arr;
    static int min_gap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t < TC + 1; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new int[N];
            min_gap = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);
            System.out.printf("#%d %d\n", t, min_gap);
        }
    }

    // 조합을 사용하여 A, B 음식에 사용할 식재료를 나눈다.
    public static void dfs(int cnt, int start) {
        if (cnt == N / 2) {
            cook(visited);
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            dfs(cnt + 1, i + 1);
            visited[i] = 0;
        }
    }

    public static void cook(int[] visited) {
        int[] food_A = new int[N / 2];
        int[] food_B = new int[N / 2];
        int cnt_a = 0, cnt_b = 0, taste_A = 0, taste_B = 0;

        // 어떤 식재료를 사용할지 분류
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) { // foodA
                food_A[cnt_a++] = i;
            } else { // foodB
                food_B[cnt_b++] = i;
            }
        }
        // 1,2 / 3,4
        // 해당 식재료를 통해 맛을 구한다.
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (i == j) {
                    continue;
                }
                taste_A += arr[food_A[i]][food_A[j]];
                taste_B += arr[food_B[i]][food_B[j]];
            }
        }
        min_gap = Math.min(Math.abs(taste_A - taste_B), min_gap);
    }
}

// 111000
// 110100


//10
//6
//0 5 3 8 1 1
//4 0 4 1 2 2
//2 5 0 3 3 3
//7 2 3 0 4 4
//1 2 3 4 0 5
//1 2 3 4 5 0


//10
//4
//0 5 3 8
//4 0 4 1
//2 5 0 3
//7 2 3 0