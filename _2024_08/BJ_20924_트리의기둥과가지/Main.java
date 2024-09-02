package com.ssafy._2024_08.BJ_20924_트리의기둥과가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("to=").append(to);
        sb.append(", cost=").append(cost);
        sb.append('}');
        return sb.toString();
    }
}

public class Main {
    static List<List<Node>> graph, graph2;
    static int pillar, branch, N, R, flag, visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        pillar = 0; // 기둥
        branch = Integer.MIN_VALUE; // 가지
        flag = 0;
        visited = new int[N + 1];

        graph = new ArrayList<>();
        graph2 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            graph2.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, d));
            graph.get(b).add(new Node(a, d));
            graph2.get(a).add(new Node(b, d));
        }

        visited[R] = 1;
        dfs(R, 0);

        // 기둥의 높이가 0인데 루트가 기가노드가 아닌 경우
        // 기둥만 존재하는 것이다.
        if (pillar == 0 && flag == 0) {
            pillar = branch;
            branch = 0;
        }

        // 기둥의 높이가 0인데
        System.out.println(pillar + " " + branch);
    }

    static void dfs(int nowNode, int l) {
        List<Node> nextNodesA = graph.get(nowNode); // 양방향
        List<Node> nextNodesB = graph2.get(nowNode); // 단방향


        // 다음 가지의 수
        int cnt = 0;
        for (Node node : nextNodesA) {
            if (visited[node.to] == 0) {
                cnt++;
            }
        }

        // 다음 가지가 3개 이상일 때 기가노드에 진입.
        if (cnt >= 2) {
            // 시작점이 기가노드인 경우
            if (nowNode == R) {
                flag = 1;
            }

            // 시작점이 기가노드가 아닌 경우만 기둥의 높이를 구한다.
            // 기둥의 높이가 정해지면 바꾸지 않는다.
            if (flag == 0 && pillar == 0) {
                pillar = l;
            }
        }

        // 리프노드에 도착했을 때
        if (cnt == 0) {
            branch = Math.max(branch, l - pillar);
        }

        for (Node nextNode : nextNodesA) {
            if (visited[nextNode.to] == 1) {
                continue;
            }

            visited[nextNode.to] = 1;
            dfs(nextNode.to, l + nextNode.cost);
            visited[nextNode.to] = 0;
        }
    }
}

//9 1
//1 2 1
//1 6 2
//1 7 3
//2 3 1
//2 5 1
//3 4 1
//7 8 1
//7 9 3
