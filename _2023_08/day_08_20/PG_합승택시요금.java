package com.ssafy._2023_08.day_08_20;

import java.util.*;

public class PG_합승택시요금 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        s.solution(6, 4, 6, 2, new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}});
    }
}

class Node implements Comparable<Node> {
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


class Solution2 {
    static List<List<Node>> graph;
    static int dist[], visited[];

    public int solution(int n, int s, int a, int b, int[][] fares) {
        // s -> a, b
        dist = new int[n + 1];
        visited = new int[n + 1];
        graph = new ArrayList<>();


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] f : fares) {
            int from = f[0];
            int to = f[1];
            int dist = f[2];

            graph.get(from).add(new Node(to, dist));
            graph.get(to).add(new Node(from, dist));
        }

        int min_val = Integer.MAX_VALUE;

        int[] distS = dijikstra(s);
        int[] distA = dijikstra(a);
        int[] distB = dijikstra(b);

        for (int i = 1; i < n + 1; i++) {
            min_val = Math.min(min_val, distS[i] + distA[i] + distB[i]);
        }

        return min_val;
    }

    static int[] dijikstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node now_node = q.poll();
            int now_idx = now_node.idx;
            int now_dist = now_node.dist;

            List<Node> list = graph.get(now_idx);

            for (Node next_node : list) {
                // 다음 정점까지 이동하는데 소모되는 비용
                if (dist[next_node.idx] > next_node.dist + now_dist) {
                    dist[next_node.idx] = next_node.dist + now_dist;
                    q.add(new Node(next_node.idx, next_node.dist + now_dist));
                }
            }
        }

        return dist.clone();
    }
}

// 4 -> 2, 6 .. 101
// 4 -> 1 -> 2, 6 ..

// 4 -> 2
// 4 -> 6

// 4에서 가는 경우 => 101
// 4->1 에서 가는 경우 => 10 + 63 + 25, 98
// 4->1->5 에서 가는 경우 => 10 + 24 + 46 + 2, 82
// 4->1->5->6 에서 가는 경우 => 10 + 24 + 2 + 48 + 0, 84
// 4->1->5->6->3 에서 가는 경우
// 4->1->5->6->3->2->0