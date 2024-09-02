package com.ssafy._2023._2023_03.day_03_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0, e = N - 1, cnt = 0, sum = 0;

        while (s < e) {
            sum = arr[s] + arr[e];

//            System.out.println(arr[s] + ", " + arr[e] + ", " + sum);

            if (sum > M || e == N) {
                e--;
            } else {
                s++;
            }

            // 총합이 M보다 크거나, e(마지막 인덱스)가 N의 크기와 같은 경우 (마지막에 도달한 경우)
            if (sum == M) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
