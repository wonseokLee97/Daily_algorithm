package com.ssafy._2024.algorithm;

import java.util.Arrays;

public class Combination {
    static int N, visited[];
    public static void main(String[] args) {
        N = 3;
        visited = new int[5];

        comb(0, 0);
    }

    static void comb(int start, int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(visited));
            return;
        }

        for (int i = start; i < 5; i++) {
            visited[i] += 1;
            comb(i, cnt + 1);
            visited[i] -= 1;
        }
    }
}
