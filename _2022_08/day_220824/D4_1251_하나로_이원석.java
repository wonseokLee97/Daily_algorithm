package com.ssafy.day_220824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Island {
    double x, y;

    public Island(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node> {
    int from, to;
    double weight;
    public Node(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.weight, o.weight);
    }
}


public class D4_1251_하나로_이원석 {
    static int[] parents, xl, yl, visited, from_to;
    static int N, cnt, check;
    static Island[] list;
    static List<Node> node_list;
    static double E;
    static double total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t < TC + 1; t++) {
            N = Integer.parseInt(br.readLine());
            total = 0;
            check = 0;

            make();

            xl = new int[N];
            yl = new int[N];
            list = new Island[N];
            node_list = new ArrayList<>();
            visited = new int[N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (i == 0) {
                        xl[j] = Integer.parseInt(st.nextToken());
                    } else {
                        yl[j] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            E = Double.parseDouble((br.readLine()));


            for (int i = 0; i < N; i++) {
                list[i] = new Island(xl[i], yl[i]);
            }


            comb(0, 0);

            Collections.sort(node_list);

//            for (Node node : node_list) {
//                System.out.println(node.from + ", " + node.to + ", " + node.weight);
//            }

            System.out.println();

            for (Node node : node_list) {
                if (union(node.from, node.to)) {
//                    System.out.println(node.from + ", " + node.to + ", " + node.weight);
                    total += E * (node.weight * node.weight);
                    if (++check == N - 1) break;
                }
            }

            System.out.printf("#" + t + " " + Math.round(total));
        }
    }

    public static void comb(int d, int s) {
        if (d == 2) {
            solution(visited);
            return;
        }

        for (int i = s; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(d + 1, i + 1);
            visited[i] = 0;
        }
    }

    public static void solution(int[] visited) {
        cnt = 0;
        from_to = new int[2];

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 1) {
                from_to[cnt++] = i;
            }
        }

        int from = from_to[0];
        int to = from_to[1];

//        System.out.println((list[from].x - list[to].x) * (list[from].x - list[to].x) + ", " + (list[from].y - list[to].y) * (list[from].y - list[to].y));
        double weight = Math.sqrt((list[from].x - list[to].x) * (list[from].x - list[to].x)
                + (list[from].y - list[to].y) * (list[from].y - list[to].y));

        node_list.add(new Node(from, to, weight));
    }



    public static void make() {
        parents = new int[N];

        for (int i = 0; i < N; i++) {
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

        // 같은 부모
        if (aRoot == bRoot) {
            return false;
        }

        parents[bRoot] = aRoot;
        return true;
    }
}
