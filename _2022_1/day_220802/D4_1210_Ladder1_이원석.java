package com.ssafy._2022_1.day_220802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1210_Ladder1_이원석 {
    static int flag = 0;
    static int way = -1; // 1 왼쪽, 2 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[100][100];
        for (int t = 1; t < 11; t++) {
            flag = 0;
            way = -1;
            String s = br.readLine();

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int y = 0; y < arr[0].length; y++) {
                if (arr[0][y] == 1) {
                    graph(0, y, arr);

                    if (flag == 1) {
                        result = y;
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n",t ,result);
        }
    }

    public static void graph(int x, int y, int[][] arr) {
        if (x >= 99) {
            return;
        }

        // 좌우방향
        if ((y + 1 < 100) && (arr[x][y + 1] == 1) && (way != 1)) {
            way = 2;
            graph(x, y + 1, arr);
        } else if ((y - 1 >= 0) && (arr[x][y - 1] == 1) && (way != 2)) {
            way = 1;
            graph(x, y - 1, arr);
        }
        else { // 좌우방향의 조건이 성립하지 않을때 아래로
            if (arr[x + 1][y] == 2) { // 만약 도착지점일 경우
                flag = 1;
                return;
            } else { // 아닐경우 아래로
                way = 0;
                graph(x + 1, y, arr);
            }
        }

        return;
    }
}


//1 0 0 0 1 0 1 0 0 1
//1 0 0 0 1 0 1 1 1 1
//1 0 0 0 1 0 1 0 0 1
//1 0 0 0 1 1 1 0 0 1
//1 0 0 0 1 0 1 0 0 1
//1 1 1 1 1 0 1 1 1 1
//1 0 0 0 1 0 1 0 0 1
//1 1 1 1 1 0 1 0 0 1
//1 0 0 0 1 1 1 0 0 1
//1 0 0 0 1 0 1 0 0 2