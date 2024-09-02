package com.ssafy._2023._2023_05.day_05_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2307_도로검문 {

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
    static int N, M, dist[], route[], max_delay, min_val;

    // 경찰이 검문하는 정점을 제외한 목적지까지의 최단 경로를 구하여라!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        route = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        dijikstra(0, 0);
        min_val = dist[N];
        max_delay = Integer.MIN_VALUE;

        // 6 - 3 - 2 - 1 - 0
        for (int i = N; i != route[i]; i = route[i]) {
//            System.out.println(i);
            dijikstra(i, route[i]);
            max_delay = Math.max(max_delay, Math.abs(min_val - dist[N]));
        }


        if (max_delay >= Integer.MAX_VALUE / 2) {
            System.out.println(-1);
        } else {
            System.out.println(max_delay);
        }
    }

    // 최단 경로를 구하자! 그 후..

    // 도로를 막는 경우
    // 1-2, 1-4
    // 2-3
    // 3-4, 3-6
    // 4-5
    // 5-6
    // 모든 정점에서 중복없이 연결된 정점 2개를 뽑자.
    // 경찰이 있는 지점을 지나가지 않도록 한다. (p_start, p_end) 가 일치하지 않도록

    public static void dijikstra(int p_start, int p_end) {

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(1, 0));

        while (queue.size() != 0) {
            Node now_node = queue.poll();
            // 현재 정점과 연결된 다른 정점들
            List<Node> nodes = graph.get(now_node.idx);

            for (int i = 0; i < nodes.size(); i++) {
                int now_dist = now_node.dist;
                Node next_node = nodes.get(i);

                if (now_dist + next_node.dist < dist[next_node.idx]) {
                    if (p_start == 0 && p_end == 0) {
                        // 다음 정점까지 이동하는 경우, 최소의 거리일 때 route 에 이전 정점의 정보를 저장한다.
                        // 이전 정점이 만약 0인 경우(해당 정점을 지나지 않고 최단거리로 방문함)
                        route[next_node.idx] = now_node.idx;
                    }

                    // System.out.println(now_node.idx + ", " + next_node.idx);
                    // System.out.println(p_start + ", " + p_end);

                    if (((now_node.idx == p_start && next_node.idx == p_end) ||
                            (now_node.idx == p_end && next_node.idx == p_start)) &&
                            p_start != 0 && p_end != 0) {
                        continue;
                    }

                    dist[next_node.idx] = now_dist + next_node.dist;
                    queue.add(new Node(next_node.idx, now_dist + next_node.dist));
                }
            }
        }

        // System.out.println(Arrays.toString(route));
        // System.out.println(Arrays.toString(dist));
    }
}

//8 12
//1 2 1
//1 5 8
//1 7 9
//2 5 2
//3 4 4
//3 6 3
//3 8 5
//4 6 10
//4 8 11
//5 6 6
//5 7 7
//7 6 2