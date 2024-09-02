package com.ssafy._2023._2023_07.day_07_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15565_귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int min_val = Integer.MAX_VALUE;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int cnt = 0;

        while (e < N) {
//            System.out.println(s + ", " + e + ", " + cnt);

            // K 개보다 작다면
            if (cnt < K) {
                if (arr[e] == 1) {
                    cnt++;
                }

                e++;

            } else {
                if (arr[s] == 1) {
                    min_val = Math.min(min_val, e - s);
                    cnt--;
                }
                s++;
            }
        }

        while (s < N) {
            if (cnt < K) {
                break;
            }

            if (arr[s] == 1) {
                min_val = Math.min(min_val, e - s);
                cnt--;
            }
            s++;
        }

        if (min_val == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min_val);
        }
    }
}

// 라이언 1
// 어피치 2
// N개