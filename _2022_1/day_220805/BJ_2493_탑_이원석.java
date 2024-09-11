package com.ssafy._2022_1.day_220805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {
    int h;
    int index;

    public Top(int h, int index) {
        this.h = h;
        this.index = index;
    }
}

public class BJ_2493_탑_이원석 {
    static Stack<Top> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stack = new Stack<>();

        StringBuilder sb = new StringBuilder("");
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) { // 스택이 비어있다면 push + "0"
                stack.push(new Top(h, i + 1));
                sb.append("0 ");

            } else { // 그렇지 않다면
                while (true) { // 반복한다
                    if (stack.isEmpty()) { // 스택이 비어있다면 push + "0"
                        sb.append("0 ");
                        stack.push(new Top(h, i + 1));
                        break;
                    }

                    // 가장 마지막에 있는 탑의 정보
                    Top before = stack.get(stack.size() - 1);

                    if (h < before.h) {
                        // 마지막 탑의 높이가, 새로 들어온 탑 보다 크다면
                        // 그 마지막 탑의 인덱스 + 스택에 push
                        sb.append(before.index + " ");
                        stack.push(new Top(h, i + 1));
                        break;
                    } else { // 그렇지 않다면 pop 한다. - 스택이 비거나, 더 높은 탑을 찾을 때 까지
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
//5
//6 9 5 7 4

//6
//9 4 6 3 7 8

//10
//2 9 3 8 7 4 6 5 1 10

//5
//2 4 1 3 5

//5
//1 2 3 4 5

//6
//7 4 9 3 6 8