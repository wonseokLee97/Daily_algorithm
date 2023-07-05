package com.ssafy._2023_07.day_07_05;

import java.util.*;
import java.io.*;


public class BJ_15591_MooTube {
    static int N, Q;
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node (int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // N은 정점, Q는 간선
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph.get(to).add(new Node(from, dist));
            graph.get(from).add(new Node(to, dist));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            System.out.println(bfs(K, start));
        }
    }

    public static int bfs(int K, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, Integer.MAX_VALUE));

        int cnt = 0;
        int[] dist = new int[N + 1];
        int[] visited = new int[N + 1];
        visited[start] = 1;

        while (!q.isEmpty()) {
            // 현재 정점
            Node now_node = q.poll();
            // 현재 정점과 연결된 다른 정점들
            List<Node> list = graph.get(now_node.idx);

            for (Node next_node : list) {
                if (visited[next_node.idx] == 0 && next_node.dist >= K) {
                    dist[next_node.idx] = Math.min(next_node.dist, now_node.dist);
                    visited[next_node.idx] = 1;
                    q.add(next_node);
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            // 거리가 K 이상인 비용들만 카운트
            if (dist[i] >= K) {
                cnt++;
            }
        }

        return cnt;
    }
}

// for (int i = 0; i <= N; i++) {
//     List<Node> list = graph.get(i);

//     for (Node node : list) {
//         System.out.println(i + ", " + node.to + ", " + node.dist);
//     }
// }

// 5 1
// 1 2 3
// 2 3 2
// 2 4 4
// 4 5 1
// 1 1
