package com.ssafy.day_220812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;


public class BJ_1541_잃어버린괄호_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] abs = br.readLine().split("-");
        Stack<Integer> stack = new Stack();
        int result = 0;

        for (String a : abs) {
            int total = 0;
            String[] split = a.split("\\+");
            for (String s : split) {
                total += Integer.valueOf(s);
            }
            stack.add(total);
        }

        for (int i = 0; i < stack.size(); i++) {
            if (i == 0) {
                result += stack.get(i);
            } else {
                result -= stack.get(i);
            }
        }

        System.out.println(result);
    }
}

// 55 , 50+40
// 55 , [50 , 40]