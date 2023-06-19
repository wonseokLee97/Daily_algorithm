package com.ssafy._2023_06;

import java.io.*;
import java.util.StringTokenizer;

public class union_find {
    static int[] parent;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 N, 연산 개수 M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 집합 만들기
            if (c == 0) {
                union(a, b);
            } else { // 두 원소가 같은 집합에 포함되어 있는지 확인
                if (sp(a, b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int a, int b) {
        // 각각의 부모를 찾자.
        a = find(a);
        b = find(b);

        // 같은 부모라면 Cycle
        if (a != b) {
            if (a < b) {
                parent[a] = a;
            } else {
                parent[b] = a;
            }
        }
    }

    public static int find(int x) {
        // route 노드를 찾았다면, (자기 자신을 가르키는 경우)
        if (x == parent[x]) {
            return x;
        }

        // 계속 부모를 찾아 들어가자.
        return parent[x] = find(parent[x]);
    }

    public static boolean sp(int a, int b) {
        // 각각의 부모를 찾자.
        a = find(a);
        b = find(b);

        // 서로 같은 부모를 가지고있다면 집합이다.
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }
}
