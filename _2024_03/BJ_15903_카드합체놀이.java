package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_15903_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Long a = Long.parseLong(st.nextToken());
            pq.offer(a);
        }

        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();

            pq.offer(x + y);
            pq.offer(x + y);
        }

        long total = 0;
        while (!pq.isEmpty()) {
            total += pq.poll();
        }

        System.out.println(total);
    }
}

// 15,000,000

// 3 2 6
// 2 3 6
// [2 3] = 5
// 5 5 6


// 1 2 3 4
// [1 2] = 3
// 3 3 3 4
// [3 3] = 6
// 6 6 3 4