package com.ssafy.day_220808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            int max_val = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 과자 봉지의 개수
            int M = Integer.parseInt(st.nextToken()); // 무게의 합
            StringBuilder sb = new StringBuilder("");

            int[] arr = new int[N];
            int sum = 0;
            int flag = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 이중 for문 으로 유사 백트래킹을 수행한다.
            for (int i = 0; i < N - 1; i++) {
                sum += arr[i]; // 과자 한 봉지
                for (int j = i + 1; j < N; j++) {
                    sum += arr[j]; // 과자 두 봉지
                    if (sum <= M) { // 최대 무게의 합 보다 작다면
                        flag = 1;
                        max_val = Math.max(max_val, sum);
                    }
                    sum -= arr[j]; // 두 번째 과자 -
                }
                sum -= arr[i]; // 첫 번째 과자 -
            }

            if (flag == 1) {
                sb.append("#" + t + " " + max_val);
            } else {
                sb.append("#" + t + " " + -1);
            }
            System.out.println(sb);
        }
    }
}

