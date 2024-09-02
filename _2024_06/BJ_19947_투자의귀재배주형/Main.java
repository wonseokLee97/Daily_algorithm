package com.ssafy._2024_06.BJ_19947_투자의귀재배주형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 분류: 다이나믹프로그래밍(DP - Bottom to Top)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int[] dp = new int[Y + 1];
        dp[0] = H;

        // 1, 3, 5년
        for (int i = 1; i <= Y; i++) {
            // 매년 작년의 이율에 1년차 이율을 더한다.
            dp[i] = (int) Math.floor(dp[i - 1] * 1.05);

            // 3년차 이상부터는 1년치의 이율과 3년치의 이율 중 더 큰 것을 고른다.
            if (i >= 3) {
                dp[i] = Math.max(dp[i], (int) Math.floor(dp[i - 3] * 1.20));
            }

            // 5년차 이상부터는 1년치의 이율과 3년치의 이율 중 더 큰 것을 고른다.
            if (i >= 5) {
                dp[i] = Math.max(dp[i], (int) Math.floor(dp[i - 5] * 1.35));
            }
        }

        System.out.println(dp[Y]);
    }
}

// 25542

// 초기비용 투자기간
// 95229   3
// Y년을 투자했을 때..
// Y년을 1,3,5년 기준으로 나누어 주자.
//


// 1년마다 5%의 이율을 얻는 투자 (A)
// 3년마다 20%의 이율을 얻는 투자 (B)
// 5년마다 35%의 이율을 얻는 투자 (C)
// 초기비용 투자기간
// 95229   3
// Y년을 투자했을 때..
// Y년을 1,3,5년 기준으로 나누어 주자.
//


// 1년마다 5%의 이율을 얻는 투자 (A)
// 3년마다 20%의 이율을 얻는 투자 (B)
// 5년마다 35%의 이율을 얻는 투자 (C)