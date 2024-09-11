package com.ssafy._2024._03.day_03_22.day_03_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3665_최종순위 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            // 등수와 팀의 번호
            int n = Integer.parseInt(br.readLine());

            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            int[] rank = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            int[] degree = new int[n + 1];

            for (int i = 1; i < n ; i++) {
                for (int j = i + 1; j <= n; j++) {
                    graph.get(rank[i]).add(rank[j]);
                    degree[rank[j]]++;
                }
            }
//            System.out.println(Arrays.toString(degree));

            // 등수가 바뀐 쌍의 수 m
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                Integer A = Integer.parseInt(st.nextToken());
                Integer B = Integer.parseInt(st.nextToken());

//                System.out.println(A + ", " + B);
                // 작년에 A보다 B가 순위가 낮다면
                if (graph.get(A).contains(B)) {
                    List<Integer> list = graph.get(A);
                    list.remove(B);
                    graph.get(B).add(A);
                    degree[A]++;
                    degree[B]--;
                } else { // 작년에 B보다 A가 순위가 낮다면
                    List<Integer> list = graph.get(B);
                    list.remove(A);
                    graph.get(A).add(B);
                    degree[B]++;
                    degree[A]--;
                }
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (degree[i] == 0) {
                    q.offer(i);
                }
            }

            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            while (!q.isEmpty()) {
                // 1등이 2명 이상? 순서를 정할 수 없다.
                if (q.size() > 1) {
                    sb.append("?");
                }

                Integer now_node = q.poll();
                sb.append(now_node+ " ");
                cnt++;
                List<Integer> next_nodes = graph.get(now_node);

                for (Integer next_node : next_nodes) {
                    degree[next_node]--;
                    if (degree[next_node] == 0) q.offer(next_node);
                }
            }

            if (cnt != n) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(sb);
            }
        }
    }
}
//1
//4
//1 2 3 4
//3
//1 2
//3 4
//2 3

// [0, 4, 2, 1, 3, 0]
// 5로 가는 간선 0
// 4로 가는 간선 3
// 3로 가는 간선 1
// 2로 가는 간선 2
// 1로 가는 간선 4
// 5 3 2

// 5 4 3 2 1
// (2-4) swap
// 5 2 3 4 1
// []
// [1, 4]
// [2, 1]
// [3, 1]
// [4, 3, 2, 1]

// []
// []
// [1, 4]
// [2, 1, 4]
// [1]
// [4, 3, 2, 1]
// 5 3 2 4 1


// 1 3 2
// 1 3

// 3 1 2


//1 2 3 4
//3
//1 2 -> 2 1 3 4
//2 3 -> 3 1 2 4
//3 4 -> 4 1 2 3
