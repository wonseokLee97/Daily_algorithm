package com.ssafy._2023_02.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470_두_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s = 0, e = N - 1, sum = 0, ms = s, me = e;

        // -99 -2 -1 4 98
        // s, e의 합을 구한다. (절대값)
        // 만약 최소값보다 크다면? 갱신 x, s를 늘인다.
        // 만약 최소값보다 작다면? 갱신 o, e를 줄인다.

        int min_val = arr[s] + arr[e];


        // binary search
        while (s < e) {
            sum = arr[s] + arr[e];

            if (Math.abs(sum) < Math.abs(min_val)) {
                ms = s;
                me = e;
                min_val = sum;
                if (sum == 0) {
                    break;
                }
            }

            if (sum > 0) {
                e -= 1;
            } else {
                s += 1;
            }
        }

        System.out.println(arr[ms] + " " + arr[me]);
    }
}
