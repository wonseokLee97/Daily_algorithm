package com.ssafy._2024_08.BJ_14284_간선이어가기2;

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

public class Main {
    static List<List<Node>> graph;
    static int dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(s);

        System.out.println(dist[t]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(start);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int nowNode = pq.poll();

            List<Node> nextNodes = graph.get(nowNode);
            for (Node nextNode : nextNodes) {
                // 최단경로를 찾아야하므로, nowNode에서 nextNode까지의 거리가
                // nextNode 까지의 최단 경로보다 짧은 경우에만 지나간다.
                if (dist[nextNode.to] > dist[nowNode] + nextNode.cost) {
                    dist[nextNode.to] = dist[nowNode] + nextNode.cost;
                    pq.offer(nextNode.to);
                }
            }
        }
    }
}


// 8 9 - n, m
// 1 2 3 - a, b, c
// 1 3 2
// 1 4 4
// 2 5 2
// 3 6 1
// 4 7 3
// 5 8 6
// 6 8 2
// 7 8 7
// 1 8