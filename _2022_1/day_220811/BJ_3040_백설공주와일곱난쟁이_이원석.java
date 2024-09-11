package com.ssafy._2022_1.day_220811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;

public class BJ_3040_백설공주와일곱난쟁이_이원석 {
    static int sum, flag = 0;
    static Stack<Integer> stack;
    static int[] dwarf, visited = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stack = new Stack<>();
        dwarf = new int[9];

        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        for (int i : stack) {
            System.out.println(i);
        }
    }

    public static void dfs(int r){
        if (r == 7) {
            if (sum == 100) {
                flag = 1;
            }
            return;
        }

        for (int i = r; i < 9; i++) {
            if (visited[i] == 1) {
                continue;
            }
            sum += dwarf[i];
            stack.add(dwarf[i]);
            visited[i] = 1;

            dfs(r + 1);
            if (flag == 1) {
                return;
            }

            sum -= dwarf[i];
            stack.pop();
            visited[i] = 0;
        }
    }
}
