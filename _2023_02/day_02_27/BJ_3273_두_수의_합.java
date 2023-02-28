package com.ssafy._2023_02.day_02_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273_두_수의_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int s = 0, e = n - 1, cnt = 0, cnt2 = 0, sum = 0;

        // 1, 2, 3, 5, 7, 9, 10, 11, 12
        // 첫 번째와 마지막을 더했을 때..
        // 1) x보다 크다면 e를 줄인다.
        // 2) x보다 작다면 s를 늘린다.
        // 찾았을 경우 s를 늘린다. 무한반복

        while (true) {
            if (s == e) {
                break;
            }

            sum = arr[s] + arr[e];

            if (sum > x) {
                e--;
            } else if (sum < x) {
                s++;
            } else {
                cnt++;
                s++;
            }
        }

        System.out.println(cnt);
    }
}
