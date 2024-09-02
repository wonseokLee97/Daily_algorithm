package com.ssafy._2023._2023_06.day_06_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10986_나머지합 {

    static int N, M, arr[], dp[];
    static long mod[];

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dp = new int[N + 1];
        mod = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + arr[i];
            dp[i] %= M;
            mod[dp[i]]++;
        }

        // System.out.println(Arrays.toString(dp));

        // 나누었을 때 0인 경우
        long cnt = mod[0];

        // M의 최대값 = 1000
        // 1000 * 999 / 2 ->
        for (int i = 0; i < M; i++) {
            cnt += (mod[i] * (mod[i] - 1)) / 2;
        }

        System.out.println(cnt);
    }
}

// a = dp[a - 1], b = dp[b] // a부터 b까지의 누적합을 나눴을 때 0 ㅋ.
// (a - b) % M = 0 을 구해야함!
// (a % M) - (b % M) = 0
// (a % M) = (b % M) 을 구하자!