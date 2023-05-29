package com.ssafy._2023_05.day_05_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BJ_2211_네트워크복구 {

    static class Node implements Comparable<Node> {
        int idx;
        int dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    static List<List<Node>> graph;
    static int N, M, dist[], route[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }


        dijikstra(1);

        for (int i = 2; i < N + 1; i++) {
            int end_idx = i;

            // end_idx의 값이 0일 경우 route에 도달했다고 판단.
            // 1 -> 2 -> 4
            // route[4] = 2, route[2] = 1, route[1] = 0
            while (route[end_idx] != 0) {
//                System.out.println(i + ", " + end_idx + " -> " + route[end_idx]);
                if (map.get(end_idx) == null) {
                    map.put(end_idx, route[end_idx]);
                } else if (map.get(route[end_idx]) != null && map.get(route[end_idx]) == end_idx) {
                    end_idx = route[end_idx];
                    continue;
                }
                end_idx = route[end_idx];
            }
        }

        // 핵심:
        // 시작 정점을 제외한 각 노드로 부터 시작 정점까지 출발-도착 간선들을 모두 구하자!!
        // 단, 중복을 피해서
        System.out.println(map.keySet().size());
        for (Integer k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
    }

    // 슈퍼 컴퓨터(시작점)은 항상 1이다.
    // 최소 비용으로 모든 컴퓨터가 통신할 수 있도록 한다.

    public static void dijikstra(int start) {
        route = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            List<Node> nodes = graph.get(now_node.idx);

            for (Node next_node : nodes) {
                int cost = next_node.dist + now_node.dist;

                if (cost < dist[next_node.idx]) {
                    route[next_node.idx] = now_node.idx;
                    dist[next_node.idx] = cost;
                    pq.add(new Node(next_node.idx, cost));
                }
            }
        }

//        System.out.println(Arrays.toString(route));
//        System.out.println(start + ", " + Arrays.toString(dist));
    }
}

// 1 - 2 최소
// 2 - 1 최소
// 3 - 1 최소
// 4 - 2 최소
