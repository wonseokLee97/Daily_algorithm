package com.ssafy._2023._2023_05.day_05_25;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int idx;
    int dist;

    public Node(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }
}
public class BJ_18352_특정_거리의도시_찾기 {

    static List<List<Node>> graph;
    static int N, M, K, X, dist[];
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        answer = new ArrayList<>();

        // 둘째 줄 부터 M개의 줄에 걸쳐 자연수 A, B로 단방향 도로가 존재한다.
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Node(B, 1));
        }

        dijikstra(X);

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (Integer integer : answer) {
                System.out.println(integer);
            }
        }
    }

    public static void dijikstra(int start) {
        // dist 초기화
        dist = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        // deque
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(start, 0));

        while (deque.size() != 0) {
            Node now_node = deque.pollFirst();
            List<Node> nodes = graph.get(now_node.idx);

            for (Node next_node : nodes) {
                int total_dist = next_node.dist + now_node.dist;

                // 다음 정점까지의 거리와, 지금 정점까지의 거리의 합이
                if (total_dist < dist[next_node.idx]) {
                    dist[next_node.idx] = total_dist;
                    deque.add(new Node(next_node.idx, total_dist));
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == K) {
                answer.add(i);
            }
        }
    }
}
