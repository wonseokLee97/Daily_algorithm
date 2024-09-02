package com.ssafy._2023._2023_07.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1043_거짓말 {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<List<Integer>> graph = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;

        int[] knows = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M + 1; i++) {
            graph.add(new ArrayList<>());
        }


        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        if (K != 0) {
            for (int i = 0; i < K; i++) {
                // 진실을 아는 사람들
                knows[Integer.parseInt(st.nextToken())] = 1;
            }
        }

        for (int i = 1; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> party = graph.get(i);

            int loop = Integer.parseInt(st.nextToken());

            for (int j = 0; j < loop; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (List<Integer> g : graph) {
            for (int i = 0; i < g.size() - 1; i++) {
                // 파티에 참석한 사람들끼리 같은 집합이 아닌 경우
                if (find(g.get(i)) != find(g.get(i + 1))) {
                    // 같은 집합으로 만들어주자.
                    union(g.get(i), g.get(i + 1));
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            // 집합 나누기가 끝난 뒤, 추가로 진실을 알게될 수도 있는 사람들을 추가한다.
            if (knows[i] == 1) {
                knows[find(i)] = 1;
            }
        }

        // 파티의 수 만큼
        for (int i = 1; i < M + 1; i++) {
            List<Integer> list = graph.get(i);
            int flag = 0;

            for (int l : list) {
                // 진실을 말해야하는 파티
                if (knows[find(l)] == 1) {
                    flag = 1;
                    break;
                }
            }

            if (flag != 1) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void union(int x, int y) {
        // 두 개를 union 할 건데, 각각 같은 부모를 가지는지 확인하자.
        x = find(x);
        y = find(y);

        // 부모가 다르다면 서로 다른 집합
        if (x != y) {
            if (x < y) {
                parent[y] = x;
            } else {
                parent[x] = y;
            }
        }
    }

    static int find(int x) {
        // 자기 자신이 루트노드가 아니라면, 루트를 찾자
        if (parent[x] != x) {
            return find(parent[x]);
        }

        return x;
    }
}


// 지민이는 진실 혹은 과장으로 이야기를 한다.
// 1 1
// 1 2
// 1 3
// 1 4
// 2 4 1

// 1번만 진실을 안다.
// 1번 파티에서는 말 해도됨
// 2번 파티에서도 말해도됨
// 3번 파티에서 말해도 될까?
// 4번 파티에서 1번이 있기 때문에 거짓말을 할 수 없음. 그렇다면 3번 파티에서도 거짓말을 할 수 없음.

// 그렇다면.. 1번은 진실을 알기때문에 1번과 같은 파티에 가는 사람들에게는 거짓말이 안됨
// 그래프를 순회하며 진실을 아는 사람이 있다면?