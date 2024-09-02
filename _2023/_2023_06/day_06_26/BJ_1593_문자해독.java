package com.ssafy._2023._2023_06.day_06_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1593_문자해독 {

    static int g, sl, ans, visited[];
    static char[] pic, maya;
    static String S, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        g = Integer.parseInt(st.nextToken());
        sl = Integer.parseInt(st.nextToken());

        W = br.readLine();
        S = br.readLine();

        // 단어 W에 대한 알파벳의 개수를 저장할 HashMap
        HashMap<Character, Integer> mapW = new HashMap<>();
        // g의 길이만큼에서의 단어에 대한 알파벳의 개수를 저장할 HashMap
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < g; i++) {
            char c = W.charAt(i);

            if (mapW.get(c) == null) {
                mapW.put(c, 1);
                map.put(c, 0);
            } else {
                mapW.put(c, mapW.get(c) + 1);
            }
        }

        char s;
        char e;
        int cnt = 0;

        for (int i = 0; i < sl; i++) {
            // W 이상으로 꼬리가 길어질 경우, 앞 부분도 이동해준다. (s, e사이의 간격을 g로 유지한다.)
            if (i >= g) {
                s = S.charAt(i - g);
                if (map.get(s) != null) {
                    cnt--;
                    map.put(s, map.get(s) - 1);
                }
            }

            // 단어 W의 길이만큼 꼬리가 이동해야됨
            e = S.charAt(i);
            // 해당 S의 i번째 문자가 단어 W에 포함될 때
            if (map.get(e) != null) {
                cnt++;
                map.put(e, map.get(e) + 1);
            }


            if (cnt == g) {
                int flag = 0;

                // cAda
                for (char c : mapW.keySet()) {
                    if (mapW.get(c) != map.get(c)) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}


// cAda {c, A, d, a} 1 2 3 4

// c d A a
//

// AbrAcadAbRa