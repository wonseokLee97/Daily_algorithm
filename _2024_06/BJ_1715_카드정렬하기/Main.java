package com.ssafy._2024_06.BJ_1715_카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        int cnt = 0;
        int total = 0;

        if (pq.size() == 1) {
            System.out.println(pq.poll());
            return;
        }

        while (!pq.isEmpty()) {
            int A = pq.poll();
            total += A;
            cnt++;

            // 카드 두 장을 뽑았다면
            if (cnt % 2 == 0) {
                ans += total;
                pq.offer(total);
                total = 0;
            }
        }

        System.out.println(ans);
    }
}
