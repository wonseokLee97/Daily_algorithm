package com.ssafy._2024_06.BJ_10971_외판원순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, MIN_VAL, W[][], visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new int[N];
        MIN_VAL = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = 1;
            dfs(i, i, 1, 0);
        }
        System.out.println(MIN_VAL);

    }
    
    static void dfs(int start, int origin, int cnt, int cost) {
        if (cnt == N) {
            if (W[start][origin] != 0) {
                // 종점에서 시점으로 돌아가는 W + cost
                MIN_VAL = Math.min(MIN_VAL, cost + W[start][origin]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1 || W[start][i] == 0) {
                continue;
            }

            visited[i] = 1;
            dfs(i, origin, cnt + 1, cost + W[start][i]);
            visited[i] = 0;
        }
    }
}
