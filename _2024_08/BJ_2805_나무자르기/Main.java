package com.ssafy._2024_08.BJ_2805_나무자르기;

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
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 절단기의 최소 높이
        int s = 1;
        // 절단기의 최대 높이
        int e = arr[N - 1];
        int ans = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            long total = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    total += arr[i] - mid;
                }
            }

            // 나무의 총합이 M보다 작다면, 절단기의 높이를 낮춰야함.
            // 최종 M보다 큰 첫 번째 절단기의 높이를 찾게되므로
            // 정답은 e
            if (total < M) {
                e = mid - 1;
            }
            // 나무의 총합이 M보다 같거나 크다면, 절단기의 높이를 높여야함.
            // 그렇다면 상한선을 찾을 수 있다.
            // 정답은 s
            else {
                s = mid + 1;
                ans = mid;
            }
        }

        System.out.println(e);
//        System.out.println(ans);
    }
}

// 4 7
// 10 15 17 20

// 높이 H인 전달기를 사용한다. 이 때, 절단기에 설정할 수 있는 높이의
// 최댓값을 구하는 프로그램을 작성하시오. (Upper Bound)

// m  13  14  15  16  17  18  19  20
// t  12   7   7   5   3   2   1   0