package com.ssafy.day_220824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_10026_적록색약_이원석 {
    static int N;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        int no = 0, yes = 0;

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = c[j];
            }
        }

        visited = new int[N][N]; // 적록색약 X
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                    no++;
                }
            }
        }

        visited = new int[N][N]; // 적록색약 O
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    bfs(i, j);
                    yes++;
                }
            }
        }

        System.out.println(no + " " + yes);
    }

    public static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        visited[a][b] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내부일 때,
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[nx][ny] == 0) {
                        if (arr[nx][ny] == arr[x][y]) { // 이전과 다음의 색갈이 같을 때,
                            visited[nx][ny] = 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}
