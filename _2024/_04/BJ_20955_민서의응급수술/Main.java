package com.ssafy._2024._04.BJ_20955_민서의응급수술;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 분리집합(set), UnionFind(사이클)

public class Main {
    static int parent[], cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 부모 초기화
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (!union(u, v)) cnt++;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            System.out.print(find(i) + " ");
            set.add(find(i));
        }

        System.out.println();

        for (int i = 1; i <= N; i++) {
            System.out.print(parent[i] + " ");
        }

        System.out.println(Arrays.toString(parent));

        cnt += set.size() - 1;

//        System.out.println(Arrays.toString(parent));
//        System.out.println(cnt.size() - 1);
//        System.out.println(cut);

        System.out.println(cnt);
    }

    static boolean union(int a, int b) {
        int x = find(a);
        int y = find(b);

        // 서로 부모가 다르다면
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
            return true;
        }

        return false;
    }

    static int find(int x) {
        // 부모를 찾았다면
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}


// 모든 간선을 연결시켜라.
// 단방향 그래프, 사이클이 존재하면 안됨
// UnionFind 를 통해 각각의 그래프 개수를 구한다.
// 2개면 1개를 연결, 3개면 2개..

//3 3
//1 2
//2 3
//3 1

//4 3
//1 2
//1 3
//2 4
//3 4

//4 4
//1 2
//1 3
//2 4
//3 4