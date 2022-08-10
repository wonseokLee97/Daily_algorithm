package com.ssafy.day_220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // TC
        int T = Integer.parseInt(br.readLine());

        // 100 X 100 행렬
        int[][] arr = new int[100][100];
        int area = 0;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            // 색종이의 범위 만큼 칠해주는데,
            for (int i = nx; i < nx + 10; i++) {
                for (int j = ny; j < ny + 10; j++) {
                    // 색종이가 칠해지지 않았을 때만 칠해주면 중복되는 부분은
                    // 계산하지 않는다.
                    if (arr[i][j] == 0) {
                        arr[i][j] = 1;
                    }
                }
            }

        }

        // 총 영역의 합
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (arr[i][j] == 1) {
                    area += 1;
                }
            }
        }
        System.out.println(area);
    }
}
// x
// (3, 7) -> (13, 1)
// (15, 7) -> (25, 7)
// (5, 2) -> (15, 2)

//y
// (3, 7) -> (3, 17)
// (15, 7) -> (15, 17)
// (5, 2) -> (5, 12)

//total
// (3, 7) -> (13, 17)
// (15, 7) -> (25, 17)
// (5, 2) -> (15, 12)

// 5-13 -> 8
// 7-12 -> 5

// {2, 7, 12, 17}
// {3, 5, 13, 15, 25}

