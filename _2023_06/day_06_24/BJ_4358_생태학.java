package com.ssafy._2023_06.day_06_24;

import java.io.*;
import java.util.*;


public class BJ_4358_생태학 {

    static String specie = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<String> list = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        int total = 0;

        while((specie = br.readLine()) != null && specie.length() > 0) {
            if (map.get(specie) == null) {
                map.put(specie, 1);
            } else {
                map.put(specie, map.get(specie) + 1);
            }
        }

        for (String key : map.keySet()) {
            list.add(key);
            total += map.get(key);
        }

        Collections.sort(list);

        for (String key : list) {
            int cnt = map.get(key);
            float per = (float) cnt * 100 / total;
            System.out.printf("%s %.4f\n", key, per);
        }
    }
}

// 단순 구현문제
// 컬렉션 프레임워크, 그리고 정렬의 활용능력과
// printf 를 통한 소숫점 자리수 단위의 출력을 할 수 있는가? 에 대한 문제