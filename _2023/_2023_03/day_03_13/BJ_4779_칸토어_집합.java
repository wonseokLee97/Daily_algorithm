package com.ssafy._2023._2023_03.day_03_13;

import java.util.Scanner;

public class BJ_4779_칸토어_집합 {
    static StringBuilder ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            int k = (int) Math.pow(3, N);
            ans = new StringBuilder();

            for (int i = 0; i < k; i++) {
                ans.append("-");
            }

            kanto(0, k);
            System.out.println(ans);
        }
    }

    // 0 9 18 27
    // 0, 27
    //

    private static void kanto(int s, int e) {
        if (e - s == 1) {
            return;
        }

        int v = (e - s) / 3;

        for (int i = s; i < e; i++) {
            if (i >= s + v && i < e - v) {
                ans.setCharAt(i, ' ');
            }
        }

        kanto(s, s + v);
        kanto(e - v, e);
    }
}
