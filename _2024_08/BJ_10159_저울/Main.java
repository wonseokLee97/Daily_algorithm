package com.ssafy._2024_08.BJ_10159_저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> bigger;
    static int cnt[], visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        bigger = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            bigger.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A > B의 입력이다.
            bigger.get(A).add(B);
        }


        cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            visited = new int[N + 1];
            visited[i] = 1;
            dfs(i, i);
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(N - cnt[i]);
        }
    }

    static void dfs(int start, int standard) {
        List<Integer> nextNodesA = bigger.get(start);
        cnt[start]++;

        for (int nextNode : nextNodesA) {
            if (visited[nextNode] == 1) {
                continue;
            }

            visited[nextNode] = 1;
            cnt[standard]++;
            dfs(nextNode, standard);
        }
    }
}

// 1 < 2, 2 > 3

// 1 > 2 > 3 > 4 < 5 < 6

// [1]>[2],
// [2]>[3],
// [3]>[4],
// [5]>[4],
// [6]>[5]