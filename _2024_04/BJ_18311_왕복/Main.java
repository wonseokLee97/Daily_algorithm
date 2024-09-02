package com.ssafy._2024_04.BJ_18311_왕복;

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
        long K = Long.parseLong(st.nextToken());

        long[] arr = new long[N + 1];
        long sum = 0;
        arr[0] = sum;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

//        System.out.println(Arrays.toString(arr));

        long now = K;
        if (K > sum) {
            now = (sum * 2) - K;
        }

        int idx = 1;
        for (int i = 1; i <= N; i++) {
            if (arr[i] > now) {
                idx = i;
            } else if (arr[i] == now) {
                if (i == N) {
                    idx = i;
                } else {
                    idx = i + 1;
                }
            } else {
                continue;
            }

            break;
        }

        System.out.println(idx);
    }
}

// 이동 거리 K가 최종 길이보다 길다면, (max_len * 2)44 - K가 위치한 곳을 찾자.