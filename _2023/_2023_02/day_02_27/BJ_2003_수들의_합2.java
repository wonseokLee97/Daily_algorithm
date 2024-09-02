package com.ssafy._2023._2023_02.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2003_수들의_합2 {

    static int arr[], N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        System.out.println(two_pointer());
    }

    public static int two_pointer() {
        int s = 0;
        int e = 0;
        int cnt = 0;
        int sum = 0;

        // 모든 가르키는 인덱스가 끝으로 갈 때까지
        while (s < N) {
            // s를 증가시키는 경우.. (부분합이 N보다 큰 경우이거나 end_point 가 끝 점에 도달할 경우)
            if (sum > M || e == N) {
                sum -= arr[s++];
            } else { // e를 증가시키는 경우
                sum += arr[e++];
            }


            if (sum == M) {
                cnt++;
            }
        }

        return cnt;
    }
}
