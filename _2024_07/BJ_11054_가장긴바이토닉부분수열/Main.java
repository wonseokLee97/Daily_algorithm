package com.ssafy._2024_07.BJ_11054_가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dpI = new int[N + 1]; // 증가
        int[] dpD = new int[N + 1]; // 감소
        dpI[1] = 1;
        dpD[N] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dpI[i] = Math.max(dpI[i], dpI[j] + 1);
                } else if (arr[i] == arr[j]) {
                    dpI[i] = Math.max(dpI[i], dpI[j]);
                } else {
                    dpI[i] = Math.max(dpI[i], 1);
                }
            }
        }

        for (int i = N - 1; i >= 1; i--) {
            for (int j = N; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dpD[i] = Math.max(dpD[i], dpD[j] + 1);
                } else if (arr[i] == arr[j]) {
                    dpD[i] = Math.max(dpD[i], dpD[j]);
                } else {
                    dpD[i] = Math.max(dpD[i], 1);
                }
            }
        }


        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dpD[i] + dpI[i] - 1);
        }

        System.out.println(ans);
    }
}

// 1 5 2 1 4 3 4 5 2 1
// 1 2 2 1 3 3 4 5 2 1 - 증가하는 부분 수열
// 1 1 2 3 2 3 2 1 4 5 - 감소하는 부분 수열

// 1. 증가하는 부분 수열을 구한다.
// 2. 순회하며 해당 idx를 기준으로 감소하는 부분 수열을 찾으며 개수를 추가한다.
// 3.

// 1   2     3 4 5 2 1