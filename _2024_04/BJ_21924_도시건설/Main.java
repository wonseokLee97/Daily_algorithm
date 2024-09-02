package com.ssafy._2024_04.BJ_21924_도시건설;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] visited = new int[N + 1];
        long total = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
            total += c;
        }

        // 비용기준 오름차순 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });


        long ans = total - PrimMST(pq, visited);
        int flag = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    // 사이클의 생성 여부를 확인하기 위해 방문처리를 사용
    // 우선순위 큐를 통해 노드를 뽑았기 때문에, 이미 방문된 곳은 연결해봤자 최소가 아니다.
    static long PrimMST(PriorityQueue<Node> pq, int[] visited) {
        pq.offer(new Node(1, 0));
        long total = 0;

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            // 이미 방문했다면
            if (visited[now_node.to] == 1) {
                continue;
            }

            visited[now_node.to] = 1;
            total += now_node.cost;

            List<Node> next_nodes = graph.get(now_node.to);

            for (Node next_node : next_nodes) {
                if (visited[next_node.to] == 1) {
                    continue;
                }

                pq.offer(new Node(next_node.to, next_node.cost));
            }
        }

        return total;
    }
}

//3 3
//1 2 1
//2 3 1
//3 1 1