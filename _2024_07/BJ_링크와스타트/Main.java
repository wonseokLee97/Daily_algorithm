package com.ssafy._2024_07.BJ_링크와스타트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][], visited[], ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4C1, 4C2, 4C3

        for (int i = 1; i <= N / 2; i++) {
            visited = new int[N];
            comb(0, 0, i);
//            System.out.println("=======");
        }

        System.out.println(ans);
    }

    static void comb(int cnt, int start, int fin) {
        if (cnt == fin) {
            List<Integer> l = new ArrayList<>();
            List<Integer> s = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (visited[i] == 1) { // 링크팀: 0
                    l.add(i);
                } else { // 스타트팀: 1 2 3
                    s.add(i);
                }
            }

            int lScore = 0;
            int sScore = 0;

            for (int i = 0; i < l.size() - 1; i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    int x = l.get(i);
                    int y = l.get(j);
                    lScore += arr[x][y] + arr[y][x];
                }
            }

//            System.out.println("=========");

            for (int i = 0; i < s.size() - 1; i++) {
                for (int j = i + 1; j < s.size(); j++) {
                    int x = s.get(i);
                    int y = s.get(j);
                    sScore += arr[x][y] + arr[y][x];
                }
            }

//            System.out.println(Arrays.toString(visited));
//            System.out.println(lScore + ", " + sScore);

            ans = Math.min(ans, Math.abs(lScore - sScore));

            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(cnt + 1, i, fin);
            visited[i] = 0;
        }
    }
}

// 1 / 2 3 4
// 0 + (S23 + S32) + (S24 + S42) + (S34 + S43)

// 4C1
// 4C2
// 4C3

// 20C1
// 20C2
// ...
// 20C19