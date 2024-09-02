package com.ssafy._2024_05.BJ_2115_갤러리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int
            //      동  남
            dx[] = {0, 1},
            dy[] = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        // 0: 동, 1: 서, 2: 남, 3: 북
        int[][][] wall = new int[4][N][M];

        for (int i = 0; i < N; i++) {
            char[] char_arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (char_arr[j] == '.') {
                    arr[i][j] = 1;
                }
            }
        }

//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }

        int[] way = new int[4];

        int cnt = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (arr[i][j] == 1) {
                    // 동, 남 방향으로 해당 벽면에 그림(길이:2)을 걸 수 있나?
                    for (int k = 0; k < 2; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            // 해당 방면에 벽이 있어야 함
                            if (arr[nx][ny] == 1) {
                                // 동쪽으로 갈 경우 위,아랫변 확인필요
                                if (k == 0) {
                                    // 남쪽 (아랫변)
                                    if (arr[i + 1][j] == 0 && arr[i + 1][j + 1] == 0) {
                                        if (wall[2][i][j] == 0 && wall[2][i][j + 1] == 0) {
                                            wall[2][i][j] = 1;
                                            wall[2][i][j + 1] = 1;
                                            way[2]++;
                                            cnt++;
                                        }
                                    }

                                    // 북쪽 (윗변)
                                    if (arr[i - 1][j] == 0 && arr[i - 1][j + 1] == 0) {
                                        if (wall[3][i][j] == 0 && wall[3][i][j + 1] == 0) {
                                            wall[3][i][j] = 1;
                                            wall[3][i][j + 1] = 1;
                                            way[3]++;
                                            cnt++;
                                        }
                                    }
                                } else { // 남쪽으로 갈 경우 좌,우변 확인필요
                                    // 동쪽 (우변)
                                    if (arr[i][j + 1] == 0 && arr[i + 1][j + 1] == 0) {
                                        if (wall[0][i][j] == 0 && wall[0][i + 1][j] == 0) {
                                            wall[0][i][j] = 1;
                                            wall[0][i + 1][j] = 1;
                                            cnt++;
                                            way[0]++;
                                        }
                                    }

                                    // 서쪽 (좌변)
                                    if (arr[i][j - 1] == 0 && arr[i + 1][j - 1] == 0) {
                                        if (wall[1][i][j] == 0 && wall[1][i + 1][j] == 0) {
                                            wall[1][i][j] = 1;
                                            wall[1][i + 1][j] = 1;
                                            cnt++;
                                            way[1]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        for (int i = 0; i < 4; i++) {
//            int[][] ints = wall[i];
//            System.out.println(i + " 방향의 벽!");
//            for (int[] anInt : ints) {
//                System.out.println(Arrays.toString(anInt));
//            }
//            System.out.println(way[i]);
//            System.out.println();
//        }

        System.out.println(cnt);
    }
}

// arr[N][M][4]

// XXXXX
// X...X
// X.XXX
// X.X.X
// XXXXX