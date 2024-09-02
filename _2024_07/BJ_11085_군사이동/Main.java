package com.ssafy._2024_07.BJ_11085_군사이동;

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
    static int p, w, c, v, parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); // 정점의 수
        w = Integer.parseInt(st.nextToken()); // 간선의 수

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken()); // 백준 수도
        v = Integer.parseInt(st.nextToken()); // 큐브 수도

        parent = new int[p + 1];
        for (int i = 0; i <= p; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cost - o1.cost;
            }
        });

        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost= Integer.parseInt(st.nextToken());

            pq.offer(new Node(from, to, cost));
        }

        int ans = 0;

        // 큰 놈부터 뽑았는데 한 번에 연결되면 완전 럭키비키잖아~
        // c, v가 같은 집합이 될 때 까지
        while (find(c) != find(v)) {
            Node node = pq.poll();

            // 가장 큰 값의 길 부터 연결하는데,
            // 사이클이 형성되지 않았다면
            if (union(node.from, node.to)){
                ans = node.cost;
            }
        }

        System.out.println(ans);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x > y) {
            parent[x] = y;
        } else if (x < y) {
            parent[y] = x;
        } else {
            // 사이클이 형성된 경우
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
