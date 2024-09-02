package com.ssafy._2024_06.BJ_6118_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 분류: 다익스트라(BFS)
 */

public class Main {
    static List<List<Integer>> graph;
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dijikstra(1);

        int max_len = Integer.MIN_VALUE;
        int idx = -1;
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (max_len < dist[i]) {
                max_len = dist[i];
                idx = i;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] == max_len) {
                cnt++;
            }
        }

        System.out.println(idx + " " + max_len + " " + cnt);
    }

    static void dijikstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(start);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int now_node = pq.poll();

            List<Integer> next_nodes = graph.get(now_node);
            for (int next_node : next_nodes) {
                if (dist[next_node] > dist[now_node] + 1) {
                    dist[next_node] = dist[now_node] + 1;
                    pq.offer(next_node);
                }
            }
        }
    }
}
