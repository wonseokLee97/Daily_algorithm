package com.ssafy._2023._2023_07.day_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_18352_특정거리의도시찾기 {

    static int N, M, K, X, dist[];
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        graph = new ArrayList<>();

        // 정점의 개수만큼 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }

        dijikstra(X);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == K) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            for (int ans : answer) {
                System.out.println(ans);
            }
        }
    }

    public static void dijikstra(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        dist[start] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now_node = poll[0];

            List<Integer> list = graph.get(now_node);

            for (int i = 0; i < list.size(); i++) {
                int next_node = list.get(i);

                // 현재 정점까지의 최단거리 + 1 < 다음 정점까지의 최단거리
                if (dist[next_node] > dist[now_node] + 1) {
                    dist[next_node] = dist[now_node] + 1;
                    q.add(new int[] {next_node, dist[next_node]});
                }
            }
        }
    }
}
