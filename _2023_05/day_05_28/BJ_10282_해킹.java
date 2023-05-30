package com.ssafy._2023_05.day_05_28;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10282_해킹 {

    static class Node implements Comparable<Node> {
        int idx;
        int dist;
        boolean canGo;

        public Node(int idx, int dist, boolean canGo) {
            this.idx = idx;
            this.dist = dist;
            this.canGo = canGo;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static List<List<Node>> graph;
    static int dists[], n,  d, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            // 정점, 간선, 시작노드
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(st.nextToken());
                int from = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                graph.get(to).add(new Node(from, dist, false));
                graph.get(from).add(new Node(to, dist, true));
            }

            dijikstra(c);
        }
    }

    public static void dijikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dists = new int[n + 1];
        Arrays.fill(dists, Integer.MAX_VALUE);
        dists[start] = 0;

        pq.add(new Node(start, 0, true));

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            List<Node> nodes = graph.get(now_node.idx);

            for (Node next_node : nodes) {
                int cost = now_node.dist + next_node.dist;

                if (cost < dists[next_node.idx] && next_node.canGo == true) {
                    dists[next_node.idx] = cost;
                    pq.add(new Node(next_node.idx, cost, true));
                }
            }
        }

        int cnt = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < dists.length; i++) {
            if (dists[i] != Integer.MAX_VALUE) {
                cnt++;
                ans = Math.max(ans, dists[i]);
            }
        }

        System.out.println(cnt + " " + ans);
    }
}

// 현재 ㅈ