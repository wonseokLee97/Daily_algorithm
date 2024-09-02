package com.ssafy._2024_04.BJ_7579_앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] m = new int[N];
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] c = new int[N];
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][100001];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int cost = c[i];
            int memory = m[i];

            for (int j = 0; j <= 10000; j++) {
                // 첫 번째 앱이면
                if (i == 0) {
                    // 비용을 할당할 수 있는 구간부터 최대 메모리 기록
                    if (cost <= j) {
                        dp[i][j] = memory;
                    }
                } else {
                    if (cost <= j) {
                        // 이전 앱까지의 메모리와
                        // 이전 앱까지에서 비용을 뺀(이번 앱을 써야하니까) + 이번 앱의 memory
                        dp[i][j] = Math.max(
                                dp[i - 1][j],
                                dp[i - 1][j - cost] + memory);
                    } else {
                        // 이번 앱을 사용할 수 있는 비용 전까지는
                        // 이전 앱까지의 메모리 사용
                        dp[i][j] = dp[i - 1][j];
                    }
                }

                // 필요한 메모리 보다 크거나 같은 경우
                // 현재까지의 누적 cost와 정답의 최소값 비교
                if (dp[i][j] >= M) {
                    ans = Math.min(ans, j);
                }
            }
        }
        System.out.println(ans);

    }
}


// N개의 앱 A1, ... , An
// 메모리   m1, ... , mn
// 재실행   c1, ... , cn

// 앱 B를 실행.. mB 만큼의 메모리가 소요됨.
// 몇 개를 비활성화 해야 mB 바이트 이상의 메모리를 추가확보할 수 있는거ㅏ?

// 5개의 앱, 총 135바이트의 메모리가 사용중
// 새로운 앱을 구동할 때 60바이트를 확보해야 한다.

// 재가동 비용 C가 최소가 되도록 해야한다!
// 30 10 20 35 40
//  3  0  3  5  4

// dp[i - 1][j] -> 이전 앱 활용에서의 최대 메모리
// dp[i - 1][j - c] + m -> 이전 앱 활용에서 현재 메모리를 빼준 메모리 + 빼준 비용의 메모리
//         비용 0   1   2   3   4   5   6
// 입력된 앱  \
//       0     0   0   0  30  30  30  30
//       1    10  10  10  40  40  40  40
//       2    10  10  10  40  40  40  60
//       3
//       4