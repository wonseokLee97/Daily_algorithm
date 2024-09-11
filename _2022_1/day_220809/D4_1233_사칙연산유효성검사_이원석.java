package com.ssafy._2022_1.day_220809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1233_사칙연산유효성검사_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String validate = "*-/+";


        // TC
        for (int t = 1; t < 11; t++) {
            int N = Integer.parseInt(br.readLine());
            int flag = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int TC = Integer.parseInt(st.nextToken()); // index

                if (validate.contains(st.nextToken())) { // 기호
                    if (st.countTokens() != 2) { // 남은 입력값이 2개가 아니면
                        flag = 1;
                        continue;
                    }
                } else { // 숫자인데 길이가 2를 초과할 경우
                    if (st.countTokens() >= 1) {
                        flag = 1;
                        continue;
                    }
                }
            }

            // validation
            if (flag == 1) {
                System.out.println("#" + t + " " + 0);
            } else {
                System.out.println("#" + t + " " + 1);
            }
        }
    }
}
