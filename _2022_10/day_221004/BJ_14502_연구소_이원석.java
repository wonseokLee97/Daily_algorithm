package com.ssafy._2022_10.day_221004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502_연구소_이원석 {
    static int N, M, arr[][], max_cnt = Integer.MIN_VALUE,
            dx[]={-1, 1, 0, 0},
            dy[]={0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(arr, 0);
        System.out.println(max_cnt);
    }


    // 벽의 위치가 중복되지 않으며, 순서에 상관없는 조합
    public static void comb(int[][] arr, int cnt) {
        if (cnt == 3) {
            max_cnt = Math.max(max_cnt, count(arr));
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빈 공간(벽 세울 수 있는 곳)
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    comb(arr, cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }


    public static int count(int[][] arr) {
        int cnt = 0;

        arr = bfs(arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    public static int[][] bfs(int[][] arr) {
        Queue<int[]> q = new LinkedList<>();

        // 기존의 배열이 참조되지 않도록 복사한다.
        int[][] new_arr = new int[N][M];
        new_arr = copy(arr, new_arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (new_arr[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 다음 방향이 범위를 벗어나지않고, 이동할 수 있으며, 방문하지 않았다면..
                if (isIn(nx, ny) && new_arr[nx][ny] == 0) {
                    new_arr[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

//        for (int[] ints : new_arr) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println();

        return new_arr;
    }


    public static int[][] copy(int[][] arr, int[][] new_arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                new_arr[i][j] = arr[i][j];
            }
        }
        return new_arr;
    }


    public static boolean isIn(int nx, int ny) {
        if (0 <= nx && nx < N && 0 <= ny && ny < M) {
            return true;
        }
        return false;
    }
}
