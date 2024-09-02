package com.ssafy._2024_08.BJ_2167_2차원배열의합;

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
        int[][] arr = new int[N][M];
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1] + arr[i - 1][j - 1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int ans = 0;
            if (i == x && j == y) {
                ans = dp[x][y] - dp[i][j - 1];
            } else {
                for (int l = i; l <= x; l++) {
                    ans += dp[l][y] - dp[l][j - 1];
                }
            }

            System.out.println(ans);
        }
    }
}


// 1 2 4
// 8 16 32

// 0 0 0 0
// 0 1 3 7
// 0 8 24 56
// i j x y
// 1 1 2 3
// 1 1 ~ [1 3] | 7 - 0
// [2 1] ~ 2 3 | 56 - 0 -> 63

// 1 2 1 2
// 1 2 ~ 1 2 | 3 - 1
// 1 2 ~ 1 2 |

// 같은 행에서의 비교는 한 번만

// 1 2 1 3
// 1 2 ~ 1 3 | 7 - 1 = 6

// 1 3 2 3
// 1 3 ~ [1 3] | 7 - 3
// [2 3] ~ 2 3 | 56 - 24 -> 4 + 32 36