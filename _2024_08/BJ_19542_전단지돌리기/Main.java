package com.ssafy._2024_08.BJ_19542_전단지돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int N, S, D, maxVal, ans, visited[], visited2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        maxVal = Integer.MIN_VALUE;
        visited = new int[N + 1];
        visited2 = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        visited[S] = 1;
        dfs(S);
        System.out.println(Math.max(0, (ans - 1) * 2));
    }

    static int dfs(int nowNode) {
        int maxVal = 0;

        // 모든 정점을 방문하며 리프노드로부터의 거리를 구한다.
        List<Integer> list = graph.get(nowNode);
        for (int nextNode : list) {
            if (visited[nextNode] == 1) {
                continue;
            }
            visited[nextNode] = 1;
            maxVal = Math.max(maxVal, dfs(nextNode));
        }

        // 리프노드까지의 길이(maxVal)이 D보다 같거나 크다면 리프노드에 한 번에 도달가능.
        if (maxVal >= D) {
            ans++;
        }

        // 만약 자기자신이 리프라면 0+1을 return
        return maxVal + 1;
    }
}

// 백트래킹
// 노드로 이동하게 되면, D의 깊이까지 탐색하여 전단지를 뿌린다.
//

//10 4 3
//1 2
//1 4
//1 6
//2 7
//7 8
//8 3
//4 5
//5 10
//4 9