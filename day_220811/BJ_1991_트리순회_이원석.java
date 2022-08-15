package com.ssafy.day_220811;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_1991_트리순회_이원석 {
    static StringBuilder sb;
    static char[][] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        list = new char[N][];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = st.nextToken().charAt(0) - 65;
            char LC = st.nextToken().charAt(0);
            char RC = st.nextToken().charAt(0);
            list[P] = new char[]{LC, RC};
        }

        // 전위
        sb = new StringBuilder();
        pre_order((char) (65), 0);
        System.out.println(sb);

        // 중위
        sb = new StringBuilder();
        in_order((char) (65), 0);
        System.out.println(sb);

        // 후위
        sb = new StringBuilder();
        post_order((char) (65), 0);
        System.out.println(sb);
    }

    public static void pre_order(char root, int i) {
        sb.append(root);
        char left_child = list[i][0];
        char right_child = list[i][1];

        if ((left_child != '.')) {
            pre_order(left_child, left_child - 65); // left_child
        }

        if ((right_child != '.')) {
            pre_order(right_child, right_child - 65);
        }
    }

    public static void in_order(char root, int i) {
        char left_child = list[i][0];
        char right_child = list[i][1];


        if ((left_child != '.')) {
            in_order(left_child, left_child - 65); // left_child
        }
        sb.append(root);
        if ((right_child != '.')) {
            in_order(right_child, right_child - 65);
        }
    }

    public static void post_order(char root, int i) {
        char left_child = list[i][0];
        char right_child = list[i][1];

        if ((left_child != '.')) {
            post_order(left_child, left_child - 65); // left_child
        }
        if ((right_child != '.')) {
            post_order(right_child, right_child - 65);
        }
        sb.append(root);
    }
}
