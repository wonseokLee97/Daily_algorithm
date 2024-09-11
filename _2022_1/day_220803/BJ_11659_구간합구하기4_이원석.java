package com.ssafy._2022_1.day_220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기4_이원석 {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 동적계획법을 위한 배열 선언 N의 크기보다 하나 크게 선언해준다.
        // 1부터 x 까지의 합을 구해 배열에 할당할텐데, 예를들어
        // 2부터 4 까지의 합은 -> 1부터 4까지의 합 - 1부터 1까지의 합
        // 1부터 4 까지의 합을 구할때 -> 1부터 4까지의 합 - 0의 로직을 구현하기 위함이다.
        int[] dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = arr[0];

        for (int i = 1; i < N + 1; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[b] - dp[a - 1]);
        }
    }
}

//   1-2, 1-3, 1-4, 1-5
// [5, 9, 12, 14, 15]
//  2-4
// 1-1 - 1-4

// 2-2 to 3-4 = (1-1 to 3-4) - (1-1 to 2-1)