package com.ssafy._2023_06.day_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 비교할 수
        for (int i = 0; i < N; i++) {
            int s_idx = 0;
            int e_idx = N - 1;

            while (true) {
                if (i == s_idx) {
                    s_idx++;
                } else if (i == e_idx) {
                    e_idx--;
                }

                if (s_idx >= e_idx) {
                    break;
                }

                if (arr[s_idx] + arr[e_idx] < arr[i]) {
                    // 시작점을 올린다. (값을 증가시킴)
                    s_idx++;
                }
                // 현재 지점의 합 보다 크다면
                else if (arr[s_idx] + arr[e_idx] > arr[i]) {
                    // 끝점을 감소시킨다. (값을 감소시킴)
                    e_idx--;
                } else {
                    ans++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}

// 두 지점중, 시작점이 끝점보다 같거나 크다면 끝점 ++;