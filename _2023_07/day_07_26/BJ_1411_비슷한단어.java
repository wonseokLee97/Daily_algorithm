package com.ssafy._2023_07.day_07_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1411_비슷한단어 {
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                check(arr[i], arr[j]);
            }
        }

        System.out.println(total);
    }

    static void check(String A, String B) {
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        // 사용된 것
        HashMap<Character, Character> used = new HashMap<>();
        // 변경할 것
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < A.length(); i++) {
            if (map.get(charA[i]) == null) {
                map.put(charA[i], charB[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charA.length; i++) {
            char change = map.get(charA[i]);

            // a -> b, a -> b 는 되는데
            // a -> b, b -> b 는 안됨
            if (used.get(change) == null) {
                used.put(change, charA[i]);
                sb.append(change);
            } else if (used.get(change) != null) {
                if (used.get(change) == charA[i]) {
                    sb.append(change);
                } else {
                    return;
                }
            }
        }

        A = sb.toString();
        if (A.equals(B)) {
            total++;
        }
    }
}

// aa -> bb
// aa -> cc
// ab -> bb (x)
// a를 b로 바꾸면, b는 b로 바꿀 수 없다.
// ab -> cd
// bb -> cc