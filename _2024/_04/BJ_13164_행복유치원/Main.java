package com.ssafy._2024._04.BJ_13164_행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 정렬 및 구현

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int get = Integer.parseInt(st.nextToken());
            arr[i] = get;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            pq.offer(arr[i + 1] - arr[i]);
        }


        int total = 0;
        for (int i = 0; i < N - K; i++) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}

// 1, 3, 5, 6, 10

// [1 3], [5 6], 10

// 2, 3, 5, 5, 9
// x           y
//       x  y

// 1 - 4
// 3 - 4
//