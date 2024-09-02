package com.ssafy._2024_04.BJ_1922_네트워크연결;

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
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        int cnt = 0;
        int cost = 0;

        // unionfind를 쓰는 이유는 이미 연결된 정점은 계산에서 제외하기 위해서
        for (Node node : list) {
            if (union(node.from, node.to)) {
                cnt++;
                cost += node.cost;

                if (cnt == N - 1) {
                    break;
                }
            }
        }

        System.out.println(cost);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        // 이미 집합이라면
        if (x == y) {
            return false;
        }

        // 작은 정점이 부모로
        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return true;
    }

    // 부모찾기
    static int find(int n) {
        if (parent[n] == n) {
            return n;
        }

        return parent[n] = find(parent[n]);
    }
}
