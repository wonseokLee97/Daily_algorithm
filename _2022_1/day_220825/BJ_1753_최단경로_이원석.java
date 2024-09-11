package com.ssafy._2022_1.day_220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int y, w;

    public Node(int y, int w) {
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return this.w - o.w;
    }
}

public class BJ_1753_최단경로_이원석 {
    static int start, V, E;
    static int[] distance, visited;
    static int[][] arr;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        visited = new int[V + 1];

        graph = new ArrayList[V + 1];
        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[x].add(new Node(y, w));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        dijikstra(start);

        for (int i = 1; i < V + 1; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static void dijikstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int dist = poll.w;
            int now_index = poll.y;
            for (Node node : graph[now_index]) {
                int cost = node.w + dist; // 다음거리

                if (distance[node.y] > cost) {
                    distance[node.y] = cost;
                    queue.add(new Node(node.y, cost));
                }
            }
        }
    }
}
