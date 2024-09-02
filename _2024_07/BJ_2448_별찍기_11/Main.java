package com.ssafy._2024_07.BJ_2448_별찍기_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N * 2 - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

        dfs(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2 - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int r, int c, int N) {
        // 높이가 3이 되었다면 별을 찍자.
        if (N == 3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            for (int i = -2; i <= 2; i++) {
                arr[r + 2][c + i] = '*';
            }
        } else {
            int div = N / 2;
            dfs(r, c, div); // 그대로 원본
            dfs(r + div, c - div, div); // 행을 증가, 열을 감소, 좌측아래
            dfs(r + div, c + div, div); // 행을 증가, 열을 증가, 우측아래
        }
    }
}

// 꼭대기 하나 X
// 좌우 X/2, X/2*3
// 재귀 ㄱㄱ

// N = 3, 6, 12, 24, 48, ...

// A = 1
//  3(3*2^0) = 1(3^0)개
//  * = 3
// * * = 2
//***** = 1
// 0
// 밑변이 1(2^0)개
// 높이는 3(3*2^0)개

// B = A*3
//     6(3*2^1) = 3(3^1)개
//     * = 6
//    * * = 5
//   ***** = 4
//  *     * = 3, 9
// * *   * * = 2
//***** ***** = 1
// 0, 3, 3
// 밑변이 2(2^1)개
// 높이는 6(3*2^1)개

// C = B*3 = A*3*3
//          12(3*2^2) = 9(3^2)개
//           * = 12
//          * * = 11
//         ***** = 10
//        *     * = (9, 15)
//       * *   * * = 8
//      ***** ***** = 7
//     *           * = 6, 18
//    * *         * * = 5
//   *****       ***** = 4
//  *     *     *     * = (3,9) (15,21)
// * *   * *   * *   * * = 2
//***** ***** ***** ***** = 1
// 0, 6, 6
// 밑변이 4(2^2)개
// 높이는 12(3*2^2)개

// (2^0 - 1) 0, (2^1 - 1) 1, (2^2 - 1) 3, (2^3 - 1) 7


// 24
//           *                       *  = 12, 36