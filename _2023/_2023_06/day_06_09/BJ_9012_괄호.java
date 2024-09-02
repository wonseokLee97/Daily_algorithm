package com.ssafy._2023._2023_06.day_06_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 소요시간 15분
public class BJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();
            System.out.println(VPS(arr));
        }
    }

    public static String VPS(char[] arr) {

        Stack<Character> vps = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (vps.size() == 0) {
                vps.add(c);
                continue;
            }

            Character peek = vps.peek();

            // VPS 인 경우 애니팡
            if (peek == '(' && c == ')') {
                vps.pop();
            } else {
                vps.add(c);
            }
        }

        if (vps.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
