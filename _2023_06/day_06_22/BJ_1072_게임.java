package com.ssafy._2023_06.day_06_22;

import java.util.*;
import java.io.*;

public class BJ_1072_게임 {
    static long X, Y, o;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        o = Y * 100 / X;

        long start = 0;
        long end = Integer.MAX_VALUE;

        // 이분탐색은 그냥 다 long타입으로 때려박아라
        // upper bound
        while (start < end) {
            long mid = (start + end) / 2;
//            System.out.println("s: " + start + ", e: " + end + ", mid: " + mid);

            // Z가 변했다면
            if (check(mid)) {
                end = mid;
            }
            // Z가 변하지 않았다면? mid 를 올려야지
            else {
                start = mid + 1;
            }
        }

        if (end == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(end);
        }
    }

    public static boolean check(long mid) {
        long checkX = X + mid;
        long checkY = Y + mid;

        if (checkY * 100 / checkX != o) {
//            System.out.println(checkX + ", " + checkY + ", " + (checkY * 100 / checkX));
            return true;
        }
        return false;
    }
}

// 몇 판을 더 해야지 Z가 바뀌는가..
//