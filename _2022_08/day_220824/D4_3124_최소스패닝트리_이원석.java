package com.ssafy.day_220824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Node2 implements Comparable<Node2> {
    int from, to, weight;

    public Node2(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node2 o) {
        return this.weight - o.weight;
    }
}

public class D4_3124_최소스패닝트리_이원석 {
    static int V, E;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            long result = 0;
            List<Node2> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            make();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                list.add(new Node2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            Collections.sort(list);

            for (Node2 n : list) {
                if (union(n.from, n.to)) {
                    result += n.weight;
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    public static void make() {
        parents = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}
