package com.ssafy._2024_07.BJ_2229_조짜기;

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
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int j = i; j > 0; j--) {
                minVal = Math.min(minVal, arr[j]);
                maxVal = Math.max(maxVal, arr[j]);

                dp[i] = Math.max(dp[j - 1] + (maxVal - minVal), dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}


// 10
// 2 5 7 1 3 4 8 6 9 3

// case 1:
// 1

// case 2:
// [1]+[2] - dp[1] + (max-min)
// [1 2]   - (max-min)

// case 3:
// [1 2]+[3] - dp[2] + (max-min)
// [1]+[2 3] - dp[1] + (max-min)
// [1 2 3]   - (max-min)

// case 4:
// [1 2 3]+[4] - dp[3] + (max-min)
// [1 2]+[3 4] - dp[2] + (max-min)
// [1]+[2 3 4] - dp[1] + (max-min)
// [1 2 3 4]   - (max-min)