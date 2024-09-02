package com.ssafy._2024_08.BJ_3020_개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int C = N / 2;

        // idx가 짝수면 석순, 홀수면 종유석
        // reverse 0 1 0 1 0 1 0 1 0 1 0 1 0 1
        //         1 3 4 2 2 4 3 4 3 3 3 2 3 3
        // 최대높이  1 2 4 3
        //         1 > mh면 안걸림
        //         2 <= mh면 안걸림
        //         4 > mh면 안걸림
        //         3 <= mh면 안걸림 ...


        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int dH = Integer.parseInt(br.readLine());
            // 석순
            if (i % 2 == 0) {
                arr[i] = dH;
            }
            // 종유석
            else {
                arr[i] = H - dH;
            }
        }

        int s = 1;
        int e = H;

        while (s <= e) {
            int mh = (s + e) / 2;

            // 충돌횟수
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                // 석순
                if (i % 2 == 0) {
                    if (arr[i] <= mh) {
                        cnt++;
                    }
                }
                // 종유석
                else {
                    if (arr[i] > mh) {
                        cnt++;
                    }
                }
            }

            // 파괴한 장애물이 N/2 보다 적은 경우
            if (cnt < C) {
                C = cnt;
            } else {

            }
        }
    }
}

// 최소한의 장애물을 파괴하는 경우는 N/2 이다.

// 상한선 - 하한선
// 개똥벌레가 파괴해야하는 장애물의 최솟값과
// 그러한 구간이 총 몇 개 있는지 구하는 프로그램을 작성하시오.

//14 5
//1
//3
//4
//2
//2
//4
//3
//4
//3
//3
//3
//2
//3
//3

//   1  2  3  4  5  6
// 1    1     1     1
// 2    1     1
// 3    1     1  1
// 4    1        1
// 5    1  1     1
// 6       1     1
// 7 1     1     1
