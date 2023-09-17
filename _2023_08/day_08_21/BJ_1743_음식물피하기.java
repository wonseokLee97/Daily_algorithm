package com.ssafy._2023_08.day_08_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1743_음식물피하기 {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int arr[][], visited[][], N, M, max_val, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        max_val = Integer.MIN_VALUE;

        arr = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            arr[x][y] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    cnt = 0;
                    bfs(i, j);
                    max_val = Math.max(max_val, cnt);
                }
            }
        }

        System.out.println(max_val);
    }


    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            cnt++;
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];


            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (isIn(nx, ny) && visited[nx][ny] == 0) {
                    if (arr[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M) {
            return true;
        }
        return false;
    }
}
