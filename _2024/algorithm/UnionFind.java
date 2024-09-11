package com.ssafy._2024.algorithm;

public class UnionFind {
    static int parent[];
    public static void main(String[] args) {

        int N = 5;
        parent = new int[N + 1];

        for (int i = 1; i < N; i++) {
            parent[i] = i;
        }
    }

    static void union (int x, int y) {
        int a = find(x);
        int b = find(y);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    // 부모를 찾자.
    static int find (int a) {
        // 자기 자신이 부모라면 가장 최상위 부모노드를 찾은것이다
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }
}
