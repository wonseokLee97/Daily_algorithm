package com.ssafy._2023_05.day_05_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1446_지름길 {

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int N, D, dist[];
//    static List<List<Node>> graph;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        graph = new ArrayList[151];
        dist = new int[151];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            dist[s] = s - 0;

            graph[0].add(new Node(s, s));
            graph[s].add(new Node(e, l));
        }

        dijikstra();
    }

    public static void dijikstra() {

        for (int i = 0; i < 10001; i++) {
            if (dist[i] != 0) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            List<Node> nodes = graph[now_node.idx];

            for (Node next_node : nodes) {
                int cost = next_node.dist + now_node.dist;

                if (cost < dist[next_node.idx]) {
                    dist[next_node.idx] = cost;
                    pq.add(new Node(next_node.idx, cost));
                }
            }
        }

        System.out.println(dist[150]);
    }
}
