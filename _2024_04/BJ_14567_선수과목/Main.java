package com.ssafy._2024_04.BJ_14567_선수과목;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int idx;
    int sem;

    public Node(int idx, int sem) {
        this.idx = idx;
        this.sem = sem;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // A를 들어야 B를 들을수 있다.
            // B로의 진입차수를 구하자.
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            degree[B]++;
        }


        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.sem - o2.sem;
            }
        });

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                pq.offer(new Node(i, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] visited = new int[N + 1];
        Arrays.fill(visited, 1);

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();

            List<Integer> next_nodes = graph.get(now_node.idx);

            for (int next_node : next_nodes) {
                degree[next_node]--;

                visited[next_node] = Math.max(visited[next_node], now_node.sem + 1);

                if (degree[next_node] == 0) {
                    pq.offer(new Node(next_node, now_node.sem + 1));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] + " ");
        }

        System.out.println(sb);
    }
}

// 2 -> 3
// 1 -> 2

// [0, 1, 2]
