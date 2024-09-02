package com.ssafy._2024_08.BJ_11403_경로찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경유지
        for (int k = N-1; k >= 0; k--) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // i -> k, k -> j로 가는 길이 모두 존재할 때
                    if (arr[i][k] * arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int i : ints) {
                sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
