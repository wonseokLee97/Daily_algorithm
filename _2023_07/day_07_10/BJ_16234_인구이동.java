package com.ssafy._2023_07.day_07_10;

import java.util.*;
import java.io.*;


public class BJ_16234_인구이동 {

    static int N, L, R, arr[][], can[][], visited[][], cnt, flag;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            flag = 0;

            visited = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] != 1) {
                        bfs(i, j);
                    }
                }
            }


            if (flag == 0) {
                break;
            }
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        list = new ArrayList<>();
        list.add(new int[] {x, y});
        int sum = arr[x][y];


        while (!q.isEmpty()) {
            int[] poll = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && visited[nx][ny] == 0) {
                    int gap = Math.abs(arr[nx][ny] - arr[poll[0]][poll[1]]);

                    if (L <= gap && gap <= R) {
                        list.add(new int[] {nx, ny});
                        sum += arr[nx][ny];
                        visited[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }


        if (list.size() > 1) {
            flag = 1;

            for (int[] target : list) {
                arr[target[0]][target[1]] = sum / list.size();
            }
        }

    }
}