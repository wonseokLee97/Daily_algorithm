package com.ssafy._2024_06.BJ_2624_동전바꿔주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T, k, ans, dp[][], coins[], count[];
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        dp = new int[k + 1][T + 1];
        coins = new int[k];
        count = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            coins[i] = p;
            count[i] = n;
        }

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            int coin_cost = coins[i - 1];
            int coin_count = count[i - 1];

            // T원 까지
            for (int j = 1; j <= T; j++) {
                for (int l = 0; l <= coin_count; l++) {
                    // i(동전을 고른 횟수)번째에 j원이 되기 위해서는..
                    // i-1(이전에 동전을 고른 횟수)번째에 j원 - i번째 동전의 개수를 고른 돈
                    // 이 0보다 커야한다!
                    if (j - coin_cost * l < 0) break;

                    // 현재 고르고자 하는 동전의 (종류, 총합) 횟수
                    // 이전까지 골랐던 동전의 (종류, 총합) 횟수
                    // dp[i - 1][j - (coin_cost * l)];
                    dp[i][j] += dp[i - 1][j - (coin_cost * l)];
                }
            }
        }


        System.out.println(dp[k][T]);
    }
}

//20
//3
//1 5
//5 3
//10 2

// 1,000,000

// [0, 1, 1, 1, 1, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1]

// 10원 짜리, 5원 짜리, 1원 짜리 동전이 각각 2개, 3개, 5개씩 있을 때
// 10: 2 [10, 20]
// 5: 3 [5, 10, 15]
// 1: 5 [1, 2, 3, 4, 5]

// 10 = 10 x 1
// 10 = 5 x 2
// 10 = 5 x 1 + 1 x 5

// 20을 10, 5, 1로 나누어볼까?
// 10: 10, 20
// dp[10] = 1, dp[20] = 1

// 5: 5, 10, 15
// dp[5] = 1, dp[10] = 2, dp[15] = 1

// 1: 1, 2, 3, 4, 5
// dp[1] = 1, dp[2] = 1, dp[3] = 1, dp[4] = 1, dp[5] = 2


// dp[1] = 1;
// dp[5] = 1;
// dp[10] = 1;
// dp[15] = 1;

// dp[20] = 1;

// dp[50] = 1;
// dp[40] = 1;
// dp[10] = 1;