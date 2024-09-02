package com.ssafy._2024_07.BJ_1956_운동;

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
    static int dist[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점
        int E = Integer.parseInt(st.nextToken()); // 간선

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, cost));
        }

        dist = new int[V + 1][V + 1];


        for (int i = 0; i <= V; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 1; i <= V; i++) {
            // i에서 출발했을 때 최단경로를 구하자.
            dijikstra(i);
        }

        for (int j = 0; j < V + 1; j++) {
            for (int k = 0; k < V + 1; k++) {
                if (dist[j][k] == Integer.MAX_VALUE) {
                    dist[j][k] = 0;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                // i -> j, j -> i 로 어떻게든 갈 수 있어야함.
                if (dist[i][j] != 0 && dist[j][i] != 0) {
                    ans = Math.min(ans, dist[i][j] + dist[j][i]);
                }
            }
        }

        System.out.println(ans);
    }

    static void dijikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.to - o2.to;
            }
        });

        pq.offer(new Node(start, 0));
        dist[start][start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int nowNode = node.to;
            int cost = node.cost;

            if (dist[start][nowNode] < cost) continue;

            List<Node> nextNodes = graph.get(nowNode);
            for (Node nextNode : nextNodes) {
                if (dist[start][nextNode.to] > dist[start][nowNode] + nextNode.cost) {
                    dist[start][nextNode.to] = dist[start][nowNode] + nextNode.cost;
                    pq.offer(new Node(nextNode.to, nextNode.cost));
                }
            }
        }
    }
}

// 0  1  2  3
// 1  0  1  3
// 2  0  0  2
// 3  0  1  0

//4 5
//1 2 1
//2 3 1
//3 4 1
//4 2 1
//2 1 100
//2 3
//1 2 1
//2 1 100
//1 1 100