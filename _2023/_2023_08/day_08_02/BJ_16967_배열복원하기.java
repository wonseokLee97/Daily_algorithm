package com.ssafy._2023._2023_08.day_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16967_배열복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[H + X][W + Y];
        int[][] ans = new int[H][W];

        for (int i = 0; i < H + X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] - arr[i + X][j + Y] > 0) {
                    ans[i - X][j - Y] = arr[i][j] - arr[i + X][j + Y];
                } else if (arr[i][j] - arr[i + X][j + Y] < 0) {
                    ans[i + X][j + Y] = arr[i + X][j + Y] - arr[i][j];
                } else {
                    ans[i][j] = arr[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(ans[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

// 3 3 2 1

// A
// 1 2 3 0
// 4 5 6 0
// 7 9 11 3
// 0 4 5 6
// 0 7 8 9


// B의 i, j는 C의 (i+X), (j+Y) 이다.
// 0, 0과 2, 1의 차를 구한다.

// B
// 1 2 3 0
// 4 5 6 0
// 7 8 9 0
// 0 0 0 0
// 0 0 0 0

// C
// 0 0 0 0
// 0 0 0 0
// 0 1 2 3
// 0 4 5 6
// 0 7 8 9

// A = B + C
// B = A - C

//3 3 2 2
//1 2 3 0 0
//4 5 6 0 0
//7 8 10 2 3
//0 0 4 5 6
//0 0 7 8 9