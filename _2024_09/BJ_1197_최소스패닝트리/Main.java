package com.ssafy._2024_09.BJ_1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
    static List<List<Node>> graph;
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.offer(new Node(A, B, C));
        }

        long ans = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            int from = poll.from;
            int to = poll.to;
            int cost = poll.cost;


            // 연결 되었다면
            if (union(from, to)) {
//                System.out.println(from + ", " + to + " 연결!");
                ans += cost;
            }
        }

        System.out.println(ans);
    }

    static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A < B) {
            parent[B] = A;
        } else if (B < A){
            parent[A] = B;
        } else {
            return false;
        }

        return true;
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
