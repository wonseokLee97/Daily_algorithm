package com.ssafy._2024_08.BJ_1316_그룹단어체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            Set<Character> set = new HashSet<>();
            int flag = 0;
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < cArr.length; j++) {
                if (j >= 1 && cArr[j] == cArr[j - 1]) {
                    continue;
                }

                if (!set.contains(cArr[j])) {
                    set.add(cArr[j]);
                } else {
                    // 연속된 단어가 아닌 경우
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
