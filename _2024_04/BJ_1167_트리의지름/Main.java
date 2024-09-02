package com.ssafy._2024_04.BJ_1167_트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ClientInfoStatus;
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
    static int max_val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        max_val = Integer.MIN_VALUE;
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now_node = Integer.parseInt(st.nextToken());

            while (true) {
                int next_node = Integer.parseInt(st.nextToken());
                if (next_node == -1) {
                    break;
                }

                int cost = Integer.parseInt(st.nextToken());
                graph.get(now_node).add(new Node(next_node, cost));
                graph.get(next_node).add(new Node(now_node, cost));
            }
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijikstra(1, dist);

        int max_idx = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > max_val) {
                max_val = dist[i];
                max_idx = i;
            }
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijikstra(max_idx, dist);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > ans) {
                ans = dist[i];
            }
        }

        System.out.println(ans);
    }

    static void dijikstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        Node node = new Node(start, 0);
        pq.add(node);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            List<Node> nodes = graph.get(now_node.to);

//            System.out.println(now_node.to);

            for (Node next_node : nodes) {
                // 현재 정점에서 다음 정점까지의 비용이, 이미 기록된 비용보다 적을겨우
                if (next_node.cost + dist[now_node.to] < dist[next_node.to]) {
                    dist[next_node.to] = next_node.cost + dist[now_node.to];
                    pq.offer(next_node);
                }
            }
        }
    }
}
