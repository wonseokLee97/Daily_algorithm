package com.ssafy._2023_06.day_06_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10986_나머지합 {

    static class Node implements Comparable<Node> {
        int v;

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                Integer poll = pq.poll();
                if (poll == null) {
                    System.out.println(0);
                } else {
                    System.out.println(poll);
                }
            } else {
                pq.add(x);
            }
        }
    }
}
