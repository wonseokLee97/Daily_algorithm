package com.ssafy._2022_1.day_220811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJ_2961_도영이가만든맛있는음식_이원석 {
    static int sour_taste, bitter_taste, min_val, n;
    static int[] sour, bitter, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sour = new int[n];
        bitter = new int[n];
        visited = new int[n];
        min_val = Integer.MAX_VALUE;
        bitter_taste = 0;
        sour_taste = 1;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(min_val);
    }

    public static void dfs(int r) {
        if (r == n) {
            return;
        }

        for (int i = r; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = i + 1;
            sour_taste *= sour[i];
            bitter_taste += bitter[i];
            System.out.println(Arrays.toString(visited));

            min_val = Math.min((Math.abs(sour_taste - bitter_taste)), min_val);
            dfs(r + 1);
            visited[i] = 0;
            sour_taste /= sour[i];
            bitter_taste -= bitter[i];
        }
    }
}


// 1, 2, 3, 4
// 1, 2, 3
// 1, 2
// 1
// 2, 3 ,4
// 2, 3
// 2
// 3, 4
// 3
// 4
