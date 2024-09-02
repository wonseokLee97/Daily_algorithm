package com.ssafy._2024_07.BJ_16169_퍼레이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int V, E, visited[][], flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        flag = 0;
        visited = new int[V + 1][V + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }


        for (int i = 1; i <= V; i++) {
            dfs(i, i, 0);
        }

        if (flag == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    static void dfs(int nowNode, int idx, int cnt) {
        if (cnt == E) {
            flag = 1;
            return;
        }

        List<Integer> nextNodes = graph.get(nowNode);

        for (int nextNode : nextNodes) {
            // 만약 다음 경로가 이미 지나간 경로라면
            if (visited[nowNode][nextNode] == idx || visited[nextNode][nowNode] == idx) {
                continue;
            }

            visited[nowNode][nextNode] = idx;
            visited[nextNode][nowNode] = idx;
            dfs(nextNode, idx,cnt + 1);
        }
    }
}
