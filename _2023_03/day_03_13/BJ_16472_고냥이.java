package com.ssafy._2023_03.day_03_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_16472_고냥이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String alpha = sc.next();

        int s = 0;
        int e = 1;
        int max_val = Integer.MIN_VALUE;

        while (s <= e && e <= alpha.length()) {
            HashSet<Character> set = new HashSet<>();
            int cnt = 0;

//            System.out.println(s + ", " + e);

            for (int i = s; i < e; i++) {
                cnt++;
                set.add(alpha.charAt(i));
            }

            if (set.size() <= N) {
                max_val = Math.max(max_val, cnt);
                e++;
            } else {
                s++;
            }
        }

        System.out.println(max_val);
    }
}