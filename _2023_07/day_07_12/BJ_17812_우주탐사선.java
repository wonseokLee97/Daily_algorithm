package com.ssafy._2023_07.day_07_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17812_우주탐사선 {

    static int N, K, arr[][], visited[], nums[], min_val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new int[N];
        nums = new int[N];
        min_val = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0, 1 -> 0, 1 / 0 0 + 0 1, 0 1 + 1 1, 0 2 + 2 1
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }

        dfs(0);

        System.out.println(min_val);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            if (nums[0] == K) {
                validate();
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            nums[cnt] = i;
            visited[i] = 1;
            dfs(cnt + 1);
            visited[i] = 0;
        }
    }

    public static void validate() {
        int total = 0;

        for (int i = 0; i < N - 1; i++) {
            total += arr[nums[i]][nums[i + 1]];
        }

        min_val = Math.min(min_val, total);
    }
}
