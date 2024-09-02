package com.ssafy._2023._2023_06.day_06_21;

import java.util.*;
import java.io.*;


public class BJ_1504_특정한최단경로
{
    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int N, E, dist[], max_val;
    static List<List<Node>> graph;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 정점의 개수
        N = Integer.parseInt(st.nextToken());
        // 간선의 개수
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        max_val = 1000000000; // 10억

        // 1 -> u -> v -> N
        int a = dijikstra(1, u) + dijikstra(u, v) + dijikstra(v, N);
        // 1 -> v -> u -> N
        int b = dijikstra(1, v) + dijikstra(v, u) + dijikstra(u, N);


        // u, v를 경유하는 방법이 하나도 없는 경우
        if (a >= max_val && b >= max_val) {
            System.out.println(-1);
        }
        // 아닐경우, 둘 중에서 최단 경로를 구한다.
        else {
            System.out.println(Math.min(a, b));
        }
    }

    public static int dijikstra(int start, int end) {
        dist = new int[N + 1];
        Arrays.fill(dist, max_val);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            // 현재 정점
            Node now_node = pq.poll();

            // 현재 정점과 이어진 다른 정점들 list
            List<Node> list = graph.get(now_node.to);

            for (Node next_node : list) {
                int idx = next_node.to;
                int cost = next_node.cost;

                // 다음 정점까지의 거리가, 현재 정점까지의 거리 + cost 보다 크다면
                if (dist[idx] > now_node.cost + cost) {
                    dist[idx] = now_node.cost + cost;
                    pq.offer(new Node(idx, now_node.cost + cost));
                }
            }
        }

        return dist[end];
    }
}
