package com.ssafy._2024._04.BJ_2960_에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[], visited[], N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N - 1];
        visited = new int[N - 1];
        for (int i = 2; i <= N; i++) {
            arr[i - 2] = i;
        }

        int cnt = 0;
        int ans = 0;

        while (true) {
            int min_num = -1;
            int min_idx = -1;

            for (int i = 0; i <= N - 2; i++) {
                if (visited[i] == 1) {
                    continue;
                }

                min_num = arr[i];
                min_idx = i;
                break;
            }

            for (int i = min_num; i < N - 2; min_num *= 2) {
                visited[i] = 1;
                cnt++;

                if (cnt == K) {
                    ans = arr[i];
                    break;
                }
            }

            if (ans != 0) {
                break;
            }
        }

        System.out.println(ans);
    }
}


// 2 3 4 5 6 7 8 9 10 11 12 13 14 15
// x o x o x o x o  x  o  x  o  x  o

// 3 5 7 9 11 13 15
// x o o x  o  o  x

// 5 7 11 13
// x o  o  o

// 7
// x

// 10000000000