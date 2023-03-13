package com.ssafy._2023_03.day_03_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1359_복권 {
    static int N, M, K, arr[], arr2[], total, up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1 부터 N 개의 수 중에서 서로 다른 M개를 고르라
        // 조합(comb)
        // 1 ~ 3 - 1, 3C1
        // 1, 2, 3
        // 1, 2 / 2, 3 / 1, 3 /
        // 첫 번째 combination 을 구한다.
        //

        arr = new int[N];
        arr2 = new int[N];

        comb(0, 0);

        double result = up / (double) total;
        System.out.printf("%.16f", result);
    }



    public static void comb(int start, int cnt) {
        if (cnt == M) {
            // 포함될 때!
            new_comb(0, 0, arr);

            return;
        }

        for (int i = start; i < N; i++) {
            arr[i] = 1;
            comb(i + 1, cnt + 1);
            arr[i] = 0;
        }
    }

    // [1, 0, 0], [0, 1, 0], [0, 0, 1]
    // [1, 0, 0]
    // [0, 1, 0]
    // [0, 0, 1]
    // 각각의 확률을 더해 /N 하자.
    public static void new_comb(int start, int cnt, int[] arr) {
        if (cnt == M) {
            int acc = 0;
            total++;

            for (int i = 0; i < N; i++) {
                if (arr[i] == 0) {
                    continue;
                }

                if (arr[i] == arr2[i]) {
                    acc++;
                }
            }

            if (acc >= K) {
                up++;
            }
        }

        for (int i = start; i < N; i++) {
            arr2[i] = 1;
            new_comb(i + 1, cnt + 1, arr);
            arr2[i] = 0;
        }
    }
}






// [1, 1, 0], [1, 0, 1], [0, 1, 1]
// [1, 1, 0] 1
// [1, 0, 1] 1
// [0, 1, 1] 1
// 3 / 3 => 1