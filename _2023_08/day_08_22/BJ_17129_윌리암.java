package com.ssafy._2023_08.day_08_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17129_윌리암 {
    static int arr[][], visited[][], n, m;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new int[n][m];

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < n; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = c[j] - '0';

                if (arr[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        int[] a = bfs(sx, sy);


        if (a == null) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(visited[a[0]][a[1]] - 1);
        }
    }

    static int[] bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];


            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (isIn(nx, ny) && visited[nx][ny] == 0 && arr[nx][ny] != 1) {
                    if (arr[nx][ny] == 0) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = visited[x][y] + 1;
                    } else {
                        visited[nx][ny] = visited[x][y] + 1;
                        return new int[] {nx, ny};
                    }
                }
            }
        }

        return null;
    }

    static boolean isIn(int x, int y) {
        if (x >= 0 && x < n && y >= 0 & y < m) {
            return true;
        }
        return false;
    }
}
