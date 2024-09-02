package com.ssafy._2024_07.BJ_20114_미아노트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        // N*W

        char[] origin = new char[N*W];
        Arrays.fill(origin, ' ');
        for (int i = 0; i < H; i++) {
            char[] arr = br.readLine().toCharArray();

            for (int j = 0; j < N * W; j++) {
                if (arr[j] == '?') {
                    continue;
                }
                origin[j] = arr[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char c = '-';
            for (int j = i * W; j < i * W + W; j++) {
                if (origin[j] == ' ') {
                    continue;
                }

                c = origin[j];
                break;
            }

            if (c != '-') {
                sb.append(c);
            } else {
                sb.append("?");
            }
        }

        System.out.println(sb);
    }
}

//  012  345  678  ...
// [f?f][rrr][uuu][???][ttt][???]

// abc - H:3, W:2
// aabbcc
// aabbcc
// aabbcc

//
// a?????
// ???bcc

// a??bcc
// a??bcc

// H:2, W:3
// ???rrruuu???ttt???
// f?f?rruuu?????t???