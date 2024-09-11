package com.ssafy._2024._03.day_03_22.BJ_11123_양한마리양두마리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] arr = new char[H][W];
            int[][] visited = new int[H][W];

            for (int i = 0; i < H; i++) {
                char[] c = br.readLine().toCharArray();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = c[j];
                }
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (arr[i][j] == '#' && visited[i][j] == 0) {
                        cnt++;
                        Queue<int[]> q = new LinkedList();
                        q.offer(new int[]{i, j});

                        visited[i][j] = 1;

                        while (!q.isEmpty()) {
                            int[] poll = q.poll();
                            int x = poll[0];
                            int y = poll[1];

                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k];
                                int ny = y + dy[k];

                                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                                    if (arr[nx][ny] == '#' && visited[nx][ny] == 0) {
                                        visited[nx][ny] = 1;
                                        q.offer(new int[]{nx, ny});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }
}
