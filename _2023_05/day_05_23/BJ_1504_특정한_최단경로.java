package com.ssafy._2023_05.day_05_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node implements Comparable<Node> {
    int idx;
    int dist;

    public Node(int b, int c) {
        idx = b;
        dist = c;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(dist, o.dist);
    }
}

public class BJ_1504_특정한_최단경로 {

    static List<List<Node>> graph;
    static int dist[], u, v, N, E, MAX_VAL;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 정점 N, 간선 E
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        // List 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        // 간선 E의 개수만큼 a, b, c (a번 정점에서 b번 정점까지의 거리 c)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 그래프에 노드의 이동정보 담기
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        MAX_VAL = Integer.MAX_VALUE;


        st = new StringTokenizer(br.readLine());
        u = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        // 1에서 u 까지, v 에서 N까지
        // 1에서 v 까지, u 에서 N까지
        int way1 = dijikstra(1, u) + dijikstra(u, v) + dijikstra(v, N);
        int way2 = dijikstra(1, v) + dijikstra(v, u) + dijikstra(u, N);

        if ((way1 >= MAX_VAL) && (way2 >= MAX_VAL)) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(way1, way2));
        }
    }


    public static int dijikstra(int start, int end) {
        // 거리 배열 dist 초기화
        dist = new int[N + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = MAX_VAL;
        }

        dist[start] = 0;

        // Node.idx = 노드, Node.dist = 해당 노드까지의 거리
        Deque<Node> deque = new LinkedList<>();

        // 시작노드(start) 에서 연결된 모든 노드들을 탐색한다.
        // 해당 노드까지의 dist 가 최단 dist 보다 작다면 갱신한다.
        deque.add(new Node(start, 0));

        while (deque.size() != 0) {
            Node now_node = deque.pollFirst();
            List<Node> nodes = graph.get(now_node.idx);

            // 현재 정점과 이어진 모든 정점들 까지의 거리를 구하여
            // 최소 도달거리를 갱신한다.
            for (int i = 0; i < nodes.size(); i++) {
                Node next_node = nodes.get(i);

                if (now_node.dist + next_node.dist < dist[next_node.idx]) {
                    // 최종 목적지에 도달하는데 flag 가 1인 경우.
                    dist[next_node.idx] = now_node.dist + next_node.dist;
                    deque.add(new Node(next_node.idx, now_node.dist + next_node.dist));
                }
            }
        }

        return dist[end];
    }
}
