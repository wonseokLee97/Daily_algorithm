package com.ssafy._2024_08.BJ_14940_쉬운최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int visited[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, arr[][], n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        int sx = 0;
        int sy = 0;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 도달하지 못한곳중
                if (sx == i && sy == j) {
                    sb.append(0 + " ");
                    continue;
                }

                if (visited[i][j] == 0) {
                    // 원래 벽이라서 못갔다면
                    if (arr[i][j] == 0) {
                        sb.append(0 + " ");
                    } else { // 벽이 아닌데 못갔다면
                        sb.append(-1 + " ");
                    }
                } else {
                    sb.append(visited[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = 0;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (arr[nx][ny] == 1) {
                        if (visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
