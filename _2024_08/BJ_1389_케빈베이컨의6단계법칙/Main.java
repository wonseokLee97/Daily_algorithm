package com.ssafy._2024_08.BJ_1389_케빈베이컨의6단계법칙;

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

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            arr[A][B] = 1;
            arr[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i == j) {
                        continue;
                    }

                    // i->k가 아는 사이이고, k->j가 아는 사이일 때!
                    // i->j는 두 케빈 베이컨의 합이다.
                    if (arr[i][k] != 0 && arr[k][j] != 0) {
                        if (arr[i][j] != 0) {
                            arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        } else {
                            arr[i][j] = arr[i][k] + arr[k][j];
                        }
                    }
                }
            }
        }

        int[] kevin = new int[N + 1];
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += arr[i][j];
            }

            minVal = Math.min(minVal, total);
            kevin[i] = total;
        }

        for (int i = 1; i <= N; i++) {
            if (kevin[i] == minVal) {
                System.out.println(i);
                break;
            }
        }
    }
}

// 0 2 1 1 2 - 6
// 2 0 1 2 3 - 8
// 1 1 0 1 2 - 5
// 1 2 1 0 1 - 5
// 2 3 2 1 0 - 8