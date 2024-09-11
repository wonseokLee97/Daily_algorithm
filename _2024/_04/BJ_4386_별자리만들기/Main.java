package com.ssafy._2024._04.BJ_4386_별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    double x;
    double y;
    int idx;

    public Node(double x, double y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

class Node2 {
    int from;
    int to;
    double w;

    public Node2(int from, int to, double w) {
        this.from = from;
        this.to = to;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "from=" + from +
                ", to=" + to +
                ", w=" + w +
                '}';
    }
}

// 최소 스패닝 트리 (MST)

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        PriorityQueue<Node2> pq = new PriorityQueue<>(new Comparator<Node2>() {
            @Override
            public int compare(Node2 o1, Node2 o2) {
                return (int) (o1.w - o2.w);
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            list.add(new Node(x, y, i + 1));
        }


        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Node now_node = list.get(i);
                Node next_node = list.get(j);
                double w = Math.sqrt(Math.pow(now_node.x - next_node.x, 2) + Math.pow(now_node.y - next_node.y, 2));

                pq.offer(new Node2(now_node.idx, next_node.idx, w));
            }
        }


        parent = new int[pq.size() + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        double ans = 0;
        while (!pq.isEmpty()) {
            Node2 now_node = pq.poll();

//            System.out.println(now_node);

            // 사이클이 발생된 경우 제외
            if (!union(now_node.from, now_node.to)) {
                continue;
            }

            ans += now_node.w;
        }

        System.out.printf("%.2f", ans);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }

            return true;
        }

        // 사이클!
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}

// 각 별자리 좌표 저장.
//
