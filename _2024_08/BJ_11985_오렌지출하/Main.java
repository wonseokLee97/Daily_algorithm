package com.ssafy._2024_08.BJ_11985_오렌지출하;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        // 1번 오렌지부터 N번 오렌지까지
        // dp[i] = i까지 오렌지를 담았을 때, 최소값
        for (int i = 1; i <= N; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // 최대 오렌지 개수를 채우기 전 까지
            for (int j = 1; j <= M; j++) {
                // 최대개수를 초과하면 break
                if (i < j) break;

                // 순서대로 오렌지를 넣기 때문에,
                // i가 2 (2 까지 오렌지를 담았다)
                // j가 1, j가 2
                // (2-1+1 = 2) ~ (2-2+1 = 1), 1~2번의 오렌지 중
                // 가장 큰 무게와 작은 무게를 찾는다.
                max = Math.max(max, arr[i - j + 1]);
                min = Math.min(min, arr[i - j + 1]);
                dp[i] = Math.min(dp[i], dp[i - j] + K + (long) j * (max - min));
            }
        }
    }
}

// idx: 1 2 3 4 5 6
// wei: 1 2 3 1 2 1

//

// (1 2 3) = 6 + 3 * 3-1 = 12
// (1 2 1) = 6 + 3 * 2-1 =  9




// 컨베이어 벨트 위에 놓여져있는 오렌지는 앞에서부터 순서대로
// 1부터 N까지 번호가 붙여져 있다. (i번째 오렌지의 크기는 Ai이다.)

// 그 다음 작업은 오렌지를 앞에서부터 순서대로 상자에 나눠서 넣는 것이다.
// 한 상자 넣는 오렌지의 번호는 연속해야 한다.

// 한 상자에는 최대 M개의 오렌지를 넣을 수 있다.
// 상자에 오렌지를 넣는 비용은 K + s × (a − b) 로 구할 수 있다.
// 여기서 a는 상자에 넣은 가장 큰 오렌지의 크기,
// b는 상자에 넣은 가장 작은 오렌지의 크기,
// s는 상자에 넣은 오렌지의 개수이다.

// K는 상자를 포장하는 비용이고, 모든 상자에 공통적으로 적용되는 값이다.

// 컨베이어 벨트 위에 놓여져 있는 오렌지의 정보와,
// 한 상자에 넣을 수 있는 오렌지 개수의 최댓값,
// 상자를 포장하는 비용 K가 주어졌을 때,
// 모든 오렌지를 포장하는 비용의 최솟값을 구하는 프로그램을 작성하시오.