package com.ssafy._2023.day_04_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14712_넴모넴모 {

    static int N, M, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        res = 0;

        dfs(-1, -1, arr);

        System.out.println(res);
    }

    public static void dfs(int x, int y, int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        if (isRec(arr)) {
            res += 1;
        }

        System.out.println(x + ", " + y + ", res: " + res);
        System.out.println();


        // 4방향
        if (isIn(x + 1, y) && arr[x + 1][y] == 0) {
            System.out.println("아래");
            arr[x + 1][y] = 1;
            dfs(x + 1, y, arr);
            arr[x + 1][y] = 0;
        }

        if (isIn(x, y + 1) && arr[x][y + 1] == 0) {
            System.out.println("왼쪽");
            arr[x][y + 1] = 1;
            dfs(x, y + 1, arr);
            arr[x][y + 1] = 0;
        }

        if (isIn(x - 1, y) && arr[x - 1][y] == 0) {
            System.out.println("위");
            arr[x - 1][y] = 1;
            dfs(x - 1, y, arr);
            arr[x - 1][y] = 0;
        }

        if (isIn(x, y - 1) && arr[x][y - 1] == 0) {
            System.out.println("왼쪽");
            arr[x][y - 1] = 1;
            dfs(x, y - 1, arr);
            arr[x][y - 1] = 0;
        }

        if (isIn(x + 1, y + 1) && arr[x + 1][y + 1] == 0) {
            System.out.println("대각아래");
            arr[x + 1][y + 1] = 1;
            dfs(x + 1, y + 1, arr);
            arr[x + 1][y + 1] = 0;
        }
    }

    private static boolean isRec(int[][] arr) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                // 2x2 가 정사각형이라면?
                if (arr[i][j] == 1 && arr[i + 1][j] == 1
                        && arr[i][j + 1] == 1 && arr[i + 1][j + 1] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isIn(int x, int y) {
        if ((x < N && x >= 0) && (y < M && y >= 0)) {
            return true;
        } else {
            return false;
        }
    }
}

// 64 - 4 - 2 - 1
