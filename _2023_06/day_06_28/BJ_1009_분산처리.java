package com.ssafy._2023_06.day_06_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BJ_1009_분산처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a % 10 == 0) {
                System.out.println(10);
                continue;
            }

            int pow = a % 10;

            for (int j = 0; j < b - 1; j++) {
                pow = (pow * a) % 10;
            }

            sb.append(pow + "\n");
        }
        System.out.println(sb);
    }
}

// 3 9 27 81 243 729 2187
//2
//10 2
//20 1
