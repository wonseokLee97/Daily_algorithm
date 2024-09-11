package com.ssafy._2022_1.day_220822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class D4_1238_Contact {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int max_val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t < 11; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            max_val = Integer.MIN_VALUE;
            graph = new ArrayList[N + 1];
            visited = new int[N + 1];

            for (int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
            }

            bfs(start);

            System.out.printf("#%d %d\n", t, max_val);
        }
    }

    public static void bfs(int start){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start});
        visited[start] = 1;

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int[] poll = queue.poll();

            for (int p : poll) {
                for (int g : graph[p]) {
                    if (visited[g] == 1) {
                        continue;
                    }
                    visited[g] = 1;
                    tmp.add(g);
                }
            }

            if (tmp.size() == 0) {
                for (int p : poll) {
                    max_val = Math.max(max_val, p);
                }
                return;
            }

            int[] next = new int[tmp.size()];
            for (int i = 0; i < tmp.size(); i++) {
                next[i] = tmp.get(i);
            }
            queue.add(next);
        }
    }
}
