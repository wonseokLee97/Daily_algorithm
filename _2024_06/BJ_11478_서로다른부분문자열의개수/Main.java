package com.ssafy._2024_06.BJ_11478_서로다른부분문자열의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();
        char[] c_arr = s.toCharArray();
        int total = 0;

        HashMap<String, Integer> map = new HashMap<>();

        // 부분 문자열의 길이
        for (int i = 1; i <= len; i++) {
            // 자르고자 하는 구간
            for (int j = 0; j <= len - i; j++) {
                StringBuilder sb = new StringBuilder();
                //  자를 구간
                for (int k = j; k < j + i; k++) {
                    sb.append(c_arr[k]);
                }
                String get = sb.toString();

                if (!map.containsKey(get)) {
                    map.put(get, 1);
                    total++;
                }
            }
        }

        System.out.println(total);
    }
}

// 길이가 5인 문자열
// 1: 5 - 5/1 -> 5 + 5%1 -> 0 = 5
// 2: 4 - 5/2 -> 2 + 5%2 -> 2 = 4
// 3: 3 - 5/3 -> 1 + 5%3 -> 2 = 3
// 4: 2 - 5/4 -> 1 + 5%4 -> 1 = 2
// 5: 1 - 5/5 -> 1 + 5%5 -> 0 = 1