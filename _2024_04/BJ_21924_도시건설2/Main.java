package com.ssafy._2024_04.BJ_21924_도시건설2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int from;
    int to;
    int cost;

    public Node(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static List<Node> graph;
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        long total = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(a, b, c));
            total += c;
        }

        long ans = KruskalMST(N);
        if (ans == -1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }

    static long KruskalMST(int N) {
        long total = 0;
        int cnt = 0;
        int flag = 0;

        // 비용 오름차순 정렬
        Collections.sort(graph, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        for (Node node : graph) {
            // 두 정점은 같은 집합인가?
            if (union(node.from, node.to)) {
                total += node.cost;
                cnt++;

                // 간선은 항상 정점 - 1개여야 모든 노드를 순회한 것.
                if (cnt == N - 1) {
                    flag = 1;
                    break;
                }
            }
        }

        if (flag == 1) {
            return total;
        } else {
            return -1L;
        }
    }

    static boolean union(int a, int b) {
        // 두 정점의 부모가 같으면 (이미 연결되어 있다면)
        int x = find(a);
        int y = find(b);

        if (x == y) {
            return false;
        }

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return true;
    }

    static int find(int n) {
        // 현재 정점이 부모라면
        if (parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }
}

//3 3
//1 2 1
//2 3 1
//3 1 1