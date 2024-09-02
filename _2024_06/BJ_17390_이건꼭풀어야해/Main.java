package com.ssafy._2024_06.BJ_17390_이건꼭풀어야해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + arr[i - 1];
        }


        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            ans.append(dp[R] - dp[L - 1]);
            ans.append("\n");
        }

        System.out.println(ans);
    }
}


// 욱제는 또 출제를 해야 해서 단단히 화가 났다.
// 그래서 욱제는 길이 N짜리 수열 A를 만들고,
// A를 오름차순으로 정렬해서 수열 B를 만들어 버렸다!!

// 여기서 B를 출력하기만 하면 문제가 너무 쉬우니까 하나만 더 하자.
// 아래와 같은 질문이 무려 Q개나 주어진다!! (ㅎㅎ;; ㅈㅅ.. ㅋㅋ!!)
//
// L R: BL + BL+1 + ... + BR-1 + BR 을 출력한다.

// N Q
// 5 6
// 2 5 1 4 3
// 1 5 - B1 + B2 + B3 + B4 + B5
// 2 4 - B2 + B3 + B4
// 3 3
// 1 3
// 2 5
// 4 5

// 1 2 3 4 5

// dp[4] - dp[1] 은 1~4까지의 합에서 1까지의 합을 뺀 경우