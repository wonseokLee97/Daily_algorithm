package com.ssafy._2024_07.BJ_짐챙기는숌_1817;

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
        int[] arr = new int[N];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < N; i++) {
            // 박스의 수용치를 넘는다면
            if (sum + arr[i] > M) {
                sum = arr[i];
                cnt++;
            } else {
                sum += arr[i];
            }
        }

        System.out.println(cnt);
    }
}