package com.ssafy.day_220824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D4_3289_서로소집합_이원석 {
    static int[] parents;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        List<int[]> logic;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            logic = new ArrayList<>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                logic.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            make();

            for (int[] l : logic) {
                if (l[0] == 0) { // 합집합이면,
                    union(l[1], l[2]);
                } else {
                    if (find(l[1]) == find(l[2])) { // a, b가 같은 집합인가?
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
//                System.out.println(l[0] + ", " + l[1] + ", " + l[2]);
//                System.out.println(Arrays.toString(parents));
//                System.out.println();
            }

            System.out.println("#" + t + " " + sb);
        }
    }

    public static void make() {
        parents = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}
