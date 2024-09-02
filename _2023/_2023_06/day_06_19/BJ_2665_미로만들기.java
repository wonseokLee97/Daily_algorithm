package com.ssafy._2023._2023_06.day_06_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2665_미로만들기 {
    static int[] dx = {0, 1, -1, 0},
                 dy = {1, 0, 0, -1};
    static int N, arr[][], visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] s = br.readLine().toCharArray();

            for (int j = 0; j < s.length; j++) {
                arr[i][j] = s[j] - '0';
            }
        }

        for (int[] visit : visited) {
            Arrays.fill(visit, -1);
        }

        bfs(0, 0);

        System.out.println(visited[N - 1][N - 1]);
    }

    public static void bfs(int a, int b) {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[] {a, b});
        visited[a][b] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 범위안일경우
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < N)) {
                    // 벽에 막히는 경우 해당 이동을 후순위로 두고,
                    // 벽에 막히지 않는 경우 해당 이동을 우선으로 둔다.

                    // 이동
                    if (visited[nx][ny] == -1) {
                        // 벽을 만나는 경우 (0일 때)
                        // 벽을 뿌수고 cnt 를 증가시킨다.
                        if (arr[nx][ny] == 0) {
                            visited[nx][ny] = visited[x][y] + 1;
                            q.add(new int[]{nx, ny});
                        }
                        // 벽을 만나지 않는 경우 (1일 때)
                        // 이전 벽까지의 cnt 를 가져온다.
                        else {
                            visited[nx][ny] = visited[x][y];
                            q.addFirst(new int[]{nx, ny});
                        }
                    }
                }
            }
            for (int[] ints : visited) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println();
        }
    }
}