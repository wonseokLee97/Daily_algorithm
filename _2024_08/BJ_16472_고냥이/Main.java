package com.ssafy._2024_08.BJ_16472_고냥이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = Integer.MIN_VALUE;
        char[] cArr = br.readLine().toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();


        int s = 0;
        int e = 0;
        int cnt = 1;

        if (cArr.length == 1) {
            System.out.println(1);
            return;
        }

        map.put(cArr[0], 1);

        while (s <= e) {
            if (cnt <= N && e < cArr.length - 1) {
                e++;
                // 알파벳의 종류가 추가되는 경우
                if (!map.containsKey(cArr[e])) {
                    map.put(cArr[e], 1);
                    cnt++;
                } else {
                    // 기존에 없던 알파벳인 경우에만 종류를 증가시킨다.
                    if (map.get(cArr[e]) == 0) {
                        cnt++;
                    }

                    map.put(cArr[e], map.get(cArr[e]) + 1);
                }

            } else {
                // 알파벳의 종류가 제거되는 경우
                map.put(cArr[s], map.get(cArr[s]) - 1);
                if (map.get(cArr[s]) == 0) {
                    cnt--;
                }

                System.out.println(map.get(cArr[s]));
                s++;
            }

            StringBuilder sb = new StringBuilder();
            System.out.println(s + ", " + e + " - " + cnt);
            for (int i = s; i <= e; i++) {
                sb.append(cArr[i]);
            }
            System.out.println(sb);
            System.out.println();


            // 알파벳의 종류가 N개인 경우
            if (cnt <= N) {
                ans = Math.max(ans, e - s + 1);
            }
        }

        System.out.println(ans);
    }
}

//       s
// a b b c a c c b a
//             e

// N개 이하의 종류면 e++
// N개 초과의 종류면 s++