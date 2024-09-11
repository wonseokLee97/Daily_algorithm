package com.ssafy._2024._04.BJ_2531_회전초밥;

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
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int s = 0;
        int e = s + 1;
        int len = 2;
        int max_len = Integer.MIN_VALUE;

        while (true) {
            if (arr[s] == arr[e]) {
                s++;
                len--;
            } else if (arr[s] != arr[e]) {
                if (arr[e] == c) {
                    s = e + 1;
                    e = s + 1;
                }

                e++;
                len++;
            }

            max_len = Math.max(max_len, len);
        }
    }
}
