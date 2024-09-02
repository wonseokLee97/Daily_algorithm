package com.ssafy._2023._2023_07.day_07_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            HashMap<String, Integer> map = new HashMap<>();
            int flag = 0;
            int n = Integer.parseInt(br.readLine());
            String[] phoneN = new String[n];

            for (int i = 0; i < n; i++) {
                phoneN[i] = br.readLine();
                map.put(phoneN[i], 1);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < phoneN[i].length(); j++) {
                    //
                    if (map.containsKey(phoneN[i].substring(0, j))) {
                        flag = 1;
                        break;
                    }
                }
            }

//            // 저장된 문자열들 중..
//            for (String key : map.keySet()) {
//                for (int i = 0; i < n; i++) {
//                    if (phoneN[i].equals(key)) {
//                        continue;
//                    }
//
//                    if (phoneN[i].contains(key)) {
//                        flag = 1;
//                        break;
//                    }
//                }
//            }

            if (flag == 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
