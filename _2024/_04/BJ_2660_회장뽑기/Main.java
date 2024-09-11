package com.ssafy._2024._04.BJ_2660_회장뽑기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

// 다익스트라 (djikstra)

public class Main {
    static List<List<Node>> graph;
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        while (true) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (from == -1 && to == -1) {
                break;
            }

            graph.get(from).add(new Node(to, 1));
            graph.get(to).add(new Node(from, 1));
        }


        int[] ans = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijikstra(i);

            int max_val = Integer.MIN_VALUE;
            for (int j = 1; j <= N; j++) {
                max_val = Math.max(max_val, dist[j]);
            }

            ans[i] = max_val;
        }


        int min_val = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            min_val = Math.min(min_val, ans[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min_val + " ");

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (ans[i] == min_val) {
                cnt++;
            }
        }
        sb.append(cnt + "\n");

        for (int i = 1; i <= N; i++) {
            if (ans[i] == min_val) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

    static void dijikstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        dist[start] = 0;

        while (!q.isEmpty()) {
            int now_node = q.poll();
            List<Node> next_nodes = graph.get(now_node);

            for (Node next_node : next_nodes) {
                // 지금 노드까지의 거리
                if (dist[next_node.to] > dist[now_node] + next_node.cost) {
                    dist[next_node.to] = dist[now_node] + next_node.cost;
                    q.offer(next_node.to);
                }
            }
        }
    }
}
