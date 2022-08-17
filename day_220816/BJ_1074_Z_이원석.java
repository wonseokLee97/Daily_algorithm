package com.ssafy.day_220816;

import java.util.Scanner;

public class BJ_1074_Z_이원석 {
    static int[] dx = new int[]{0, 0, 1, 1};
    static int[] dy = new int[]{0, 1, 0, 1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int l = (int) Math.pow(2, N);
        dfs(l, r, c);
        System.out.println(cnt);
    }


    public static void dfs(int l, int row, int col) {
        if (l == 1) {
            return;
        }

        if (row < l / 2 && col < l / 2) { // 1사분면
            dfs(l / 2, row, col);

        } else if ((row < l / 2) && (col < l && l / 2 <= col)) { // 2사분면
            cnt += ((l / 2) * (l / 2)) * 1;
            // 행을 기준으로 줄어드는 다음 배열 범위만큼 축소
            dfs(l / 2, row, col - l / 2);

        } else if ((row < l && l / 2 <= row) && col < l / 2) { // 3사분면
            cnt += ((l / 2) * (l / 2)) * 2;
            dfs(l / 2, row - l / 2, col);

        } else {
            cnt += ((l / 2) * (l / 2)) * 3;
            dfs(l / 2, row - l / 2, col - l / 2); // 4사분면
        }
    }
}


