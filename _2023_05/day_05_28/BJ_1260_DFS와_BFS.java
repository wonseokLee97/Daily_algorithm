package com.ssafy._2023_05.day_05_28;

import java.io.*;
import java.util.*;

public class BJ_1260_DFS와_BFS {

    static List<List<Integer>> graph;
    static int N, M, V, visited[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            graph.get(to).add(from);
            graph.get(from).add(to);
        }

        // 방문기록 초기화 (이전에 방문했던 노드는 다시 방문하지 않도록 함)
        visited = new int[N + 1];
        dfs(V);
        System.out.println();
        visited = new int[N + 1];
        bfs();
    }

    // DFS(Depth First Search) - 깊이 우선 탐색
    // 그래프의 시작 정점으로 부터 연결된 노드를 타고 방문한다.
    // 리프 노드에 도착하는 경우, 다음 노드를 탐색한다.
    public static void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = 1;

        // 더 이상 방문할 노드가 없다면 return
        if (graph.get(start) == null) {
            return;
        }

        // 현재 정점과 연결된 정점들을 찾아 정렬한다.
        List<Integer> nodes = graph.get(start);
        Collections.sort(nodes);

        // 노드들 중
        for (Integer next_node : nodes) {
            if (visited[next_node] == 1) {
                continue;
            }

            // 방문하지 않은 노드들만 재귀탐색한다.
            dfs(next_node);
        }
    }

    // BFS(Breadth First Search) - 너비 우선 탐색
    // 그래프의 시작 정점으로 부터 연결된 노드들을 우선적으로 모두 방문한다.
    public static void bfs() {
        // 큐에 시작 노드를 담는다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = 1;
        System.out.print(V + " ");

        // 큐가 모두 빌 때 까지,
        while (!queue.isEmpty()) {
            Integer node = queue.poll();

            // 해당 노드에 연결된 모든 노드들을
            List<Integer> nodes = graph.get(node);
            // 오름차순 정렬한다.
            Collections.sort(nodes);

            // 노드들의 방문자격을 확인한다.
            for (Integer next_node : nodes) {
                // 이미 방문했다면 PASS
                if (visited[next_node] == 1) {
                    continue;
                }

                System.out.print(next_node + " ");
                visited[next_node] = 1;

                // 다음 노드를 방문하지 않았다면 큐에 추가.
                queue.add(next_node);
            }
        }
    }
}
