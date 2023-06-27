package com.ssafy._2023_06.day_06_24;

import java.util.*;
import java.io.*;

public class BJ_1043_거짓말 {

    static int N, M, cnt, parent[];
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            graph.add(new ArrayList<>());
        }

        cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());

        // 거짓말을 아는 사람이 없다면?
        if (know == 0) {
            System.out.println(M);
            return;
        }

        int[] arr = new int[N + 1];
        for (int i = 0; i < know; i++) {
            int get = Integer.parseInt(st.nextToken());
            arr[get] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int ps = Integer.parseInt(st.nextToken());
            graph.get(i).add(ps);

            for (int j = 0; j < ps; j++) {
                graph.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }


        for (int i = 0; i < M; i++) {
            List<Integer> list = graph.get(i);

            // 이 부분때문에 틀렸다..
            // 결국 파티의 모든 구성원을 하나의 집합으로 묶어야 한다.
            // 나중에 연결될 수도 있기 때문에..
//            int flag = 0;
//
//            // 파티 인원만큼
//            for (int j = 1; j <= list.get(0); j++) {
//                if (arr[list.get(j)] == 1) {
//                    flag = 1;
//                    break;
//                }
//            }

            for (int j = 1; j < list.get(0); j++) {
                if (find(list.get(j)) != find(list.get(j + 1))) {
                    union(list.get(j), list.get(j + 1));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (arr[i] == 1) {
                arr[find(i)] = 1;
            }
        }


        for (int i = 0; i < M; i++) {
            List<Integer> list = graph.get(i);
            int flag = 0;

            for (int j = 1; j <= list.get(0); j++) {
                // 현재 정점의 부모를 찾는다.
                int p = find(list.get(j));

                if (arr[p] == 1) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);


        // route 부모가 다르다면 다른 집합이다.
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    // 루트노드 찾기
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        // 해당 정점의 부모를 찾는다.
        return find(parent[x]);
    }
}

// 각 파티마다 비밀을 아는 사람이 있으면 안됨.
// 비밀을 아는 사람들을 union 하고,
// 당연히, 어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.
// 지민이는 이런 일을 모두 피해야 한다.
// 각 파티마다 오는 사람들의 route 를 구해서 파티에 구라를 칠 수 있는지 구하자.

//3 4
//1 3
//1 1
//1 2
//2 1 2
//2 1 3