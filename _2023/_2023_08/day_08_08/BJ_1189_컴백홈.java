package com.ssafy._2023._2023_08.day_08_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1189_컴백홈 {
    static int R, C, K, visited[][], cnt;
    static char arr[][];
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] get = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = get[j];
            }
        }
        visited[R - 1][0] = 1;
        dfs(R - 1, 0);

        System.out.println(cnt);
    }

    static void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (isIn(nx, ny)) {
                if (visited[nx][ny] == 0 && arr[nx][ny] != 'T') {
                    // 우상단에 도달했을 경우
                    if (nx == 0 && ny == C - 1) {
                        if (visited[x][y] + 1 == K) {
                            cnt++;
                            return;
                        }
                    }

                    visited[nx][ny] = visited[x][y] + 1;
                    dfs(nx, ny);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        if (0 <= x && x < R && 0 <= y && y < C) {
            return true;
        }
        return false;
    }
}

// 끝에 닿으면 다시 return
