package com.ssafy._2024_08.위상정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 단방향 그래프
            graph.get(a).add(b);
            arr[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (q.isEmpty()) {
                System.out.println("사이클 발생!");
                return;
            }

            // 진입차수가 0인 정점 nowNode
            int nowNode = q.poll();
            ans.append(nowNode + "-");

            // 정점을 끊을 다음 노드들
            List<Integer> nextNodes = graph.get(nowNode);
            for (int nextNode : nextNodes) {
                if (--arr[nextNode] == 0) {
                    q.offer(nextNode);
                }
            }
        }

        System.out.println(ans);
    }
}


// N
//7 7
//1 2
//1 5
//2 3
//3 4
//4 6
//5 6
//6 7