package com.ssafy._2023._2023_08.day_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_2302_극장좌석 {
    static List<List<Integer>> graph;
    static int N, cnt, visited[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 좌석의 개수
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        // 고정석의 개수
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 좌석 고정
        for (int i = 0; i < M; i++) {
            int fix = Integer.parseInt(br.readLine());
            arr[fix] = 1;
        }


        for (int i = 1; i < N + 1; i++) {
            if (i == 1) {
                graph.get(i).add(i);

                if (arr[i] == 1) {
                    continue;
                }

                if (arr[i + 1] == 0) {
                    graph.get(i).add(i + 1);
                }
            } else if (i == N) {
                graph.get(i).add(i);

                if (arr[i] == 1) {
                    continue;
                }

                if (arr[i - 1] == 0) {
                    graph.get(i).add(i - 1);
                }
            } else {
                graph.get(i).add(i);

                if (arr[i] == 1) {
                    continue;
                }

                if (arr[i - 1] == 0) {
                    graph.get(i).add(i - 1);
                }

                if (arr[i + 1] == 0) {
                    graph.get(i).add(i + 1);
                }
            }
        }

        cnt = 0;
        for (int idx : graph.get(1)) {
            visited = new int[N + 1];
            visited[idx] = 1;
            dfs(idx + 1);
        }

        System.out.println(cnt);
    }

    static void dfs(int idx) {
        if (idx == N + 1) {
            cnt++;
            return;
        }

        List<Integer> list = graph.get(idx);
        for (int get : list) {
            if (visited[get] == 1) {
                continue;
            }

            visited[get] = 1;
            // 다음 자리로 재귀하며 지금 자리에 대한 정보를 넘김
            dfs(idx + 1);
            visited[get] = 0;
        }
    }

}
// 현재 자리는 이전 자리의 사람과 겹치면 안된다.
//


// 1 2 3 [4] 5 6 [7] 8 9
// 1번 좌석에 앉을 수 있는 사람 (1, 2)
// 2번 좌석에 앉을 수 있는 사람 (1, 2, 3)
// 3번 좌석에 앉을 수 있는 사람 (2, 3)
// 4번 좌석에 앉을 수 있는 사람 (4)
// 5번 좌석에 앉을 수 있는 사람 (5, 6)
// 6번 좌석에 앉을 수 있는 사람 (5, 6)
// 7번 좌석에 앉을 수 있는 사람 (7)
// 8번 좌석에 앉을 수 있는 사람 (8, 9)
// 9번 좌석에 앉을 수 있는 사람 (8, 9)


// 123456789
// 123456798
// 123465789
// 123465798
// 132456789
// 132456798
// 132465789