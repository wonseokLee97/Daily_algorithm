package com.ssafy.toss;

import java.util.*;

public class po2 {

    static int rel[][], target, limit, answer, visited[];
    static List<List<Integer>> graph;

    public static void main(String[] args) {
        rel = new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        target = 2;
        limit = 3;
        answer = 0;

        graph = new ArrayList<>();

        visited = new int[101];

        for (int i = 0; i <= 101; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : rel) {
            int from = r[0];
            int to = r[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

//        for (List<Integer> list : graph) {
//            System.out.println(list.toString());
//        }

        bfs(target);

        System.out.println(answer);
    }

    public static void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();

        // 시작점과 depth
        q.add(new int[]{start, 0});

        visited[start] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now_node = poll[0];
            int depth = poll[1];

            List<Integer> list = graph.get(now_node);

            for (int next_node : list) {
                if (visited[next_node] == 0) {
                    if (depth < limit) {
                        if (depth == 0) {
                            answer += 5;
                        } else {
                            answer += 11;
                        }
//                        System.out.println(next_node + ", " + (depth + 1));
                        visited[next_node] = 1;
                        q.add(new int[]{next_node, depth + 1});
                    }
                }
            }
        }
    }
}
