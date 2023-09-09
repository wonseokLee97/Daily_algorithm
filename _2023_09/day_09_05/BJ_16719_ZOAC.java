package com.ssafy._2023_09.day_09_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_16719_ZOAC {
    static int[] visited;
    static char[] c;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        c = br.readLine().toCharArray();
        visited = new int[c.length];
        StringBuilder sb = new StringBuilder();
        dfs(0, c.length - 1);
    }

    static void dfs(int l, int r) throws IOException {
        if (l > r) {
            return;
        }

        System.out.println(l + ", " + r + ", ");
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (c[idx] - '0' > c[i] - '0') {
                idx = i;
            }
        }

        visited[idx] = 1;

        for (int i = 0; i < c.length; i++) {
            if (visited[i] == 1) {
                bw.write(c[i]);
            }
        }

        dfs(idx + 1, r);
        dfs(l, idx);
    }
}

// ZOAC
// A
// A C
// O A C