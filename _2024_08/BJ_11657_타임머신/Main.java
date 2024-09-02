package com.ssafy._2024_08.BJ_11657_타임머신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int INF = 1061109567;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arr[A][B] = C;
        }

        for (int i = 1; i <= N; i++) {
            arr[i][i] = 0;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // i->k로 가는 길이 있고, k->j로 가는 길이 있다면
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        // 시작점까지의 최단경로가 음수면
        for (int i = 1; i <= N; i++) {
            if (arr[i][i] < 0) {
                System.out.println(-1);
                return;
            }
        }


        for (int i = 2; i <= N; i++) {
            if (arr[1][i] == INF) {
                System.out.println(-1);
            } else {
                System.out.println(arr[1][i]);
            }
        }
    }
}

// 시작점 1까지 걸리는 시간이 음수인 경우 무한으로 시간을 되돌릴 수 있다.


// N개의 도시가 있다.
// 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
// 각 버스는 A, B, C로 나타낼 수 있는데,
// A는 시작도시,
// B는 도착도시,
// C는 버스를 타고 이동하는데 걸리는 시간이다.
//
// 시간 C가 양수가 아닌 경우가 있다.
// C = 0인 경우는 순간 이동을 하는 경우,
// C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
//
// 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.