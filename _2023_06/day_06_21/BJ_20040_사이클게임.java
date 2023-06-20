package com.ssafy._2023_06.day_06_21;

import java.util.*;
import java.io.*;

    public class BJ_20040_사이클게임
    {
        static int parent[];

        public static void main(String args[]) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            // 정점의 개수
            int N = Integer.parseInt(st.nextToken());
            // 진행된 차례
            int M = Integer.parseInt(st.nextToken());

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }


            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 그으려는 두 정점이 한 집합일 경우 Cycle
                if (find(x) == find(y)) {
                    System.out.println(i);
                    return;
                }

                union(x, y);
            }

            System.out.println(0);
        }

        public static int find(int x) {
            // 자기 자신을 부모로 두는 정점은 루트이다.
            if (x == parent[x]) {
                return x;
            }

            return find(parent[x]);
        }

        public static void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x != y) {
                // 작은쪽을 부모로 두자.
                if (x < y) {
                    parent[y] = x;
                } else {
                    parent[x] = y;
                }
            }
        }
    }

// 선 플레이어가 홀수 번째 차례
// 후 플레이어가 짝수 번째 차례
// 0 ~ n-1 까지 고유한 번호가 부여된 평면 사의 점 n 개

//
