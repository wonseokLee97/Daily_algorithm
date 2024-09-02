package com.ssafy._2024_07.BJ_16437_양구출작전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    String type;
    int n;
    int to;

    public Node(String type, int n, int to) {
        this.type = type;
        this.n = n;
        this.to = to;
    }
}

public class Main {
    static List<List<Node>> graph;
    static long total, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        total = 0;

        arr = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            graph.get(p).add(new Node(t, a, i));

            if (t.equals("W")) {
                arr[i] = -a;
            } else {
                arr[i] = a;
            }
        }

        // 시작과 부모
        dfs(1, -1);

        System.out.println(arr[1]);
    }

    static void dfs(int start, int parent) {
        // 리프노드에 도착할때까지
        for (Node nextNode : graph.get(start)) {
            dfs(nextNode.to, start);
        }

        // 루트노드가 아니라면
        if (parent != -1) {
            if (arr[start] > 0) {
                arr[parent] += arr[start];
            }
        }
    }
}


// 1, 2, ... N-1, N

// S:100+1000+400
// W:0


// 1, 2, ... N-1, N

// S:100+1000+400
// W:0