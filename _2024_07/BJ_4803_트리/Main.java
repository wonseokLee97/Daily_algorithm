package com.ssafy._2024_07.BJ_4803_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int parent[], check[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            check = new int[n + 1];
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }


            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                // 두 정점을 union
                union(from, to);
                System.out.println(Arrays.toString(parent));

            }

            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                // 사이클이 아닌 경우에만..
//                if (check[find(parent[i])] == 0) {
//                    set.add(find(parent[i]));
//                }
                int p = find(i);

                if (p > 0) {
                    set.add(find(i));
                }
            }

            System.out.println(set);
            int trees = set.size();

            // Case 1: A forest of 3 trees.
            // Case 2: There is one tree.
            // Case 3: No trees.
            if (trees == 0) {
                System.out.printf("Case %d: No trees.\n", T);
            } else if (trees == 1) {
                System.out.printf("Case %d: There is one tree.\n", T);
            } else {
                System.out.printf("Case %d: A forest of %d trees.\n", T, trees);
            }

            T++;
        }
    }


    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        // Cycle!
        if (x == y) {
            parent[x] = 0;
            return;
        }

        if (x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    static int find(int x) {
        // 만약 자기 자신이 부모라면
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
