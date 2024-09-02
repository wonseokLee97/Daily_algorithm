package com.ssafy._2024_08.BJ_16206_롤케이크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 첫 번째 기준: num % 10 비교
                int mod1 = o1 % 10;
                int mod2 = o2 % 10;

                // 20, 30의 경우 20이 먼저 나와야함.
                if (mod1 == mod2) {
                    return o1 - o2;
                } else { // 20, 12의 경우 20이 먼저 나와야함.
                    return o1 % 10 - o2 % 10;
                }
            }
        });


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int l = Integer.parseInt(st.nextToken());
            if (l == 10) {
                cnt++;
                continue;
            } else if (l < 10) {
                continue;
            }

            pq.offer(l);
        }

        while (M > 0 && !pq.isEmpty()) {
            int roll = pq.poll();

            // 길이가 20일 때 한번의 커팅으로 2개를 획득
            if (roll - 10 == 10) {
                cnt++;
            }

            // 길이가 20보다 클 때는 한번의 커팅에 1개만 획득
            if (roll - 10 > 10) {
                pq.offer(roll - 10);
            }

            cnt++;
            M--;
        }

        System.out.println(cnt);
    }
}

//  3  4
// 31 40 50
// case1
// 31을 두 번 자르면 2개를 먹을 수 있다.
// 40을 두 번 자르면 2개를 먹을 수 있다.

// case2
// 50을 4번 자르면 5개를 먹을 수 있다.

// 12 23 34 45 56
//  1  2  3  4  5
// 10 20 30 40 50
//
//5 5
//50 13 23 40 11

// 5 7
// 10 20 30 40 50
//  0  1  2  3  1
// 10 20 30 40 10

// 1.정렬
// 50 40 30 20 10
//  4  3  0  0  0
// 50 40  0  0  1
//  1  1  1  1  0
// 10 10 10 20 10
//  1  1  1
// 10 10 20

// 2.자르기
// 50 -> 5
// 40 -> 4
// 30 -> 3
// 20 -> 2
// 10