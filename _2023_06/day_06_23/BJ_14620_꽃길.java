package com.ssafy._2023_06.day_06_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14620_꽃길 {

    static int N, arr[][], visited[][], min_val;
    static int[] dx = {0, 1, -1, 0}, dy = {1, 0, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];
        min_val = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(min_val);
    }

    public static void dfs(int cnt) {
        if (cnt == 3) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 1) {
                        total += arr[i][j];
                    }
                }
            }

            min_val = Math.min(min_val, total);

            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (visited[i][j] == 1) {
                    continue;
                }

                int flag = 0;

                for (int k = 0; k < 4; k++) {
                    if (visited[i + dx[k]][j + dy[k]] == 1) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 1) {
                    continue;
                }

                visited[i][j] = 1;
                for (int k = 0; k < 4; k++) {
                    visited[i + dx[k]][j + dy[k]] = 1;
                }

//                System.out.println(i + ", " + j);
//                for (int k = 0; k < N; k++) {
//                    System.out.println(Arrays.toString(visited[k]));
//                }
//                System.out.println();

                dfs(cnt + 1);

                visited[i][j] = 0;
                for (int k = 0; k < 4; k++) {
                    visited[i + dx[k]][j + dy[k]] = 0;
                }
            }
        }
    }
}

// 1 ~ N-1 의 범위내에서 꽃을 심어야한다!