package com.ssafy._2023._2023_06.day_06_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_9252_LCS_2 {

    static int[][] dp;
    static List<Character> list;
    static String A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine();
        B = br.readLine();

        int m = A.length();
        int n = B.length();

        dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 탐색중인 문자열 A, B가 같은경우.. 증가시킨다.
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 탐색중인 문자열 A, B가 다른경우.. 일단 증가는 안됨 ㅋㅋ
                // 두 문자열 중 이전까지의 LCS 중 최대값을 가져온다.
                else if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }


        int i = m;
        int j = n;
        list = new ArrayList<>();

//        while (i > 0 && j > 0) {
//            // 역추적시 문자열 A, B가 같은경우.. tracking
//            if (A.charAt(i - 1) == B.charAt(j - 1)) {
//                list.add(A.charAt(i - 1));
//                i--;
//                j--;
//            }
//            // 역추적시 문자열 A, B가 같지 않은 경우에는 이전 LCS 들 중 최댓값의 위치로 이동한다.
//            else if (dp[i - 1][j] > dp[i][j - 1]) {
//                i--;
//            } else {
//                j--;
//            }
//        }

        LCS(m, n);

        System.out.println(dp[m][n]);
        for (int k = list.size() - 1; k >= 0; k--) {
            System.out.print(list.get(k));
        }
    }

    public static void LCS(int i, int j) {
        if (dp[i][j] == 0) {
            return;
        }

        if (A.charAt(i - 1) == B.charAt(j - 1)) {
            list.add(A.charAt(i - 1));
            LCS(--i, --j);
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            LCS(--i, j);
        } else  {
            LCS(i, --j);
        }
    }
}

//CAPCAK
//ACAYKP
