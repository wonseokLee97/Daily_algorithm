package com.ssafy._2023_06.day_06_21;

import java.util.*;
import java.io.*;


public class BJ_1976_여행가자 {
        static int parent[];

        public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            // 정점의 수
            int N = Integer.parseInt(br.readLine());
            // 방문할 정점의 수 (중복 가능)
            int M = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= N; j++) {
                    int linked = Integer.parseInt(st.nextToken());
                    // 연결된 정점인 경우,
                    if (linked == 1) {
                        union(i, j);
                    }
                }
            }

            System.out.println(Arrays.toString(parent));

            st = new StringTokenizer(br.readLine());
            int start_node = find(Integer.parseInt(st.nextToken()));
            for (int i = 1; i < M; i++) {
                int next_node = Integer.parseInt(st.nextToken());
                System.out.println(start_node + ", " + next_node + ", " + find(next_node));
                // 시작점을 제외한 정점들의 부모가 시작점인지? 같은 집합인지? (갈 수 있는지)
                if (find(next_node) != start_node) {
                    System.out.println("NO");
                    return;
                }
            }

            System.out.println("YES");
        }

        // 부모 노드 찾기
        public static int find(int node) {
            // 부모 노드를 발견했을 때, (자기 자신을 가르키는 노드)
            if (parent[node] == node) {
                return node;
            }

            // 아닐경우 부모 노드를 찾아 재귀
            return parent[node] = find(parent[node]);
        }

        // 합집합 만들기
        public static void union (int x, int y) {
            // 각각 정점의 부모를 찾자.
            x = find(x);
            y = find(y);

            // 1 - [3]
            // 2 - [4]
            // [0, 3, 4, 3, 3];

            // 각각의 부모가 같으면 이미 같은 집합이다.
            if (x != y) {
                // 부모끼리 연결시켜야 합집합이 됨 ㅋ.
                // 무조건 작은 장점이 부모가 되도록 한다.
                if (x < y) {
                    parent[y] = x;
                } else {
                    parent[x] = y;
                }
            }
        }
    }

// 3 - 1 - 2

// 3 - 2 - 1 - 2
// 3 - 2 - 3

// 1번 출발
// 1 - 2 - 1
// 1 - 2 - 3
// 2번 출발

