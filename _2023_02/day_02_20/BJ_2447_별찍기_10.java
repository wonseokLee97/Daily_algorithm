package com.ssafy._2023_02.day_02_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2447_별찍기_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        star(Integer.parseInt(br.readLine()));
    }

    // 3 -  3 / 3 인덱스는 빈칸!! ex) (3/3, 3/3) * 3/3
    // 9 - ex) (9/3, 9/3) * 9/3
    // 27 - ex) (27/3, 27/3) * 27/3

    public static void star(int N) {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i % 3 == 1 && j % 3 == 1) {
                    for (int k = N / 3; k < i / 4; k++) {

                    }
                }
            }
        }

    }
}
