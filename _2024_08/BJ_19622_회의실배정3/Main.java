package com.ssafy._2024_08.BJ_19622_회의실배정3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 2][2];

        for (int i = 2; i <= n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st.nextToken();
            int cur = Integer.parseInt(st.nextToken());

            // 회의를 하지않는 경우,
            // 1. 이전 회의를 개최한 경우
            // 2. 이전 회의를 개최하지 않는 경우
            // 중 최대값
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

            // 회의를 하는 경우, 이전의 회의와는 무조건 겹치기 떄문에
            // 1. 이전 회의가 없는 경우
            // 2. 전전 회의가 있는 경우 (전전 회의와는 겹칠일이 없기 때문에 무조건 있는 경우로 생각)
            // 중 최대값
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][1]) + cur;
        }


        System.out.print(Math.max(dp[n + 1][0], dp[n + 1][1]));
    }
}


// 각 회의는 시작 시간, 끝나는 시간, 회의 인원이 주어지고
// 한 회의실에서 동시에 두 개 이상의 회의가 진행될 수 없다.
// 단, 회의는 한번 시작되면 중간에 중단될 수 없으며
// 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
// 회의의 시작 시간은 끝나는 시간보다 항상 작다.

// N개의 회의를 회의실에 효율적으로 배정할 경우 회의를 진행할 수 있는 최대 인원을 구하자.