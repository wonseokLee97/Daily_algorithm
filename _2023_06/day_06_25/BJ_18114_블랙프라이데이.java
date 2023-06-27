package com.ssafy._2023_06.day_06_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18114_블랙프라이데이 {

    static int N, C, arr[], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] == C) {
                System.out.println(1);
                return;
            }
        }

        // 배열 정렬
        Arrays.sort(arr);


        int start = 0;
        int end = N - 1;
        int total = 0;

        while (start < end) {
            total = arr[start] + arr[end];

            // 총 합이 기준보다 크다면!?
            if (total > C) {
                end--;
            } else if (total == C) {
                System.out.println(1);
                return;
            } else if (total < C) {
                for (int i = 0; i < N; i++) {
                    // 2개를 골랐을 때, 마지막 한개 (총합에서 2개 고른값을 뺐을 때..)
                    //
                    if (C - total == arr[i]) {
                        if (arr[start] != arr[i] && arr[end] != arr[i]) {
                            System.out.println(1);
                            return;
                        }
                    }
                }
                start++;
            }
        }

        System.out.println(0);
    }
}

// 이분탐색보다는.. 투 포인터가 맞지않나 싶은 문제

// 한 개만 고르는 경우
// 1 2 3 4 5 를 기록하자.

// 두 개를 고르는 경우
// 1 - 2 3 4 5
// (1, 2), (1, 3), (1, 4), (1, 5)
// 2 - 3 4 5
// (2, 3), (2, 4), (2, 5)
// 3 - 4 5
// (3, 4), (3, 5)
// 4 - 5
// (4, 5)

// 세 개를 고르는 경우
//