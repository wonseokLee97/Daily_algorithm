package com.ssafy._2023._2023_06.day_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_14595_동방프로젝트 {
    
    static int N, M, parent[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (find(x) == find(y)) {
                continue;
            }

            for (int j = x; j <= y; j++) {
                union(x, j);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.println(Arrays.toString(parent));

        for (int i = 1; i <= N; i++) {
            map.put(parent[i], 0);
        }

        Set<Integer> set = map.keySet();
        System.out.println(set.size());
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    public static int find(int node) {
        if (node == parent[node]) {
            return node;
        }

        return find(parent[node]);
    }
}

// 1 | 2 | 3 | 4 | 5
// 1   2   3   4 | 5