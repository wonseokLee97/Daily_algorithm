package com.ssafy.day_220810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_16935_배열돌리기3_이원석 {
    static int[][] arr;
    static int N;
    static int M;
    static int R;
    static int[][] new_arr;
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        cnt = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int z = 0; z < R; z++) {
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1: // 상하반전
                    R1();
                    break;
                case 2: // 좌우반전
                    R2();
                    break;
                case 3: // 오른쪽 90도 회전
                    R3();
                    break;
                case 4: // 왼쪽 90도 회전
                    R4();
                    break;
                case 5: // 사분면 이동
                    R5();
                    break;
                case 6: // 사분면 이동
                    R6();
                    break;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }


    // 상하반전
    public static void R1() {
        new_arr = new int[N][M]; // 새로운 배열 할당

        // 가로축을 기준으로, M 개 만큼 역순으로 새로운 배열에 저장한다.
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                new_arr[i][j] = arr[N - 1 - i][j]; // 위에서부터 아래로 -> 새로운 배열에는 아래에서 위로 복사
            }
        }
        arr = new_arr;
    }

    // 좌우반전
    public static void R2() {
        new_arr = new int[N][M]; // 새로운 배열 할당

        // 세로축을 기준으로, N 개 만큼 역순으로 새로운 배열에 저장한다.
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                new_arr[j][i] = arr[j][M - 1 - i]; // 왼쪽에서 오른쪽으로 -> 새로운 배열에는 오른쪽에서 왼쪽으로 복사
            }
        }
        arr = new_arr;
    }

    public static void R3() { // 오른쪽 90도 회전
        int tmp = 0;
        tmp = N;
        N = M;
        M = tmp;
        new_arr = new int[N][M];

        // 1행 -> N - 1열, 2행 -> N - 2열 ...
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                new_arr[j][M - 1 - i] = arr[i][j];
            }
        }
        arr = new_arr;
    }

    public static void R4() { // 왼쪽 90도 회전
        int tmp = 0;
        tmp = N;
        N = M;
        M = tmp;
        new_arr = new int[N][M];

        // 1행 -> 1 열, 2행 -> 2 열 ...
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) { // 0 -> N - 1, 1 -> N - 2
                new_arr[N - 1 - j][i] = arr[i][j];
            }
        }

        arr = new_arr;
    }

    public static void R5() { // 1 -> 2, 2 -> 3, 3 -> 4, 4 -> 1
        new_arr = new int[N][M]; // 새로운 배열 할당

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) { // 1 -> 2, 가로축이 같다.
                new_arr[i][M / 2 + j] = arr[i][j];
            }
            for (int j = M / 2; j < M; j++) { // 2 -> 3, 세로축이 같다.
                new_arr[N / 2 + i][j] = arr[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) { // 3 -> 4. 가로축이 갇타.
                new_arr[i][j - M / 2] = arr[i][j];
            }
            for (int j = 0; j < M / 2; j++) { // 4 -> 1. 세로축이 같다.
                new_arr[i - N / 2][j] = arr[i][j];
            }
        }
        arr = new_arr;
    }


    public static void R6() { // 1->4, 4->3, 3->2, 2->1
        new_arr = new int[N][M]; // 새로운 배열 할당

        for (int i = 0; i < N / 2; i++) { // 1, 2 사분면
            for (int j = 0; j < M / 2; j++) { // 1 -> 4, 가로축이 같다.
                new_arr[N / 2 + i][j] = arr[i][j];
            }
            for (int j = M / 2; j < M; j++) { // 2 -> 1. 세로축이 같다.
                new_arr[i][j - M / 2] = arr[i][j];
            }

        }


        for (int i = N / 2; i < N; i++) { // 3, 4 사분면
            for (int j = 0; j < M / 2; j++) { // 4 -> 3, 세로축이 같다.
                new_arr[i][j + M / 2] = arr[i][j];
            }

            for (int j = M / 2; j < M; j++) { // 3 -> 2. 가로축이 갇타.
                new_arr[i - N / 2][j] = arr[i][j];
            }
        }
        arr = new_arr;
    }
}

//6 8 1
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//6

//6 8 5
//3 2 6 3 1 2 9 7
//9 7 8 2 1 4 5 3
//5 9 2 1 9 6 1 8
//2 1 3 8 6 3 9 2
//1 3 2 8 7 9 2 1
//4 5 1 9 8 2 1 3
//1 2 3 5 6