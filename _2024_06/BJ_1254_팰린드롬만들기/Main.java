package com.ssafy._2024_06.BJ_1254_팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int L = s.length();
        int flag = 0;
        char[] s_arr = s.toCharArray();

        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < L; i++) {
            sb1.append(s_arr[i]);

            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            for (int j = i - 1; j >= 0; j--) {
                sb2.append(s_arr[j]);
            }

            for (int j = i; j >= 0; j--) {
                sb3.append(s_arr[j]);
            }

            StringBuilder ans1 = new StringBuilder();
            ans1.append(sb1);
            ans1.append(sb2);

            StringBuilder ans2 = new StringBuilder();
            ans2.append(sb1);
            ans2.append(sb3);

            if (ans1.toString().contains(s)) {
                System.out.println(ans1.toString().length());
                break;
            } else if (ans2.toString().contains(s)) {
                System.out.println(ans2.toString().length());
                break;
            }
        }
    }
}

// abdfhdyrbdbsdfghjk[l]
// kjhgfdsbdbrydhfdba

// abcdefghijabcdefghijabcdefghijabcdefghijabcdefghij

// abdfhdyrbdbsdfghjklkjhgfdsbdbrydhfdba

// abab
// a-a (x)
// ab-ba (x)
// aba-aba contains?yes


// 전달받은 문자열의 길이가 N일때, N/2까지만 받으면 됨
// ex) 길이가 4일 때