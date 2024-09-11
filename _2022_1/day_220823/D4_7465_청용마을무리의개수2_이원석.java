package com.ssafy._2022_1.day_220823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D4_7465_청용마을무리의개수2_이원석 {

    static class Node implements Comparable<Node> {
        int from, to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node o) {
            return this.from == o.from ? this.to - o.to : this.from - o.from;
        }
    }

    static int[] parents;
    static int N, M;
    static Node[] node_list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        // TC
        for (int t = 1; t < TC + 1; t++) {
            Set<Integer> set = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점
            M = Integer.parseInt(st.nextToken()); // 간선

            make();
            node_list = new Node[M];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                node_list[i] = new Node(from, to);
            }

            Arrays.sort(node_list);

            for (Node node : node_list) {
                union(node.from, node.to);
            }

            for (int i = 1; i < parents.length; i++) {
                set.add(parents[i]);
            }

            System.out.printf("#%d %d\n", t, set.size());
        }
    }

    public static void make() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }


    // 부모찾기
    public static int find(int a) {
        if (parents[a] == a) return a; // 내가 나의 부모면 return

        // 나의 부모에게 대표를 찾아오라고 함. 부모의 부모의 부모.. 대표!
        // 그리고 그 대표를 나의 부모로 바꾼다.
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        // 같은 대표를 가지면, 이미 집합이다.
        if (aRoot == bRoot) return false;

        // b의 대표를 a의 대표로 바꾼다! 따라서 같은 집합이 된다.
        parents[bRoot] = aRoot;
        return true;
    }
}



