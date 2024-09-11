package com.ssafy._2022_1.day_220817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_15683_감시_이원석 {
    static List<int[]> cctv;
    static int n, m, cnt, min_val = Integer.MAX_VALUE;
    static int[][] arr;

    // 우, 하, 좌, 상
    static int[][] way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        cctv = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((arr[i][j] != 6) && (arr[i][j] != 0)) {
                    cctv.add(new int[]{i, j});
                }
            }
        }
        rotate = new int[cctv.size()];
        permutation(0);
        System.out.println(min_val);
    }

    // 1, 2, 3
    // {1, 1}, {3, 4}, {5, 5}
    public static void permutation(int p) {
        if (p == cctv.size()) {
            cnt = 0;
            int[][] tmp = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tmp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < cctv.size(); i++) {
                // 탐색할 배열, 회전여부, 좌표 r, c
                find_spot(tmp, rotate[i], cctv.get(i)[0], cctv.get(i)[1]);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tmp[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            min_val = Math.min(cnt, min_val);
            return;
        }

        int dir_size = 4;

        // cctv5는 case1
        if (arr[cctv.get(p)[0]][cctv.get(p)[1]] == '5') dir_size = 1;
        // cctv2는 case2
        else if (arr[cctv.get(p)[0]][cctv.get(p)[1]] == '2') dir_size = 2;

        // 90도 회전하는 방향의 경우
        for (int i = 0; i < dir_size; i++) {
            // 회전할 cctv 를 기록
            rotate[p] = i;
            permutation(p + 1);
        }
    }

    public static void find_spot(int[][] tmp, int d, int r, int c) {
        switch (tmp[r][c]) {
            // ->
            case 1:
                detect(tmp, r, c, d);
                break;

            // <-->
            case 2:
                detect(tmp, r, c, d);
                detect(tmp, r, c, d + 2);
                break;

            // ㄱ
            case 3:
                detect(tmp, r, c, d);
                detect(tmp, r, c, d + 1);
                break;

            // ㅓ
            case 4:
                detect(tmp, r, c, d);
                detect(tmp, r, c, d + 1);
                detect(tmp, r, c, d + 2);
                break;

            // +
            case 5:
                detect(tmp, r, c, d);
                detect(tmp, r, c, d + 1);
                detect(tmp, r, c, d + 2);
                detect(tmp, r, c, d + 3);
                break;
        }
    }

    public static void detect(int[][] tmp, int x, int y, int move){
        move %= 4;

        while (true) {
            int nx = x + way[move][0];
            int ny = y + way[move][1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || tmp[nx][ny] == 6) {
                // 범위를 벗어나거나 벽을만나면 break
                break;
            }
            x = nx;
            y = ny;

            if (tmp[nx][ny] == 0) {
                tmp[nx][ny] = 9; // 시야범위 설정
            }
        }
    }
}

// 0, 1, 2, 3 - 1


//4 6
//0 0 0 0 0 0
//0 0 0 0 0 0
//0 0 2 0 6 0
//0 0 0 0 0 0