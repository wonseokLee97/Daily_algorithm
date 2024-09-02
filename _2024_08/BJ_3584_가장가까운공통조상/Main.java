package com.ssafy._2024_08.BJ_3584_가장가까운공통조상;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int depth[], parent[], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] pCheck = new int[N + 1];
            depth = new int[N + 1];
            parent = new int[N + 1];

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph.get(B).add(A);
                graph.get(A).add(B);
                pCheck[B] = 1;
            }

            int p = -1;
            for (int i = 1; i <= N; i++) {
                if (pCheck[i] == 0) {
                    p = i;
                }
            }
            deptchCekck(1, p, 0);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans = 0;
            LCA(a, b);

            System.out.println(ans);
        }
    }

    static void LCA(int a, int b) {
        // 같은 정점인경우
        if (a == b) {
            ans = a;
            return;
        }

        int dA = depth[a];
        int dB = depth[b];

        // a의 depth 가 b보다 깊을경우
        if (dA > dB) {
            // a의 부모로 이동, b는 동일
            LCA(parent[a], b);
        } else if (dA < dB) {
            LCA(a, parent[b]);
        } else {
            // a와 b는 다르지만 depth만 같은경우,
            // a,b 모두 각자의 부모로 이동
            LCA(parent[a], parent[b]);
        }
    }

    static void deptchCekck(int cnt, int nowNode, int parentNode) {
        depth[nowNode] = cnt;
        parent[nowNode] = parentNode;

        List<Integer> nextNodes = graph.get(nowNode);
        for (Integer nextNode : nextNodes) {
            // 다음 노드가 부모가 아닌 경우만
            if (nextNode != parentNode) {
                deptchCekck(cnt + 1, nextNode, nowNode);
            }
        }
    }
}


//5
//2 3
//3 4
//3 1
//1 5
//2 1

//3 5