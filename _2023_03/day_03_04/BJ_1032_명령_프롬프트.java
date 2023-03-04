package com.ssafy._2023_03.day_03_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1032_명령_프롬프트 {
    static char[] val;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char[] fileName = br.readLine().toCharArray();

            if (i == 0) {
                val = new char[fileName.length];

                for (int j = 0; j < fileName.length; j++) {
                    val[j] = fileName[j];
                }
                continue;
            }

            for (int j = 0; j < fileName.length; j++) {
                if (val[j] == '?') {
                    continue;
                }

                if (val[j] != fileName[j]) {
                    val[j] = '?';
                } else {
                }
            }
        }

        String ans = "";
        for (char c : val) {
            ans += c;
        }

        System.out.println(ans);
    }
}

// c.user.mike.programs
// c.user.?ike.programs
// c.user.?i?e.programs
// 처음에는 일단 저장하자.
//

//            System.out.println(i);
//
//            for (int j = 0; j < fileName.length; j++) {
//                System.out.print(val[j]);
//            }
//            System.out.println();