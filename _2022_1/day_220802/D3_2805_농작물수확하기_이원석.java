package com.ssafy._2022_1.day_220802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_2805_농작물수확하기_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int sum = 0;


            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                char[] chars = s.toCharArray();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = chars[j] - '0';
                }
            }


            for (int i = 0; i < (n / 2) + 1; i++) {
                for (int j = (n / 2) - i; j <= (n / 2) + i; j++) {
                    sum += arr[i][j];
                }
            }

            for (int i = n - 1; i > (n / 2); i--) {
                for (int j = i - (n / 2); j < n - i + (n / 2); j++) {
                    sum += arr[i][j];
                }
            }

            System.out.printf("#%d %d", t, sum);
        }
    }
}
// 5 - x = 3
// 4 - x = 4





// 1 - 4
// 0 - 5
//

//n/2 - (i-1) + i + 2i -2
//n/2 - i + 1 + i + 2i - 2
//= n/2 + 2i -1

//1
//5
//14054
//44250
//02032
//51204
//52212

//1
//3
//132
//254
//021

//1
//7
//3200021
//1000023
//3001023
//0000004
//1010033
//3203112
//1032100