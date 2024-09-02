package com.ssafy._2024_08.BJ_15810_풍선공장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long ans = 0;
        long s = 0;
        long e = (long) arr[N - 1] * (long) M;

        while (s <= e) {
            long mid = (s + e) / 2;

            if (b(mid) >= M) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static long b (long time) {
        long total = 0;
        for (int t : arr) {
            total += time / t;
        }

        return total;
    }
}

// N: 3, M: 8

// 1 2 3
// 5 7 3


// 시간 5 6 7 8 9 10 11 12 13 14 15 ...
// 풍선 2 3 4 4 5  6  6  7  7  8 10
// 8개가 되는 하한선을 구해야 한다.
// 따라서,
// if (b(mid) >= 8) {
//     정답일 수 있음.
// } else {
//     8 미만이기 때문에 정답일 수 없다.
// }

// 1. 시간 mid 를 잡고, 그 동안 풍선이 몇 개 불어졌는가?
// 2. 만약 M개보다 많이 불었다면 시간을 줄이자.
// 3. 만약 M개보다 적게 불었다면 시간을 늘이자.
