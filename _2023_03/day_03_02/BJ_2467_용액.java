package com.ssafy._2023_03.day_03_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = N - 1, cnt = 0, sum = 0;
        int min_val = Math.abs(arr[s] + arr[e]);
        int[] ans = new int[2];

        while (s < e) {
            sum = arr[s] + arr[e];

            if (min_val >= Math.abs(sum)) {
                min_val = Math.abs(sum);
                ans[0] = arr[s];
                ans[1] = arr[e];

                if (sum == 0) {
                    break;
                }
            }


            // 양수인 경우
            if (sum > 0) {
                e--;
            } else { // 음수인 경우
                s++;
            }
        }

        System.out.println(ans[0] + " " + ans[1]);
    }
}
