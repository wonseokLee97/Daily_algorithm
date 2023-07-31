package com.ssafy._2023_07.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1520_내리막길 {
    static int M, N, arr[][], visited[][];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new int[M][N];

        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int i, int j) {
        // 목적지 도달
        if (i == M - 1 && j == N - 1) {
            return 1;
        }

        // 최단 경로가 이미 갱신된 경우
        if (visited[i][j] != -1) {
            return visited[i][j];
        }

        // 지나가면 0으로 초기화
        visited[i][j] = 0;

        for (int k = 0; k < 4; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;

            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                // 이전 경로보다 높이가 낮은 경우
                if (arr[i][j] > arr[nx][ny]) {
                    visited[i][j] += dfs(nx, ny);
                }
            }
        }

        return visited[i][j];
    }
}
