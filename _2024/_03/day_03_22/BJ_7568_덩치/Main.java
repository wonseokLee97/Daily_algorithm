package com.ssafy._2024._03.day_03_22.BJ_7568_덩치;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int idx;
    int w;
    int h;

    public Node(int idx, int w, int h) {
        this.idx = idx;
        this.w = w;
        this.h = h;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Node(i, w, h));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.w - o1.w;
            }
        });

        int[] visited = new int[N];

        for (int i = 0; i < N; i++) {
            Node f = list.get(i);

            for (int j = i + 1; j < N; j++) {
                Node s = list.get(j);

                if (f.w > s.w && f.h > s.h) {
                    visited[s.idx]++;
                } else if (f.w < s.w && f.h < s.h) {
                    visited[f.idx]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : visited) {
            sb.append((i + 1) + " ");
        }

        System.out.println(sb);
    }
}


// 덩치 비교를 할 수 있는 경우
// 몸무게와 키 모두 차이가 나야한다.

// 덩치 비교를 할 수 없는 경우


// A    (55, 185)	2
// B	(58, 183)	2
// C	(88, 186)	1
// D	(60, 175)	2
// E	(46, 155)   5

// C	(88, 186)
// D	(60, 175)
// B	(58, 183)
// A    (55, 185)
// E	(46, 155)