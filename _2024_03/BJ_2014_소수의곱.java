package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_2014_소수의곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
            pq.offer((long) s);
        }


        long ans = 0;
        int cnt = 0;
        while (true) {
            long poll = pq.poll();
            cnt++;

            // N번째 수를 구했을 때
            if (cnt == N) {
                ans = poll;
                break;
            }

            for (int i = 0; i < K; i++) {
                long mul = poll * arr[i];
                if (mul >= Math.pow(2, 31)) {
                    break;
                }

                pq.offer(mul);

                if (poll % arr[i] == 0) {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}

// 2, 5, 7

// 2, 4, 5, 7, 10, 14
//