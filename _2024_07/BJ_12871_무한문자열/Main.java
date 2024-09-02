package com.ssafy._2024_07.BJ_12871_무한문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        // 3, 6
        if (s.length() < t.length()) {
            for (int i = 0; i <= s.length() * (t.length() / s.length() + t.length() % s.length()); i++) {
                int sIdx = i % s.length();
                int tIdx = i % t.length();
                if (sArr[sIdx] != tArr[tIdx]) {
                    System.out.println(0);
                    return;
                }
            }
        } else if (s.length() >= t.length()) {
            for (int i = 0; i <= t.length() * (s.length() / t.length() + s.length() % t.length()); i++) {
                int sIdx = i % s.length();
                int tIdx = i % t.length();
                if (sArr[sIdx] != tArr[tIdx]) {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(1);
        return;
    }
}

// abcabc
// bcabca

// abc
// abcd

//aacabf
//aacabfaacabfa