package com.ssafy._2023._2023_06.day_06_29;

import java.io.*;
import java.util.*;

public class BJ_15724_주지수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int total = 0;

            for (int j = a; j <= c; j++) {
                total += arr[j][d] - arr[j][b - 1];
            }

            sb.append(total + "\n");
        }

        System.out.println(sb);
    }
}


// 45
// 45 + 10 => 55
//

// a b c d -> a ~ c 행 까지 d열의 값 들을 모두 더한다. - (b-1)열까지의 누적합들
// 1 1 3 2 -> 1 ~ 3 행 까지 2열의 값 들을 모두 더한다. -
// 1 1 1 4 -> 1 ~ 1 행 까지 4열의 값 들을 모두 더한다.
// 1 1 4 4 -> 1 ~ 4 행 까지 4열의 값 들을 모두 더한다.

// 1 3 2 3 인 경우..
// 1 ~ 2 행 까지 3 열 부터 3열 까지만 값들을 모두 더해야한다.