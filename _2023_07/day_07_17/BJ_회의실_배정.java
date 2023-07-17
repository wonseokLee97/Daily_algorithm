package com.ssafy._2023_07.day_07_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_회의실_배정 {

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end != o.end) {
                return Integer.compare(this.end, o.end);
            } else {
                return Integer.compare(this.start, o.start);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max_val = Integer.MIN_VALUE;
        List<Node> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new Node(s, e));
        }

        Collections.sort(list);

        Node beforeNode = list.get(0);
        int cnt = 0;

        for (int j = 1; j < list.size(); j++) {
            Node nextNode = list.get(j);
            // 이전 노드가 끝나는 시간보다 다음 노드의 시작지점이 같거나 커야한다.
            if (beforeNode.end <= nextNode.start) {
//                System.out.println(beforeNode + "->" + nextNode);
                beforeNode = nextNode;
                cnt++;
            }
        }

        max_val = Math.max(max_val, cnt);

        System.out.println(max_val + 1);
    }
}

// Node{start=0, end=6},
// Node{start=1, end=4},
// Node{start=2, end=13},
// Node{start=3, end=5},
// Node{start=3, end=8},
// Node{start=5, end=7},
// Node{start=5, end=9},
// Node{start=6, end=10},
// Node{start=8, end=11},
// Node{start=8, end=12},
// Node{start=12, end=14}
