package com.ssafy._2022_1._2022_10.day_221004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_2239_스도쿠_이원석 {

    static int arr[][], flag = 0;
    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        list = new ArrayList<>();
        arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = chars[j] - '0';

                if (arr[i][j] == 0) list.add(new int[]{i, j});
            }
        }

        dfs(0);
    }


    public static void dfs(int cnt) {
//        System.out.printf("==== %d ==== \n", cnt);
//        for (int[] ints : arr) {
//
//        }
//        System.out.println();


        // 빈 칸이 모두 채워졌을 때,
        if (cnt == list.size()) {
            // print
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }

        int[] get = list.get(cnt);
        int x = get[0];
        int y = get[1];

        // 체킹용
        int[] validate = new int[10];

        // check_row
        for (int i = 0; i < 9; i++) {
            // 해당 행의 0이 아닌 숫자는 리스트에 넣는다!
            if (arr[x][i] != 0) {
                validate[arr[x][i]] = 1;
            }
        }


        // check_col
        for (int i = 0; i < 9; i++) {
            // 해당 열의 0이 아닌 숫자는 리스트에 넣는다!
            if (arr[i][y] != 0) {
                validate[arr[i][y]] = 1;
            }
        }


        // check_box
        int h = (x/3) * 3;
        int w = (y/3) * 3;
        for (int i = h; i < h + 3; i++) {
            for (int j = w; j < w + 3; j++) {
                if (arr[i][j] != 0) {
                    validate[arr[i][j]] = 1;
                }
            }
        }

        // sudoku
        for (int i = 1; i < 10; i++) {
            // 아직 비어있는
            if (validate[i] == 0) {
                arr[x][y] = i;
                dfs(cnt + 1);
                if (flag == 1) {
                    return;
                }
                arr[x][y] = 0;
            }
        }
    }
}

// 0 1 2, 3 4 5, 6 7 8



// 스도쿠 풀기!
// 1. 각 행에 1~9 까지의 숫자가 중복없이 나온다.
// 2. 각 열에 1~9 까지의 숫자가 중복없이 나온다.
// 3. 각 3x3 사각형에 1~9 까지의 숫자가 중복없이 나온다.

// 행   2, 4, 6, 7, 8
// 열   1, 2, 3, 4, 5, 7, 8, 9
// 상자  4, 5, 6, 7, 8, 9


//000000000
//000000000
//000000000
//000000000
//000000000
//000000000
//000000000
//000000000
//123456789
