package com.ssafy._2023._2023_07.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14716_현수막 {
    static int arr[][], visited[][], N, M;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}, dy = {0, 0, -1, 1, -1, 1, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    visited[i][j] = 1;
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int i, int j) {
        for (int k = 0; k < 8; k++) {
            int nx = dx[k] + i;
            int ny = dy[k] + j;

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    dfs(nx, ny);
                }
            }
        }
    }
}

//6 7
//0 0 0 0 0 0 0
//0 1 0 0 1 0 0
//0 0 1 1 0 0 0
//0 0 1 1 0 0 1
//0 1 0 0 1 0 0
//0 0 0 0 0 0 1