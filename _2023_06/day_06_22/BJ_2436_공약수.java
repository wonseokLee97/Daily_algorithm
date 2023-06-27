package com.ssafy._2023_06.day_06_22;

import java.util.*;
import java.io.*;

public class BJ_2436_공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= Y; i++) {
            if (Y % i == 0) {
                System.out.println(i);
            }
        }
    }
}

// 최대 공약수 = 6, 최소 공배수 = 180
// 1 2 3 6를 약수로 가지고있고,
// 180을 배수로 가지고있는 수.
// 180을 분해해보자. => 1, 2, 3, 6