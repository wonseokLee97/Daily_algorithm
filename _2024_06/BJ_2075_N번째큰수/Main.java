package com.ssafy._2024_06.BJ_2075_N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int next_val = Integer.parseInt(st.nextToken());
                pq.offer(next_val);

                // size 가 N 이상이라면 작은 수 부터 빼면서 N개를 유지하자.
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }

//        System.out.println(pq);
        System.out.println(pq.poll());
    }
}
