package com.ssafy._2024_08.BJ_1654_랜선자르기;

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
        int K = Integer.parseInt(st.nextToken()); // 이미 가진 랜선의 개수
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        long[] arr = new long[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        // 랜선의 길이는 2^31-1 너무 길어.
        // 이분 탐색 고

        // 랜선의 최소 길이
        long s = 1;
        // 랜선의 최대 길이
        long e = arr[K - 1];
        long ans = 0;

        while (s <= e) {
            long mid = (s + e) / 2;
            int total = 0;

            for (int i = 0; i < K; i++) {
                // 랜선을 나누자
                total += arr[i] / mid;
            }

//            System.out.println(s + ", " + e + ", " + mid + ", " + total);

            // 랜선의 개수가 K보다 작은 경우 mid 를 줄여야 함.
            if (total < N) {
                e = mid - 1;
            }
            // 랜선의 개수가 K를 넘어가는 경우 mid 를 키워야 함.
            // 랜선의 개수가 K와 일치해도 최대값을 찾아야 하기 때문에 mid값을 키운다.
            else {
                s = mid + 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}

// 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.
// 4322 = 11
// 3322 = 10

// K개의 랜선을 만들 수 있는 최대 랜선의 길이 (UpperBound)
// m  198 199 200 201 202 ...
// t   11  11  11  10