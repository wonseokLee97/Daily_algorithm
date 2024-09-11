package com.ssafy._2024._03.day_03_22.day_03_23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int s;
    int e;

    Node (int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public String toString() {
        return s + ", " + e;
    }
}

public class BJ_13334_철로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                // 끝점을 기준으로 정렬해야 한다.. 끝점이 같다면 시작점을 기준으로 오름차순 정렬
                if (o1.e == o2.e) {
                    return o1.s - o2.s;
                }
                return o1.e - o2.e;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 <= n2) {
                pq.offer(new Node(n1, n2));
            } else {
                pq.offer(new Node(n2, n1));
            }
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

//        int answer = 0;
//
//        int d = Integer.parseInt(br.readLine());
//        // 최대 수용가능한 지점
//        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
//        while (!pq.isEmpty()) {
//            Node now_node = pq.poll();
//            // 길이 d를 넘는 거리는 제외
//            if (now_node.e - now_node.s > d) continue;
//            pq2.offer(now_node.s);
//
//            while (!pq2.isEmpty()) {
//                Integer s = pq2.peek();
//                // 간격의 끝에서 길이 d를 두어도 s에 닿지 못하는 경우에는 pq2를 poll 하고 길이를 연장한다.
//                if (s < now_node.e - d) pq2.poll();
//                else break;
//            }
//
//            answer = Math.max(answer, pq2.size());
//        }
//
//        System.out.println(answer);
    }
}

// 길이 d 이하의 출근길 그룹
// d 초과라면 건너뛰기
// d 이하라면 L에 포함될 가능성이 있다!
// 10 - 20
// 10 < 20 - 30