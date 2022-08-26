package com.ssafy.day_220823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_7465_창용마을무리의개수_이원석 {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        // TC
        for (int t = 1; t < TC + 1; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 정점
            int M = Integer.parseInt(st.nextToken()); // 간선

            graph = new ArrayList[N]; // 그래프
            visited = new int[N]; // 방문 check
            cnt = 0;

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                graph[from].add(to);
                graph[to].add(from);
            }


            for (int i = 0; i < N; i++) {
                if (visited[i] != 0) { // 이전에 방문했던 집합이면 continue
                    continue;
                }
                dfs(i);
                cnt++;
            }

            System.out.printf("#%d %d\n", t, cnt);
        }
    }

    public static void dfs(int from) {
        visited[from] = 1;
        for (int to : graph[from]) {
            if (visited[to] == 1) { // 사이클 제한
                continue;
            }

            visited[to] = 1; // 다음무리 탐색 때, 이전무리를 배제하기 위해서 visited를 따로 초기화 하지 않는다.
            dfs(to);
        }
    }
}
