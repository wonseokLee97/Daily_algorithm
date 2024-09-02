package com.ssafy._2023._2023_07.day_07_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1251_단어나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String s = br.readLine();

        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                System.out.println(i + ", " + j);
                char[] first = s.substring(0, i).toCharArray();
                char[] second = s.substring(i, j).toCharArray();
                char[] third = s.substring(j, s.length()).toCharArray();

                StringBuilder total = new StringBuilder();

                for (int k = first.length - 1; k >= 0; k--) {
                    total.append(first[k]);
                }

                for (int k = second.length - 1; k >= 0; k--) {
                    total.append(second[k]);
                }

                for (int k = third.length - 1; k >= 0; k--) {
                    total.append(third[k]);
                }

                list.add(total.toString());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
