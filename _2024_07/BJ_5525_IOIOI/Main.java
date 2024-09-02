package com.ssafy._2024_07.BJ_5525_IOIOI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int[] dp = new int[1000001];
        for (int i = 1; i < 1000001; i++) {
            dp[i] = 3 * i + 2;
        }

        char[] cArr = S.toCharArray();

        int total = 0;
        int cnt = 0;
        int flag = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == 'I') {
                if (i == 0) {
                    total += 2;
                } else if (i > 0) {
                    if (cArr[i - 1] != 'I') {
                        total += 2;
                    } else {
                        total = 2;
                    }
                }
            } else {
                if (i > 0) {
                    if (cArr[i - 1] != 'O') {
                        total += 1;
                    } else {
                        total = 0;
                    }
                }
            }

            if (total == dp[N]) {
                total -= 3;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

// 0 1 2 3 4 5 6 7 8 9 10 11 12 13
// O O I O I O I O I O  I  O  I
// dp[N] = dp[N - 1] + 2
// P1 - IOI - 212 = 5
// P2 - IOIOI - 21212 = 8
// P3 - IOIOIOI - 2121212 = 11
// P4 - IOIOIOIOI - 212121212 = 14
// PN - IOIOI...OI (O가 N개, I가 N+1개 = 3*N+2
//
// PN -> I가 N+1개, O개 N개
// S문자열을 탐색한다. 항상 시작은 I!
// for S를 순회
//  I를 찾았다!
//  for 해당 idx를 기준으로 S를 탐색한다.
//  만약 이전 idx와 지금 idx의 값이 같다면 탈출