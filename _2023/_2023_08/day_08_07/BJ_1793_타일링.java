package com.ssafy._2023._2023_08.day_08_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_1793_타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];

        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(3);


        for (int i = 3; i < 251; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
        }

        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            }
            int n = Integer.parseInt(s);
            System.out.println(dp[n]);
        }
    }
}

// 2 x n의 타일을 2x1 2x2 의 타일로 채우는 법!
// 1) n - 1크기의 타일에서 2x1 타일을 추가하는 방법
// 2) n - 2크기의 타일에서 2x2 타일을 추가하는 방법
// 3) n - 2크기의 타일에서 2x1 타일을 2개 추가하는 방법
// dp[i] = dp[i - 1] + dp[i - 2] * 2