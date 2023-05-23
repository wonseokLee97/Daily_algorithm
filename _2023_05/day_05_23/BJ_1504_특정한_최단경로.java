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
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 정점 N, 간선 E
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // List 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 거리 배열 dist 초기화
        dist = new int[N + 1];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
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
    }


    public void dijikstra(int start) {
        // Node.idx = 노드, Node.dist = 해당 노드까지의 거리
        Deque<Node> deque = new LinkedList<>();

        deque.add()
    }
}
