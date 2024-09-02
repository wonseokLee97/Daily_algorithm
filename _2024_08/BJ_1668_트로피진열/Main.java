package com.ssafy._2024_08.BJ_1668_트로피진열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int lCnt = 1;
        int rCnt = 1;

        int maxBefore = arr[0];
        // 현재 트로피가 이전 트로피보다 높이가 같거나 낮다면 셀 수 없다.
        for (int i = 1; i < N; i++) {
            maxBefore = Math.max(maxBefore, arr[i - 1]);
            int now = arr[i];
//            System.out.println(before + ", " + now);
            if (maxBefore >= now) {
                continue;
            }

            maxBefore = now;
            lCnt++;
        }

        maxBefore = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxBefore = Math.max(maxBefore, arr[i + 1]);
            int now = arr[i];

            if (maxBefore >= now) {
                continue;
            }

            maxBefore = now;
            rCnt++;
        }

        System.out.println(lCnt);
        System.out.println(rCnt);
    }
}

// 5
// 1 2 3 4 5
// 5개
// 1개