package com.ssafy._2022_1.day_220823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7576_토마토_이원석 {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int N, M, max_val = Integer.MIN_VALUE, result = 0;
    static Queue<int[]> queue;
    static int[][] visited, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M][N];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) { // 익은 토마토 발견
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != -1 && visited[i][j] == 0) {
                    result = -1;
                }
                max_val = Math.max(max_val, visited[i][j] - 1);
            }
        }

        if (result == -1) {
            System.out.println(result);
        } else {
            System.out.println(max_val);
        }
    }

    public static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                    if (visited[nx][ny] >= 1 || arr[nx][ny] == -1) {
                        continue;
                    }
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
