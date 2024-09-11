package com.ssafy._2022_1.day_220810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17406_배열돌리기4_이원석 {
    static int[] visited;
    static List<int[]> calc;
    static int[][] arr;
    static int[][] arr_clone;
    static int[] perm;
    static int K;
    static int take = 0;
    static int result;
    static int like;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        K = Integer.parseInt(st.nextToken());
        perm = new int[K];
        arr = new int[N][M];
        arr_clone = new int[N][M];
        like = 0;
        calc = new ArrayList<>();
        visited = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int get = Integer.parseInt(st.nextToken());
                arr[i][j] = get;
                arr_clone[i][j] = get;
            }
        }


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            calc.add(new int[]{r, c, s});
        }

        permutation(0);

        System.out.println(result);
    }

    public static void permutation(int p) {
        if (p == K) {
            for (int i = 0; i < K; i++) {
                take++;
                spin(calc.get(perm[i])[0], calc.get(perm[i])[1], calc.get(perm[i])[2]);
            }
            return;
        }

       for (int i = 0; i < K; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            perm[p] = i;
            permutation(p + 1);
            visited[i] = 0;
        }
    }

    public static void spin(int r, int c, int s) {
        int left_up = r - s - 1;
        int left_down = r + s - 1;
        int right_up = c - s - 1;
        int right_down = c + s - 1;
        int min_sum = Integer.MAX_VALUE;
        int[][] tmp = new int[left_down - left_up + 1][right_down - right_up + 1];

        for (int i = left_up; i < left_down + 1; i++) {
            for (int j = right_up; j < right_down + 1; j++) {
                tmp[i - left_up][j - right_up] = arr[i][j];
            }
        }

        tmp = rotate2(tmp);

        for (int i = left_up; i < left_down + 1; i++) {
            for (int j = right_up; j < right_down + 1; j++) {
                arr[i][j] = tmp[i - left_up][j - right_up];
            }
        }

        if (take == K) {
            take = 0;
            like++;
            for (int i = 0; i < arr.length; i++) {
                int sum = 0;
                for (int j = 0; j < arr[0].length; j++) {
                    sum += arr[i][j];
                }
                min_sum = Math.min(sum, min_sum);
            }
            result = Math.min(min_sum, result);

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = arr_clone[i][j];
                }
            }
        }
    }

    public static int[][] rotate2(int[][] tmp) {
        int N = tmp.length - 1;
        int[][] arr = new int[N + 1][N + 1];

        for (int cnt = 0; cnt <= (N + 1) / 2; cnt++) {
            if (cnt == N - cnt) {
                arr[(N + 1) / 2][(N + 1) / 2] = tmp[(N + 1) / 2][(N + 1) / 2];
                break;
            }

            for (int i = cnt; i < N - cnt; i++) { // 상
                arr[N - 1 - i][cnt] = tmp[N - i][cnt];
            }

            for (int i = cnt; i < N - cnt; i++) { // 우
                arr[cnt][i + 1] = tmp[cnt][i];
            }

            for (int i = cnt; i < N - cnt; i++) { // 하
                arr[i + 1][N - cnt] = tmp[i][N - cnt];
            }

            for (int i = cnt ; i < N - cnt; i++) { // 좌
                arr[N - cnt][N - 1 - i] = tmp[N - cnt][N - i];
            }
        }

        return arr;
    }
}