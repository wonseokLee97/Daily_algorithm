package com.ssafy._2023_02.day_02_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 해당 범위에 접근하게되면 break and count
// else 계속 탐색
public class BJ_2583_영역구하기 {

    static List<Integer> list;
    static int arr[][], N, M, K, cnt,
    dx[] = {-1, 1, 0, 0},
    dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        arr = new int[M][N];
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = 0;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int xa = Integer.parseInt(st.nextToken());
            int ya = M - Integer.parseInt(st.nextToken());
            int xb = Integer.parseInt(st.nextToken());
            int yb = M - Integer.parseInt(st.nextToken());

            // 2 ~ 4 -> 3 ~ 1
            for (int j = xa; j < xb; j++) {
                for (int k = yb; k < ya; k++) {
                    arr[k][j] = 1;
                }
            }
        }

//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }


        Collections.sort(list);
        System.out.println(list.size());
        for (int x : list) {
            System.out.print(x + " ");
        }
    }

    public static void dfs(int i, int j) {
        arr[i][j] = 1;
        cnt++;
//        System.out.println(i + ", " + j);
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            // 범위안에 포함되고, 직사각형을 제외한 범위일 경우..
            if (isIn(nx, ny)) {
                if (arr[nx][ny] == 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if ((x >= 0 && x < M) && (y >= 0 && y < N)) {
            return true;
        } else {
            return false;
        }
    }
}


// [0, 2] ~ [4, 4] -> x 좌표는 0부터 4, y 좌표는 2부터 4
// [1, 1] ~ [2, 5] -> x 좌표는 1부터 2, y 좌표는 1부터 5
// [4, 0] ~ [6, 2] -> x 좌표는 4부터 6, y 좌표는 3부터 5
