package com.ssafy._2023_06.day_06_21;

import java.util.*;
import java.io.*;

public class BJ_1707_이분그래프 {
    static List<List<Integer>> graph;
    static int N, M, color[];
    static boolean ans;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            // 정점의 개수
            N = Integer.parseInt(st.nextToken());
            // 간선의 개수
            M = Integer.parseInt(st.nextToken());

            ans = true;
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            color = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                // 이분 그래프가 아니라면..
                if (!ans) {
                    break;
                }

                // 아직 탐색하지 않은 정점인 경우..
                if (color[i] == 0) {
                    bfs(i);
                }
            }

            // 이분 그래프라면
            if (ans) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        // 시작 정점은 1로 초기화.
        color[start] = 1;

        while (!q.isEmpty()) {
            int now_node = q.poll();
            List<Integer> list = graph.get(now_node);

            for (int next_node : list) {
                // 아직 인접한 다음 정점의 색깔이 초기화 되지 않았다면,
                if (color[next_node] == 0) {
                    q.offer(next_node);
                    color[next_node] = color[now_node] * -1;
                }
                // 지금 노드와 인접한 노드와의 색깔이 같다면? 이분 그래프 X
                else if (color[next_node] == color[now_node]) {
                    ans = false;
                    return;
                }
            }
        }
    }
}

// 3 2
// 1 3
// 2 3

// 1
// 4 4
// 1 2
// 2 3
// 3 4
// 4 2