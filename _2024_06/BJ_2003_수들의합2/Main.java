package com.ssafy._2024_06.BJ_2003_수들의합2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int s = 0;
        int e = 0;
        int total = 0;
        int cnt = 0;

        // s, e, total 은 0부터 시작
        // (s가 N보다 같거나 커지는 경우 종료)
        // 0. 처음에는 값이 무조건 0이니..
        // 1. total 의 값이 M보다 작거나 같다면 arr[e]를 더해주고 e를 증가.
        // 1-1. e의 값이 마지막에 위치해있다면 앞으로는 s만 증가.
        // 2. total 의 값이 M보다 크다면 arr[s]를 빼주고 s를 증가.
        // ==============
        // 3. total 의 값이 M과 같다면 cnt 증가.
        // s가 N과 같아지면 종료, e가 N과 같아지면 s만 증가.
        // s와 e는 반드시 배열의 범위 바깥까으로 나가야 탐색이 종료된다.
        // 따라서 우선순위는, 먼저 total 에 대한 연산을 진행 후 포인터들을 움직여야 한다.

        while (s < N) {
            // 총합이 M보다 크다 or e가 마지막을 가르킨다
            // s 증가
            if (total > M || e == N) {
                total -= arr[s++];
            } else {
                total += arr[e++];
            }

            if (total == M) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

// N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
// 이 수열의 i번째 수부터 j번째 수까지의 합
// A[i] + A[i+1] + … + A[j-1] + A[j]
// 가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.

// 3 1
//
// 3 2 1
//     e
// total = 5