package com.ssafy._2024_04.BJ_4963_섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 1, -1, -1, 1},
                 dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static int arr[][], w, h, visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                return;
            }

            arr = new int[h][w];
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = 1;

        while (!q.isEmpty()) {
            int[] now_pos = q.poll();
            int x = now_pos[0];
            int y = now_pos[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if ((nx >= 0 && nx < h && ny >= 0 && ny < w) && arr[nx][ny] == 1) {
                    if (visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

// bfs