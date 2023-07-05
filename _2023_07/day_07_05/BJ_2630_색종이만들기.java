package com.ssafy._2023_07.day_07_05;

import java.util.*;
import java.io.*;

public class BJ_2630_색종이만들기 {

    static int arr[][], b, w;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        b = 0;
        w = 0;

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        conquer(0, 0, N);

        sb.append(w + "\n");
        sb.append(b);

        System.out.println(sb);
    }

    public static void conquer(int x, int y, int size) {
        if(size == 1) {
            if (arr[x][y] == 1) {
                b++;
            } else {
                w++;
            }

            return;
        }

        // 기준점
        int validate = arr[x][y];
        int flag = 0;

        // 탐색한다.
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != validate) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }

        // 분할해야하는 경우..
        if (flag == 1) {
            // 1사분면
            conquer(x, y, size / 2);
            // 2사분면
            conquer(x, y + size / 2, size / 2);
            // 3사분면
            conquer(x + size / 2, y , size / 2);
            // 4사분면
            conquer(x + size / 2, y + size / 2, size / 2);
        } else {
            if (validate == 1) {
                b++;
            } else {
                w++;
            }
        }
    }
}

// 분할정복
// 처음 N개를 탐색하다, 다른 종류의 색종이가 나오면 분할한다 (N / 2)
// 또 탐색하다 다른 종류 -> (N / 2)
// N이 1이면 return