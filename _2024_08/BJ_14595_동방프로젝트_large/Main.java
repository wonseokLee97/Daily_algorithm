package com.ssafy._2024_08.BJ_14595_동방프로젝트_large;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 동아리 방의 개수
        int M = Integer.parseInt(br.readLine()); // 종빈의 행동 횟수
        int[] arr = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 시작점이 같다면
                if (o1[0] == o2[0]) {
                    // 끝점기준 내림차순 정렬
                    return o2[1] - o1[1];
                }

                // 아니면 시작점 기준 오름차순
                return o1[0] - o2[0];
            }
        });

        // 1,000,000,000
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{x, y});
        }

        // 1 3
        // 1 2
        int maxVal = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int s = poll[0];
            int e = poll[1];

            // case1. 끝점이 이전까지의 max 보다 작은 경우
            // 탐색하지 않는다.
            if (e <= maxVal) {
                continue;
            }

            // case2. 시작점이 이전까지의 max 보다 작은 경우
            // max 부터 끝점까지 탐색한다. max 갱신
            if (s <= maxVal) {
                for (int i = maxVal; i < e; i++) {
                    union(i, i + 1);
                }
            } else {
                for (int i = s; i < e; i++) {
                    union(i, i + 1);
                }
            }

            maxVal = Math.max(maxVal, e);
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i == parent[i]) {
                ans++;
            }
        }

        System.out.println(ans);
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

// p 1   2   3   4   5
// | 1 | 2 | 3 | 4 | 5 |

// p 1   1   3   4   5
// | 1   2 | 3 | 4 | 5 | - 1 2

// p 1   1   1   1   5
// | 1   2   3   4 | 5 | - 2 4

// x ~ y 순서대로 벽을 무너뜨린다.
// 따라서 x의 부모와 y의 부모가 같다면 이미 그 사이는 벽이 모두 무너진 것.