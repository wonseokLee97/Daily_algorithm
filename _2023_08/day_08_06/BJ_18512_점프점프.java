package com.ssafy._2023_08.day_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_18512_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // 뛰는 거리
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 시작 지점
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int ans = 0;
        int cnt = 0;

        List<Integer> list = new ArrayList<>();

        while (true) {
            if (cnt >= 10000) {
                break;
            }

            if (list.contains(p1)) {
                ans = p1;
                break;
            } else {
                list.add(p1);
            }

            if (list.contains(p2)) {
                ans = p2;
                break;
            } else {
                list.add(p2);
            }

            p1 += x;
            p2 += y;
            cnt++;
        }

        if (ans == 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}


// p1 + x ... 과 p2 + y... 의 최소 공배수를 구해라.
// 30 40 50 60 70 80 90 100..
// 8  20 32 44 56 68 80 92

// 12와 10의 최소공배수는? 60
//