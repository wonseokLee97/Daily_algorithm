package com.ssafy._2023._2023_06.day_06_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_19949_영재의시험 {
    static int arr[], visited[], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[10];
        visited = new int[10];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(ans);
    }

    public static void dfs(int cnt) {
        if (cnt == 10) {
            int score = 0;

            for (int i = 0; i < 10; i++) {
                if (visited[i] == arr[i]) {
                    score++;
                }
            }

            if (score >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (cnt >= 2) {
                // 이전, 이이전과 현재 고르려는 답이 같다면 continue
                if (visited[cnt - 1] == i && visited[cnt - 2] == i) continue;
            }

            visited[cnt] = i;
            dfs(cnt + 1);
            visited[cnt] = 0;
        }
    }
}

// 10개 중, 5개 이상 맞추는 경우.