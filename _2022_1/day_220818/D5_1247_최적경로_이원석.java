package com.ssafy._2022_1.day_220818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Node {
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class D5_1247_최적경로_이원석 {
    static int now_x, now_y, N, min_val, result;
    static int[] visited, check;
    static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            // 입출력 처리
            min_val = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            visited = new int[N];
            check = new int[N];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N + 2; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Node(x, y));
            }
            // ========

            dfs(0);
            System.out.printf("#%d %d\n", t, min_val);
        }
    }

    // 순열
    public static void dfs(int c) {
        if (c == N) {
            now_x = list.get(0).x;
            now_y = list.get(0).y;
            calc(check);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            check[c] = i + 2;
            dfs(c + 1);
            visited[i] = 0;
        }
    }

    // 계산
    public static void calc(int[] check) {
        result = 0;

        for (int i : check) {
            // 초기 좌표
            int nx = now_x, ny = now_y;
            // 거리재기
            result += Math.abs(list.get(i).x - nx)
                    + Math.abs(list.get(i).y - ny);
            // 좌표 이동
            now_x = list.get(i).x;
            now_y = list.get(i).y;
        }
        // 마지막 좌표화 회사의 거리
        result += Math.abs(list.get(1).x - now_x)
                + Math.abs(list.get(1).y - now_y);

        min_val = Math.min(min_val, result);
    }
}

// 70 40
// 30 10
// 10 5
// 90 70
// 50 20