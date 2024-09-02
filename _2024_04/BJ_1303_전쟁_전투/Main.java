package com.ssafy._2024_04.BJ_1303_전쟁_전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, dx[] = {-1, 1, 0, 0},
            dy[] = {0, 0, -1, 1}, visited[][];
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = c[j];
            }
        }

        int W = 0;
        int B = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    if (arr[i][j] == 'W') {
                        W += Math.pow(bfs(i, j, 'W'), 2);
                    } else {
                        B += Math.pow(bfs(i, j, 'B'), 2);
                    }
                }
            }
        }

        System.out.println(W + " " + B);
    }

    static int bfs(int a, int b, char team) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = 1;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (arr[nx][ny] == team && visited[nx][ny] == 0) {
                        visited[nx][ny] = 1;
                        q.offer(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}


