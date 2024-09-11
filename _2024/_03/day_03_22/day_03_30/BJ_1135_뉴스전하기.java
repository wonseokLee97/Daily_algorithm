package com.ssafy._2024._03.day_03_22.day_03_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int i;
    int s;

    Node(int i, int s) {
        this.i = i;
        this.s = s;
    }
}

public class BJ_1135_뉴스전하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] visited = new int[N];

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.s - o2.s;
            }
        });

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(new Node(i, Integer.parseInt(st.nextToken())));
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            cnt++;

            if (node.s == -1) {
                visited[node.i] = 1;
                continue;
            }

            if (visited[node.s] == 1) {
                visited[node.i] = 1;
            }
        }
    }
}


// 5
// -1 0 0 2 2

// 직속 상사가 작은 순으로 오름차순 정렬
// 민식이는 매번 부하직원에게 전화를 건다.
//
// visited
// 회 원   직속상사
//   0      -1
//   1       0
//   2       0
//   3       1
//   4       1
//   5       2
//   6       2
//   7       3
//   8       3


// 1 2 3 4

// (1 2) 3) 4)