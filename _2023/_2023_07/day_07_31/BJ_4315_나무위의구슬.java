package com.ssafy._2023._2023_07.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_4315_나무위의구슬 {

    static List<List<Integer>> graph;
    static int ans, parent[], goosle[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            ans = 0;
            graph = new ArrayList<>();

            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            parent = new int[n + 1];
            goosle = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }

//            System.out.println(graph.get(0));

            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());

                // 정점
                int v = Integer.parseInt(st.nextToken());
                // 구슬
                int c = Integer.parseInt(st.nextToken());
                // 자식의 수
                int d = Integer.parseInt(st.nextToken());

                goosle[v] = c;
                for (int j = 0; j < d; j++) {
                    int to = Integer.parseInt(st.nextToken());
                    parent[to] = v;
                    graph.get(v).add(to);
//                    graph.get(to).add(v);
                }
            }



            for (int i = 1; i < goosle.length; i++) {
//                    System.out.println("=======" + i + " 번째 구슬! ========");
                dfs(parent[i], i);
//                    System.out.println(Arrays.toString(goosle));
            }


            System.out.println(ans);
        }
    }


    public static void dfs(int before, int now_node) {
        List<Integer> list = graph.get(now_node);


        // 리프노드인 경우 (다시 부모 노드로 되돌아가는 경우)
        if (list.size() == 0) {
            // 구슬 - 1개 만큼 부모 노드로 돌려준다.
            int get = goosle[now_node] - 1;
//            System.out.println("리프노드 발견!" + now_node + ", " + get + " 만큼 구슬을 옮기자!");
            goosle[now_node] -= get;
            goosle[before] += get;
            ans += Math.abs(get);
        } else {
            for (int next_node : list) {
                dfs(now_node, next_node);
            }

            // 부모노드가 있는 경우
            if (parent[now_node] != 0) {
                int get = goosle[now_node] - 1;
//                System.out.println("리프노드 발견!" + now_node + ", " + get + " 만큼 구슬을 옮기자!");
                goosle[now_node] -= get;
                goosle[before] += get;
                ans += Math.abs(get);
            }
        }
    }
}
