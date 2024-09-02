package com.ssafy._2024_07.BJ_10711_모래성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int H, W, visited[][], wave,
            dx[] = {-1, 1, 0, 0, 1, -1, -1, 1},
            dy[] = {0, 0, -1, 1, 1, -1, 1, -1};
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        wave = 0;
        arr = new char[H][W];
        Queue<int[]> noSand = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                arr[i][j] = cArr[j];
                if (arr[i][j] == '.') noSand.offer(new int[]{i, j});
            }
        }

        while (!noSand.isEmpty()) {
            int size = noSand.size();
            int flag = 0;

            for (int j = 0; j < size; j++) {
                int[] poll = noSand.poll();
                int x = poll[0];
                int y = poll[1];

                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        // 모래성이 없는 경우
                        if (arr[nx][ny] != '.') {
                            // 모래성의 높이를 감소시키자.
                            arr[nx][ny]--;

                            if (arr[nx][ny] == '0') {
                                arr[nx][ny] = '.';
                                flag = 1;
                                noSand.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }

            if (flag == 1) {
                wave++;
            }
        }

        System.out.println(wave);
    }
}

// 이 튼튼함은, 자기 격자 주변의 8방향 (위 아래 왼쪽 오른쪽, 그리고 대각선) 을 봐서
// 모래성이 쌓여있지 않은 부분의 개수가 자기 모래성의 튼튼함보다 많거나 같은 경우 파도에
// 의해서 무너질 수 있음을 의미한다.


// 모래성이 쌓여있지 않은 부분의 개수 < 자기 모래성의 튼튼함 (안 무너진다.)

// 0
// ......
// .939..
// .3428.
// .9393.
// ......

// 1
// ......
// .9.9..
// ..428.
// .9.9..
// ......

// 2
// ......
// .9.9..
// ..4.8.
// .9.9..
// ......

// 3
// ......
// .9.9..
// ....8.
// .9.9..
// ......