package com.ssafy._2024_04.BJ_11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static List<List<Node>> graph;
    static Long dist[];
    static int visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        dist = new Long[N + 1];
        visited = new int[N + 1];

        Arrays.fill(dist, Long.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
        }

        if (dijikstra() == -1) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == Long.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }

    static int dijikstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.offer(new Node(1, 0));
        dist[1] = 0L;

        while (!pq.isEmpty()) {
            // 1번 정점까지의 거리가 음수면 무한루프
            Node now_node = pq.poll();
            int now = now_node.to;

            List<Node> next_nodes = graph.get(now);
            for (Node next_node : next_nodes) {
                Long next_cost = dist[now] + next_node.cost;
                if (visited[next_node.to] == 1 && next_cost < 0) {
                    return -1;
                }

                if (dist[next_node.to] > next_cost) {
                    visited[next_node.to] = 1;
                    dist[next_node.to] = next_cost;
                    pq.offer(next_node);
                }
            }
        }

        return 0;
    }
}
