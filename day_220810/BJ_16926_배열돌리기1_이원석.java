package com.ssafy.day_220810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_이원석 {
    static int[][] arr;
    static int N;
    static int M;
    static int cnt;
    static int[][] r_arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];


        // 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전
        rotate(R);

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(r_arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void rotate(int R) {
        r_arr = new int[N][M]; // 저장할 새로운 배열 할당

        for (int r = 0; r < R; r++) { // R번 만큼
            if (r >= 1) { // 2번 째 부터
                arr = r_arr; // 배열할 회전한 배열을 저장
                r_arr = new int[N][M]; // 저장될 새로운 배열을 할당
            }

            for (int cnt = 0; cnt < Math.min(N, M) / 2; cnt++) {
                for (int i = cnt; i < N - 1 - cnt; i++) {
                    r_arr[i + 1][cnt] = arr[i][cnt]; // 하
                }

                for (int i = cnt; i < M - 1 - cnt; i++) {
                    r_arr[N - 1 - cnt][i + 1] = arr[N - 1 - cnt][i]; // 우
                }

                for (int i = N - 1 - cnt; i >= cnt + 1; i--) {
                    r_arr[i - 1][M - 1 - cnt] = arr[i][M - 1 - cnt]; // 상
                }

                for (int i = M - 1 - cnt; i >= cnt + 1; i--) {
                    r_arr[cnt][i - 1] = arr[cnt][i]; // 좌
                }
            }
        }

        return;
    }
}

// 4, 5 -> 2, 2

// 6, 4 -> 3, 3

// 1 2 3 4
// 1 2 3 4
// 1 2 3 4
// 1 2 3 4
// 1 2 3 4
// 1 2 3 4