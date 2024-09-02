package com.ssafy._2024_07.BJ_11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                dp[i][j] = dp[i][j - 1] + arr[i][j];
            }
        }

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2) {
                System.out.println(arr[x1][y1]);
                continue;
            }

            int minX = Math.min(x1, x2);
            int maxX = Math.max(x1, x2);
            int minY = Math.min(y1, y2);
            int maxY = Math.max(y1, y2);

            int total = 0;

            for (int j = minX; j <= maxX; j++) {
                total += dp[j][maxY] - dp[j][minY - 1];
            }

            sb.append(total + "\n");
        }
        System.out.println(sb);
    }
}

// (minX, minY) - (minX, maxY)
// (maxX, minY) - (maxX, maxY)

// (2, 2) - (2, 4)
// (3, 2) - (3, 4)

// (3, 4) ~ (4, 4)
// (3, 3) - (3, 4)
// (4, 3) - (4, 4)
// x나 y가 같으면 한 줄!

//  [arr]
// 1 2 3 4
// 2 3 4 5
// 3 4 5 6
// 4 5 6 7

//  [sum]
// 1 3  6 10
// 2 5  9 14 = 14 - 2 = 12
// 3 7 12 18 = 18 - 3 = 15
// 4 9 15 22

// (2, 2) ~ (3, 4)
// minX = 2
// minY = 2
// maxX = 3
// maxY = 4

// 열의 최대, 행의 최소
// (2, 2) ~ (3, 4)
// (2, 2) (2, 3) (2, 4)
// (3, 2) (3, 3) (3, 4)