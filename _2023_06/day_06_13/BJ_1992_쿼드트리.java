package com.ssafy._2023_06.day_06_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 시작시간: 21시 00분
// 종료시간:

public class BJ_1992_쿼드트리 {

    static int N, arr[][];
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        answer = "";

        for (int i = 0; i < N; i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = c[j] - '0';
//                System.out.print(c[j]);
            }
        }

        dfs(0, 0, N);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int n) {
        if (n == 0) {
            return;
        }


        int flag = 0;

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != arr[x][y]) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1) {
                break;
            }
        }

        if (flag == 1) {
            answer += "(";
            // 4분면 분할
            // 1사분면,
            dfs(x, y, n/2);
            // 2사분면,
            dfs(x, y + n/2, n/2);
            // 3사분면,
            dfs(x + n/2, y, n/2);
            // 4사분면,
            dfs(x + n/2, y + n/2, n/2);
        } else {
            answer += arr[x][y];
            return;
        }

        answer += ")";
        return;
    }
}

// 해당 영역에 다른 숫자가 등장하지 않을 때 까지 분할정복

// 3사
// 2, 4, 0, 2 ->

//4
//1100
//1100
//0111
//1011