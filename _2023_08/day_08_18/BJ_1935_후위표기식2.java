package com.ssafy._2023_08.day_08_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BJ_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        char[] input = br.readLine().toCharArray();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        for (char i : input) {
            if (i - 'A' >= 0) {
                stack.push((double) arr[i - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                switch (i) {
                    case '*':
                        stack.push(a * b);
                        continue;
                    case '+':
                        stack.push(a + b);
                        continue;
                    case '/':
                        stack.push(a / b);
                        continue;
                    case '-':
                        stack.push(a - b);
                        continue;
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}

// 123* 45 / -

// 1 2 3
// 1
// 1 6