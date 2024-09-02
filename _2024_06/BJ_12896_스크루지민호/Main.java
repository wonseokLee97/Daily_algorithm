package com.ssafy._2024_06.BJ_12896_스크루지민호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int N, node, max_val, visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        graph = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        max_val = Integer.MIN_VALUE;
        visited = new int[N + 1];
        visited[1] = 1;
        dfs(1, 0);

        max_val = Integer.MIN_VALUE;
        visited = new int[N + 1];
        visited[node] = 1;
        dfs(node, 0);

        System.out.println((1 + max_val) / 2);
    }

    static void dfs(int start, int depth) {
        if (max_val < depth) {
            max_val = depth;
            node = start;
        }
        List<Integer> next_nodes = graph.get(start);

        for (int next_node : next_nodes) {
            if (visited[next_node] != 0) {
                continue;
            }

            visited[next_node] = 1;
            dfs(next_node, depth + 1);
            visited[next_node] = 0;
        }
    }
}