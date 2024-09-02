package com.ssafy._2023._2023_08.day_08_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        // 문자열 W
        String sw = br.readLine();
        char[] W = sw.toCharArray();
        // 정수 K
        int K = Integer.parseInt(br.readLine());

        int[] alpha = new int[26];

        // 특정 문자를 K개 중복하는 가장 짧은 연속 문자열의 길이
        for (int i = 0; i < W.length; i++) {
            alpha[W[i] - 'a']++;
        }

        System.out.println(Arrays.toString(alpha));
    }
}
