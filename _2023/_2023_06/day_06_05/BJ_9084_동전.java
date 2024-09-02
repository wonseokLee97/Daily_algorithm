package com.ssafy._2023._2023_06.day_06_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_9084_동전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> coins = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int coin = Integer.parseInt(st.nextToken());
                coins.add(coin);
            }

            int money = Integer.parseInt(br.readLine());
            int[] dp = new int[money + 1];

            for (int i = 0; i < N; i++) {
                // x원의 경우에는 x원 동전 하나로 만들 수 있기 때문에 1을 더해준다.
                dp[coins.get(i)] += 1;

                // x원 부터 money 까지..
                for (int j = coins.get(i); j <= money; j++) {
                    // 현재의 동전이 2원일 경우..4원을 만들기 위해서는 2원을 만드는 방법에
                    // 2원을 더하면 되기 떄문에 2원을 만드는 방법의 개수를 더해준다.
                    dp[j] += dp[j - coins.get(i)];
                }
            }

            System.out.println(dp[money]);
        }
    }
}

//1
//2
//5 7
//22