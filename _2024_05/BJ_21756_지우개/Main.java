package com.ssafy._2024_05.BJ_21756_지우개;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int new_len;
        while (true) {
            if (N == 1) {
                break;
            }

            new_len = N / 2;
            int[] new_arr = new int[new_len + 1];
            int idx = 1;
            for (int i = 2; i <= N; i += 2) {
                new_arr[idx++] = arr[i];
            }

            N = new_len;
            arr = new_arr;
        }

        System.out.println(arr[1]);
    }
}

// idx - 1 2 3 4 5 6 7
// val - 1 2 3 4 5 6 7

// idx - 1 2 3 4 5 6 7
// val - x 2 x 4 x 6 x

// idx - 1 2 3 4 5 6 7
// val - 2 4 6

// idx - 1 2 3 4 5 6 7
// val - 2 4 6