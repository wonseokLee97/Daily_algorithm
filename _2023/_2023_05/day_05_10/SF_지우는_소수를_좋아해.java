package com.ssafy._2023._2023_05.day_05_10;

import java.util.*;
import java.io.*;


class Node {
    int b, c;

    public Node(int b, int c) {
        this.b = b;
        this.c = c;
    }
}

public class SF_지우는_소수를_좋아해
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max_val = Integer.MIN_VALUE;


        List<Node>[] graph = new ArrayList[N + 1];

        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            max_val = Math.max(max_val, C);

            graph[A].add(new Node(B, C));
        }

        // 1
        for (int i = 1; i < graph.length + 1; i++) {
            for (Node node : graph[i]) {
                int i1 = node.b + node.c;
            }
        }


//        System.out.println(Arrays.toString(dest));

        // A번 체육관과, B번 체육관 사이에 필요 레벨이 C인 길이
        // int형 배열을 담는 길이가 N+1 인 ArrayList를 만들어준다.
        // 2부터 max_val 까지 소수중, 목적지 까지 최소로 갈 수 있는 소수를 구하여라!

        // 0: []
        // 1: [(2, 5), (3, 1), (4, 2)]
        // 2: [(5, 5)]
        // 3: [(5, 4), (6, 1)]
        // 4: [(6, 1), (7, 3)]
        // 5: [(8, 5)]
        // 6: [(9, 4)]
        // 7: [(9, 2)]
        // 8: [(10, 5)]
        // 9: [(10, 3)]

        // 소수 1, 2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 23 ...
        // 1 - 2
    }
}

//
//
//
//
//// A번 체육관과, B번 체육관 사이에 필요 레벨이 C인 길이
//// int형 배열을 담는 길이가 N+1 인 ArrayList를 만들어준다.
//// 2부터 max_val 까지 소수중, 목적지 까지 최소로 갈 수 있는 소수를 구하여라!
//
//// 0: []
//// 1: [(2, 5), (3, 1), (4, 2)]
//// 2: [(5, 5)]
//// 3: [(5, 4), (6, 1)]
//// 4: [(6, 1), (7, 3)]
//// 5: [(8, 5)]
//// 6: [(9, 4)]
//// 7: [(9, 2)]
//// 8: [(10, 5)]
//// 9: [(10, 3)]
//
//// 소수 1, 2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 23 ...
//// 1 - 2