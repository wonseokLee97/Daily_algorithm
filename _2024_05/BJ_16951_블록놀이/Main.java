package com.ssafy._2024_05.BJ_16951_블록놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int[] tmp = new int[N];
            int flag = 0;
            int p = arr[i];

            for (int j = 0; j < N; j++) {
                tmp[j] = p + (K * (j - i));

                if (tmp[j] <= 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                continue;
            }

            int time = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j] - tmp[j] != 0) {
                    time++;
                }
            }

            min_val = Math.min(min_val, time);
        }

        System.out.println(min_val);
    }
}

// 욱제가 1분 동안 할 수 있는 작업
// 탑 하나를 고르고, 탑에 블록을 더 놓아서 높이를 크게 만드는 것
// 또는 탑에서 블록을 빼서 높이를 작게 만드는 것이다.

// 4 1
// 1 2 1 5
// 1 2 3 4
// 1 2 3 4
// -1 0 1 2
// 2 3 4 5

// 1 5 차이가 4!
// 2 5 차이가 3!
// 3 5 차이가 2!
// 3 4 차이가 1!