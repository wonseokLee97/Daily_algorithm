package com.ssafy._2024_07.BJ_2302_극장좌석;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[41];
        for (int i = 0; i < M; i++) {
            int s = Integer.parseInt(br.readLine());
            vip[s] = 1;
        }

        int cnt = 0;
        int ans = 1;
        for (int i = 1; i <= N; i++) {
            // VIP 좌석인 경우..
            if (vip[i] == 1) {
                ans *= dp[cnt];
                cnt = 0;
                continue;
            }

            cnt++;
        }

        ans *= dp[cnt];

        System.out.println(ans);
    }
}

// idx  1 2 3 4 5 6 7 8 9
// sit        X     X
// can  1 2 3   5 6   8 9
//      2 1 2   6 5   9 8
//        3

// 123, 122, 113, 112, 133, 132
// 223, 222, 213, 212, 233, 232

// idx | 1 2 3 4 5 6 7 8 9
//  1  | O O X X
//  2  | O O O X
//  3  | X O O X
//  4  | X X X X
//  5  | X X X X

// dp[i][j] = dp[i][j - 1]


// 123, 132, 213
// 56, 65
// 89, 98


// idx  1 2 3 4 5 6 7 8 9
// sit        X     X
// can  1 2 3   5 6   8 9
//      2 1 2   6 5   9 8
//        3

// 123, 122, 113, 112, 133, 132
// 223, 222, 213, 212, 233, 232

// idx | 1 2 3 4 5 6 7 8 9
//  1  | O O X X
//  2  | O O O X
//  3  | X O O X
//  4  | X X X X
//  5  | X X X X

// dp[i][j] = dp[i][j - 1]


// 123, 132, 213
// 56, 65
// 89, 98

//9
//2
//4
//6