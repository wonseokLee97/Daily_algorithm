package com.ssafy._2024_07.BJ_1890_점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], visited[][], N, dx[] = {1, 0}, dy[] = {0, 1};
    static long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];
        visited = new int[N][N];

        for (long[] longs : dp) {
            Arrays.fill(longs, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));


    }

    static long dfs(int x, int y) {
        if (arr[x][y] == 0) {
            return 1;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i] * arr[x][y];
                int ny = y + dy[i] * arr[x][y];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (visited[nx][ny] == 1) {
                        continue;
                    }

                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}

// 2 3 3 1
// 1 2 1 3
// 1 2 3 1
// 3 1 1 0

// 0 0 1 0
// 0 0 0 0
// 1 1 0 1
// 1 0 1 3