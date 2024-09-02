package com.ssafy._2024_08.BJ_10819_차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, visited[], numArr[], arr[], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        numArr = new int[N];
        ans = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(ans);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            calc();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            numArr[i] = cnt;
            perm(cnt + 1);
            numArr[i] = 0;
            visited[i] = 0;
        }
    }

    static void calc() {
        int total = 0;
        for (int i = 0; i < N - 1; i++) {
            total += Math.abs(arr[numArr[i]] - arr[numArr[i + 1]]);
        }

        ans = Math.max(ans, total);
    }
}

// 6
// 20 1 15 8 4 10
// |20 - 1| + |1 - 15| + |15 - 8| + |8 - 4| + |4 - 10|
