package com.ssafy._2023_06.day_06_01;

import java.util.*;
import java.lang.*;
import java.io.*;

// 소요시간 30분?
public class BJ_14889_스타트와_링크 {

    static int arr[][], N, visited[], answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new int[N];
        answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int start, int cnt) {
        if (cnt == N / 2) {
            startLink();
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            dfs(i + 1, cnt + 1);
            visited[i] = 0;
        }
    }

    private static void startLink() {
        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();

        int A = 0;
        int B = 0;

        for (int i = 0; i < N; i++) {
            // teamA
            if (visited[i] == 1) {
                teamA.add(i); // 1, 3, 6
            } else { // teamB
                teamB.add(i); // 2, 4, 5
            }
        }
        //
        // [1, 0, 1, 0, 0, 1]
        // 13, 16, 36 - (3) + (6) + (8),
        for (int i = 0; i < teamA.size(); i++) {
            for (int j = 0; j < teamA.size(); j++) {
                if (i == j) {
                    continue;
                }

                A += arr[teamA.get(i)][teamA.get(j)];
                B += arr[teamB.get(i)][teamB.get(j)];

            }
        }

        answer = Math.min(answer, Math.abs(A - B));
    }
}

// 경우의 수 (총 4명)
// 1, 4, 5 =
// 2, 3, 6 =

// 2