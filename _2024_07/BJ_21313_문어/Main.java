package com.ssafy._2024_07.BJ_21313_문어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][9];
        StringBuilder sb = new StringBuilder();

        // 문어
        for (int i = 0; i < N; i++) {
            // 잡을 손
            for (int j = 1; j <= 8; j++) {
                if (arr[i][j] == 1 || arr[(i + 1) % N][j] == 1) {
                    continue;
                }

                arr[i][j] = 1;
                arr[(i + 1) % N][j] = 1;
                sb.append(j + " ");
                break;
            }
        }

        System.out.println(sb);
    }
}

// int[N+1][9]
// O [1] O [2] O [1] O [2] O [1]

