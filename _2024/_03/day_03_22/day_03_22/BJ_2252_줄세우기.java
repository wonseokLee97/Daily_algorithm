package com.ssafy._2024._03.day_03_22.day_03_22;

import java.util.*;
import java.io.*;

public class BJ_2252_줄세우기 {
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 학생 수
        int N = Integer.parseInt(st.nextToken());
        // 비교 횟수
        int M = Integer.parseInt(st.nextToken());

        int[] degree = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            degree[B]++;
        }

        Queue<Integer> q = new LinkedList<>();



        for (int i = 1; i <= N; i++) {
            // 진입차수가 0인 노드를 q에 넣자.
            if (degree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 큐가 빌때까지 반복하자.
        while (!q.isEmpty()) {
            Integer now_node = q.poll();
            sb.append(now_node + " ");

            // 현재 노드와 이어진 다른 노드들
            List<Integer> next_nodes = graph.get(now_node);
            for (int next_node : next_nodes) {
                // 현재 노드와 다음 노드의 간선을 끊자. (차수 감소)
                degree[next_node]--;

                // 만약 감수한 차소가 0이라면 큐에 노드를 삽입한다.
                if (degree[next_node] == 0) {
                    q.offer(next_node);
                }
            }
        }

        System.out.println(sb);
    }
}

// A - B의 앞에 서야한다.
// 1 - 3
// 2 - 3

// 4 2
// 3 1