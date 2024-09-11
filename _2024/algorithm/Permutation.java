package com.ssafy._2024.algorithm;

import java.util.Arrays;

public class Permutation {
    static int N, visited[], permCnt[];
    public static void main(String[] args) {
        N = 5;
        visited = new int[5];
        permCnt = new int[5];

        perm(0);
    }

    static void perm(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(permCnt));
            return;
        }

        for (int i = 0; i < 5; i++) {
            permCnt[cnt] = i + 1;
            visited[i] = 1;
            perm(cnt + 1);
            visited[i] = 0;
        }
    }
}