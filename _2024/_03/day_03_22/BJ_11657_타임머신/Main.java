package com.ssafy._2024._03.day_03_22.BJ_11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int to;
    long cost;

    public Node(int to, long cost) {
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
                return (int) (o1.cost - o2.cost);
            }
        });

        pq.offer(new Node(1, 0));
        dist[1] = 0L;

        while (!pq.isEmpty()) {
            // 1번 정점까지의 거리가 음수면 무한루프
            Node now_node = pq.poll();
            int now = now_node.to;
            long cost = now_node.cost;

            List<Node> next_nodes = graph.get(now);
            for (Node next_node : next_nodes) {
                Long next_cost = Long.valueOf(cost + next_node.cost);
                // 이미 방문했는데, next_cost 가 음수고, 다음 경로보다 cost 가 적다면
                if (visited[next_node.to] == 1 && next_cost < 0 && dist[next_node.to] > next_cost) {
                    return -1;
                }

                if (dist[next_node.to] > next_cost) {
                    visited[next_node.to] = 1;
                    dist[next_node.to] = next_cost;
                    pq.offer(new Node(next_node.to, dist[next_node.to]));
                }
            }
        }

        return 0;
    }
}

