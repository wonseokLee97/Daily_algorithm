package com.ssafy.toss;

import java.util.*;

public class po1 {
    static int N, visited[], numbers[], max_val;
    static String s;
    public static void main(String[] args) {
        N = 2;
        s = "1451232125";
        max_val = Integer.MIN_VALUE;

        visited = new int[N];
        numbers = new int[N];

        dfs(0);

        System.out.println(max_val);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            val(numbers);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            numbers[cnt] = i + 1;
            visited[i] = 1;
            dfs(cnt + 1);
            visited[i] = 0;
        }

    }

    public static void val(int[] numbers) {
        String d = "";

        for (int i : numbers) {
            d += i;
        }

        if (s.contains(d)) {
            int get = Integer.parseInt(d);

            max_val = Math.max(max_val, get);
        }

    }
}
