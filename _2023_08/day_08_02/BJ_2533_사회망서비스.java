package com.ssafy._2023_08.day_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2533_사회망서비스 {

    static List<List<Integer>> graph;
    static int N, dp[][], visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        visited = new int[N + 1];
        dp = new int[2][N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

//        for (List<Integer> list : graph) {
//            System.out.println(list.toString());
//        }

        dfs(1);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    static void dfs(int start) {
        visited[start] = 1;
        // 얼리 어답터라면 본인 정점을 포함
        dp[0][start] = 0;
        dp[1][start] = 1;

        List<Integer> childs = graph.get(start);

        for (int child : childs) {
            if (visited[child] == 1) {
                continue;
            }

            // 자식 노드로 재귀
            dfs(child);

            // 얼리 어답터가 아닌경우, 자식 노드들은 모두 얼리 어답터
            dp[0][start] += dp[1][child];
            // 얼리 어답터인 경우, 자식 노드들은 얼리 어답터이거나 아님
            dp[1][start] += Math.min(dp[0][child], dp[1][child]);
        }
    }
}

// 1 ~ N 번까지의 노드를 순회하며 해당 노드가 얼리 어답터인 경우,
// 얼리 어답터가 1명인 경우 최대 전파수
// 1번
// 3,
// 2번
// 5, 6
// 4번
// 7, 8


