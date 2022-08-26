package com.ssafy.day_220826;


// 1. 미세먼지 확산
// 2. 공기청정기 작동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dust {
    int x, y, w;

    public Dust(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

public class BJ_17144_미세먼지안녕_이원석 {
    static int R, C, T, div, flag, sum = 0;
    static int[][] arr, visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int get = Integer.parseInt(st.nextToken());
                arr[i][j] = get;
            }
        }


        for (int t = 0; t < T; t++) {
            flag = 0;
            List<Dust> list = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] != 0 && arr[i][j] != -1) {
                        list.add(new Dust(i, j, arr[i][j]));
                    }
                }
            }

            for (Dust dust : list) {
                bfs(dust.x, dust.y, dust.w);
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (arr[i][j] == -1) {
                        if (flag == 0) { // 상 - 반시계
                            rotate_r(i);
                            flag = 1;

                        } else { // 하 - 시계
                            rotate(i);
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }
                sum += arr[i][j];
            }
        }

        System.out.println(sum);
    }

    public static void bfs(int a, int b, int dust) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, dust});

        while (!q.isEmpty()) {
            int cnt = 0;

            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int w = poll[2];

            // 미세먼지는 인접한 네 방향으로 확산된다.
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 인접한 방향에 공기청정기가 있거나, 칸이 없다면,
                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    if (arr[nx][ny] == -1) {
                        continue;
                    }
                    div = w / 5;

                    arr[nx][ny] += div;
                    cnt++;
                }
            }
            arr[x][y] -= cnt * div;
        }
    }

    public static void rotate(int x) {
        int[][] tmp = new int[R][C];
        // i < R , 0 < C

        // go right
        for (int i = 1; i < C - 1; i++) {
            tmp[x][i + 1] = arr[x][i];
        }
        // go down
        for (int i = x; i < R - 1; i++) {
            tmp[i + 1][C - 1] = arr[i][C - 1];
        }
        // go left
        for (int i = C - 1; i >= 1; i--) {
            tmp[R - 1][i - 1] = arr[R - 1][i];
        }
        // go up
        for (int i = R - 1; i >= x + 2; i--) {
            tmp[i - 1][0] = arr[i][0];
        }

        // paste
        for (int i = 1; i < C - 1; i++) {
            arr[x][i] = tmp[x][i];
        }
        // paste
        for (int i = x; i < R - 1; i++) {
            arr[i][C - 1] = tmp[i][C - 1];
        }
        // paste
        for (int i = C - 1; i >= 1; i--) {
            arr[R - 1][i] = tmp[R - 1][i];
        }
        // paste
        for (int i = R - 1; i >= x + 1; i--) {
            arr[i][0] = tmp[i][0];
        }
    }

    public static void rotate_r(int x) {
        int[][] tmp = new int[R][C];
        // i < R , 0 < C

        // go right
        for (int i = 1; i < C - 1; i++) {
            tmp[x][i + 1] = arr[x][i];
        }
        // go up
        for (int i = x; i >= 1; i--) {
            tmp[i - 1][C - 1] = arr[i][C - 1];
        }
        // go left
        for (int i = C - 1; i >= 1; i--) {
            tmp[0][i - 1] = arr[0][i];
        }
        // go down
        for (int i = 0; i < x - 1; i++) {
            tmp[i + 1][0] = arr[i][0];
        }

        // paste
        for (int i = 1; i < C - 1; i++) {
            arr[x][i] = tmp[x][i];
        }
        // paste
        for (int i = x; i >= 1; i--) {
            arr[i][C - 1] = tmp[i][C - 1];
        }
        for (int i = C - 1; i >= 1; i--) {
            arr[0][i] = tmp[0][i];
        }
        for (int i = 0; i < x; i++) {
            arr[i][0] = tmp[i][0];
        }
    }
}

//7 8 50
//0 0 0 0 0 0 0 9
//0 0 0 0 3 0 0 8
//-1 0 5 0 0 0 22 0
//-1 8 0 0 0 0 0 0
//0 0 0 0 0 10 43 0
//0 0 5 0 15 0 0 0
//0 0 40 0 0 0 20 0