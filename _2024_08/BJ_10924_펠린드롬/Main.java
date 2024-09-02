package com.ssafy._2024_08.BJ_10924_펠린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        // 1-1
        // 1-2, 2-2
        // 1-3, 2-3, 3-3
        // 1-4, 1-3, 1-2, 1-1
        st = new StringTokenizer(br.readLine());
        for (int j = 1; j <= N; j++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[j] = temp;

            for (int i = 1; i <= j; i++) {
                // 길이가 같은 경우 (한 자리) ex) 1 ~ 1
                if (i == j) {
                    dp[i][j] = 1;
                }
                // 길이가 2인 경우 ex) 1 ~ 2
                else if (j - i == 1) {
                    if (arr[j] == arr[i]) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                // 길이가 3이상인 경우 ex) 1 ~ 3
                else {
                    // 각 시작과 끝 값이 같고, (i+1, j-1)의 값이 펠린드롬인 경우
                    if (arr[j] == arr[i] && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e] + "\n");
        }

        System.out.println(sb);
    }
}
