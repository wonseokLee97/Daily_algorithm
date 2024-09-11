package com.ssafy._2024._04.BJ_1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans, r, c, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 0;
        cnt = 0;

        long size = (long) Math.pow(2, N);
        div(0, size, 0, size, size);

        System.out.println(ans);
    }

    static void div(long sx, long ex, long sy, long ey, long N) {
        if (N == 1) {
            System.out.println(sx + ", " + ex + ", " + sy + ", " + ey);
//            for (long i = sx; i < ex; i++) {
//                for (long j = sy; j < ey; j++) {
//                    if (i == r && j == c) {
//                        ans = cnt++;
//                        return;
//                    }
//
//                    cnt++;
//                }
//            }
            cnt += 4;

            System.out.println();
            return;
        }

        // 1사분면
        System.out.println("1사분면");
        div(sx, sx + ex / 2, sy, sy + ey / 2, N / 2);

        // 2사분면
        System.out.println("2사분면");
        div(sx, sx + ex / 2, sy + ey / 2, ey, N / 2);

        // 3사분면
        System.out.println("3사분면");
        div(sx + ex / 2, ex, sy, sy + ey / 2, N / 2);

        // 4사분면
        System.out.println("4사분면");
        div(sx + ex / 2, ex, sy + ey / 2, ey, N / 2);
    }
}


// r행 c열을 몇 번째로 방문했는지 출력한다.

// 가로,세로 크기가 N인 2차원 배열을 쪼개보자. 만약 N의 크기가 2라면 return.


// (0, 0) (0, 1) (1, 0) (1, 1)
// (0, 2) (0, 3) (1, 2) (1, 3)
// (2, 0) (2, 1) (3, 0) (3, 1)
// (2, 2) (2, 3) (3, 2) (3, 3)

// (0, 4) (0, 5) (1, 4) (1, 5)
// (0, 6) (0, 7) (1, 6) (1, 7)
// (2, 4) (2, 5) (3, 4) (3, 5)
// (2, 6) (2, 7) (3, 6) (3, 7)