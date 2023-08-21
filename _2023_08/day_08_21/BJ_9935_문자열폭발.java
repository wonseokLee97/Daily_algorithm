package com.ssafy._2023_08.day_08_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String explore = br.readLine();
        boolean flag;

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);

            if (sb.length() >= explore.length()) {
                flag = true;

                for (int j = 0; j < explore.length(); j++) {
                    char c1 = sb.charAt(sb.length() - explore.length() + j);
                    char c2 = explore.charAt(j);

                    if (c1 != c2) {
                        flag = false;
                        break;
                    }
                }

                // 폭발시킬 문자열을 찾았다면, 전체 문자열 길이 - 폭발 시킬 문자열 길이 ~ 전체 문자열 길이의 범위까지 삭제시킨다.
                if (flag) {
                    sb.delete(sb.length() - explore.length(), sb.length());
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
