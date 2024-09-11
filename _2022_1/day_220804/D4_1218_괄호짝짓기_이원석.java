package com.ssafy._2022_1.day_220804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class D4_1218_괄호짝짓기_이원석 {
    public static void main(String[] args) throws IOException {
        String stacks = "([{<"; // 0, 1, 2, 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t < 11; t++) {
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            char[] chars = br.readLine().toCharArray();
            ArrayList<Character> tmp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String s = "";
                // 포함하고 있다면
                if (stacks.contains(s + chars[i])) {
                    tmp.add(chars[i]);
                } else {
                    if ((chars[i] == ')') && (tmp.get(tmp.size() - 1) == '(')) {
                        cnt++;
                        tmp.remove(tmp.size() - 1);
                    } else if ((chars[i] == ']') && (tmp.get(tmp.size() - 1) == '[')) {
                        cnt++;
                        tmp.remove(tmp.size() - 1);
                    } else if ((chars[i] == '}') && (tmp.get(tmp.size() - 1) == '{')) {
                        cnt++;
                        tmp.remove(tmp.size() - 1);
                    } else if ((chars[i] == '>') && (tmp.get(tmp.size() - 1) == '<')) {
                        cnt++;
                        tmp.remove(tmp.size() - 1);
                    } else {
                        tmp.add(chars[i]);
                    }
                }
//                System.out.println(tmp.toString() + "  " + chars[i]);
            }
            if (tmp.size() == 0) {
                System.out.printf("#%d %d %d\n", t, 1, cnt);
            } else {
                System.out.printf("#%d %d %d\n", t, 0, cnt);
            }
        }


    }
}
//16
//{[()]}<>[<{}><>]