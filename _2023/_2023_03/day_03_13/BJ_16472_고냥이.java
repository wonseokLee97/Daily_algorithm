package com.ssafy._2023._2023_03.day_03_13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BJ_16472_고냥이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String next = sc.next();
        int[] alpha = new int[26];

        int s = 0;
        int e = 0;
        int cnt = 0;

        int max_val = Integer.MIN_VALUE;

        while (e < next.length()) {
            if (alpha[next.charAt(e++) - 'a']++ == 0) {
                cnt++;
            }

            while (cnt > N && s < e) {
                if (--alpha[next.charAt(s++) - 'a'] == 0) {
                    cnt--;
                }
            }

            max_val = Math.max(max_val, e - s);
        }

        System.out.println(max_val);
    }
}

//          for (int i = s; i < e; i++) {
//                cnt++;
//                set.add(alpha.charAt(i));
//            }
//
//            if (set.size() <= N) {
//                max_val = Math.max(max_val, cnt);
//                e++;
//            } else {
//                s++;
//            }