package com.ssafy._2023_06.day_06_01;


import java.util.Arrays;
import java.util.Scanner;

public class BJ_9663_N_Queen {

    static int arr[], N, answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N];

        // 0번 열 부터 시작
        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int col) {
        if (col == N) {
            answer++;
            return;
        }

        // 총 N개의 행 순으로
        for (int i = 0; i < N; i++) {
            // 퀸을 놓아보자.
            arr[col] = i;

            // 퀸을 놓을 수 있는가?
            if (canDo(col)) {
                // 열 이동
                dfs(col + 1);
            }
        }
    }
//
    private static boolean canDo(int col) {

        // 내가 (col, arr[col]) 에 둔 퀸의 좌표에서
        // col 의 위치 이전까지 (i, arr[i]) 내가 둔 퀸과 같은 좌표에선상에 있는 퀸이 있는지 확인한다.
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            // 대각선상에 존재하는 경우.
            // ex) (2, 1) (3, 2) (4, 3) ... (col, arr[col]) ... (i, arr[i])
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        // 현재 열(col) 이전 까지와 비교했을 때 이전의 퀸과 대각선 혹은 가로에서 만나지 않는다면
        return true;
    }
}


//