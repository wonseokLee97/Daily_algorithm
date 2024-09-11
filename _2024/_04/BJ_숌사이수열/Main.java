package com.ssafy._2024._04.BJ_숌사이수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], visited[], cnt_arr[], idx_arr[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        cnt_arr = new int[N * 2];
        idx_arr = new int[100];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        if (sb == null) {
            System.out.println(-1);
        } else {
            System.out.println(sb.toString().trim());
        }
    }

    static void dfs(int cnt) {
        if (cnt == N * 2) {
            System.out.println(Arrays.toString(cnt_arr));
            if (sb == null) {
                sb = new StringBuilder();
                for (int i : cnt_arr) {
                    sb.append(i + " ");
                }
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] >= 2) {
                continue;
            }

            if (visited[i] == 0) {
                idx_arr[arr[i]] = cnt + 1;
            } else {
                if ((cnt + 1) - idx_arr[arr[i]] != arr[i] + 1) {
                    continue;
                }
            }

            visited[i]++;
            cnt_arr[cnt] = arr[i];

            dfs(cnt + 1);

            visited[i]--;
            cnt_arr[cnt] = 0;

            if (visited[i] == 0) {
                idx_arr[arr[i]] = 0;
            }
        }
    }
}

//  1  2  3
// [0, 0, 0]
// [1, 2, 1, 3, 2, 3]

// 0.
// 1. 순열이다. 각 요소를 순서대로 선택하되, 각 요소를 2개 이상 선택하면 안됨.
// 2. 해당 요소를 선택했을 때, ex) 2를 선택했다면, 2칸 이전으로 부터 동일한 요소가 있는지 확인.
// 2-1. 있다면 continue

// [1, 3, 4, 2, 1, 3, 2, 4]

// 2
// 1 2

// 4

//