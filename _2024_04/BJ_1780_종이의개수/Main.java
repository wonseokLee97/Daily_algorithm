package com.ssafy._2024_04.BJ_1780_종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[][], cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cnt = new int[3];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
             st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N);

        System.out.println(cnt[2]);
        System.out.println(cnt[0]);
        System.out.println(cnt[1]);
    }

    static void dfs(int x, int y, int size) {
        int start = arr[x][y];

        if (size == 1) {
            if (start == -1) {
                cnt[2]++;
            } else {
                cnt[start]++;
            }
            return;
        }

        int flag = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // 시작점과 다른 숫자가 나오면 모두 같은 숫자가 아니다.
                if (arr[i][j] != start) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                break;
            }
        }

        if (flag == 1) {
            // [0 0] [0 3] [0 6]
            // [3 0] [3 3] [3 6]
            // [6 0] [6 3] [6 6]
            size /= 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    dfs(x + (i * size), y + (j * size), size);
                }
            }
        } else {
            if (start == -1) {
                cnt[2]++;
            } else {
                cnt[start]++;
            }
            return;
        }
    }
}

//
// 1) 만약 종이가 모두 같은 수로 되어 있다면 그대로 사용
// 2) 아닐경우 다시 1을 반복
// N/3의 크기를 기준으로 시작점 시작점에서 탐색을 시작한다.



// 0 0 0 1 1 1 -1 -1 -1
// 0 0 0 1 1 1 -1 -1 -1
// 0 0 0 1 1 1 -1 -1 -1
// 1 1 1 0 0 0 0 0 0
// 1 1 1 0 0 0 0 0 0
// 1 1 1 0 0 0 0 0 0
// 0 1 -1 0 1 -1 0 1 -1
// 0 -1 1 0 1 -1 0 1 -1
// 0 1 -1 1 0 -1 0 1 -1
