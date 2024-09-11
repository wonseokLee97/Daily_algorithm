package com.ssafy._2022_1.day_220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D4_1861_정사각형방_이원석 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] visited;
    static int[][] arr;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            int max_val = Integer.MIN_VALUE;
            int start_room = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());

            StringTokenizer st;

            arr = new int[N][N];


            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new int[N][N];
                    bfs(i, j);

                    if (max_val < cnt) {
                        max_val = cnt;
                        start_room = arr[i][j];
                    } else if (max_val == cnt) {
                        start_room = Math.min(start_room, arr[i][j]);
                    }
                }
            }
            System.out.printf("#%d %d %d\n", t, start_room, max_val);
        }
    }

    public static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        cnt = 1;

        q.add(new int[]{i, j});
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (((nx >= 0) && (nx < N)) && ((ny >= 0) && (ny < N))) {
                    if ((visited[nx][ny] == 0) && (arr[x][y] + 1 == arr[nx][ny])) {
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }
    }

}
