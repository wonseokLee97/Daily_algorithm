package com.ssafy._2023._2023_03.day_03_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1484_다이어트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        long s = 1;
        long e = 2;
        List<Long> ans = new ArrayList<>();

        while (s < e) {
            long ps = s*s;
            long pe = e*e;

            if (pe - ps == G) {
                ans.add(e);
            }

            // 차이가 G보다 클 경우..
            if (pe - ps > G) {
                s++;
            } else {
                e++;
            }
        }


        if (ans.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(ans);
            for (Long an : ans) {
                System.out.println(an);
            }
        }
    }
}


// G 킬로그램이란?
// 성원이의 현재 몸무게 : x
// 성원이가 기억한 몸무게 : y
// x^2 - y^2

// G 가 15인 경우..
// 16 - y^2 = 15
// y = 1

// 64 - y^2 = 15
// y^2 = 49
// y = 7

// 현재 몸무게 x의 제곱에서 y의 제곱을 뺏을 때 G 킬로그램이 나와야 한다.

// 1. x의 제곱은 G보다 커야한다.
// 2. x의 제곱 - y의 제곱은 G와 같아야 한다.