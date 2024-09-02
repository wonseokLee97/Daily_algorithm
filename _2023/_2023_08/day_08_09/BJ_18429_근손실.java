package com.ssafy._2023._2023_08.day_08_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18429_근손실 {
    static int N, K, ans, visited[], arr[], kit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // 근력 감소치
        K = Integer.parseInt(st.nextToken());
        visited = new int[N];
        arr = new int[N];
        kit = new int[N + 1];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            kit[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);

        System.out.println(ans);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            int total = 0;

            for (int i : arr) {
                if (total < 0) {
                    return;
                }

                total += (kit[i] - K);
            }

            ans++;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] != 0) {
                continue;
            }

            arr[cnt] = i + 1;
            visited[i] = 1;
            perm(cnt + 1);
            visited[i] = 0;
        }
    }
}

// 순서에 따라 다른 결과 순열