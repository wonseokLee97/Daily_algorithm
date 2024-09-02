package com.ssafy._2024_08.BJ_안정적인네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, m, parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 가중치의 오름차순으로 정렬
                return o1[2] - o2[2];
            }
        });

        // 가중치 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());

                // 자기 자신, 1번(본부)인 경우 제외 (이미 연결됨)
                // 본부를 제외하고 나머지의 노드들끼리 MST 를 이루는지 확인해야 한다.
                if (i == 0 || j == 0 || i == j) {
                    continue;
                }

                pq.offer(new int[]{i + 1, j + 1, cost});
            }
        }

        int cnt = 0; // 이을 간선의 수
        int sum = 0; // 비용의 합
        List<int[]> list = new ArrayList<>();

        // 비용이 적은 순으로
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int a = poll[0];
            int b = poll[1];
            int cost = poll[2];

            // a와 b가 연결되어있지 않다면 (부모가 다르다면)
            // 둘을 연결하자.
            if (find(a) != find(b)) {
                sum += cost;
                cnt++;
                union(a, b);
                list.add(new int[]{a, b});
            }
        }


        System.out.println(sum + " " + cnt);
        for (int[] ints : list) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }
}

// 네트워크에 고장이 발생하는 경우는 두 가지가 있다.
// 첫 번째는 직접 연결되어 있는 두 컴퓨터의 연결이 끊어지는 경우이다.
// 회사 측은 이런 경우에도 이 두 컴퓨터가 다른 컴퓨터들을 경유하여 연결되어 있기를 원한다.
// 두 번째는 컴퓨터가 고장 나는 경우이다.
// 회사 측은 이런 경우에는 고장 나지 않은 컴퓨터들끼리 연결되어 있기를 원한다.

//컴퓨터가 고장 난 경우
//1. 1번 컴퓨터가 고장남 -> 나머지들이 MST 구조이다
//2. 1번을 제외한 컴퓨터가 고장남 -> 어차피 1번과 연결되어 있어서 구할 필요 없음.

//두 컴퓨터 간 연결이 끊어짐
//1. 1번과 그 외의 컴퓨터 간의 연결이 끊어짐 -> 1번을 제외하고 MST 구조를 구해야 함
//2. 1번을 제외한 두 컴퓨터 간 연결이 끊어짐 -> 1번을 제외한 MST 구조를 구해야 함.
