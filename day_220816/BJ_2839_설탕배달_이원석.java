package com.ssafy.day_220816;

import java.util.Scanner;

public class BJ_2839_설탕배달_이원석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] dp = new int[5001];

        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (i % 5 == 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (i % 3 == 0) {
                dp[i] = dp[i - 3] + 1;
            } else {
                if (dp[i - 3] == 0 || dp[i - 5] == 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }

        if (dp[n] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }


//        while (n > 0) {
//            if (n % 5 == 0) { // 5만큼 가져가서 끝낼 수 있다면
//                sum += n / 5;
//                break;
//            }
//            n -= 3; // 3만큼 가져간다
//            sum++; // 회수 증가
//        }
//
//        if (n < 0) { // 설탕을 알맞게 가져가지 못했다면
//            System.out.println(-1);
//        } else {
//            System.out.println(sum);
//        }
    }
}
