package com.ssafy._2023._2023_02.day_02_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int min_len = Integer.MAX_VALUE;

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, cnt = 0, sum = 0, len = 0;

        while (s < N) {

            if (sum >= S || e == N) {
//                System.out.println(cnt + ", " + len + ", " + sum + ", " + min_len);
                if (sum >= S) {
                    min_len = Math.min(min_len, len);
                }
                sum -= arr[s++];
                len--;
            } else {
                sum += arr[e++];
                len++;
            }

//            System.out.println("s: " + s + ", e: " + e  + ", sum: " + sum);
        }

        if (min_len == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min_len);
        }
    }
}
//11 15
//5 1 3 5 10 7 4 9 2 8 15