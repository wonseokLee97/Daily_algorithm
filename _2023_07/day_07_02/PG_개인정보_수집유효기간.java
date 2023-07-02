package com.ssafy._2023_07.day_07_02;

import java.util.*;
import java.io.*;

class Personal {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        int[] answer = {};

        // 만기일
        int todayC = convert(today);

        // 약관
        HashMap<Character, Integer> map = new HashMap<>();

        for(String t : terms) {
            String[] tArr = t.split(" ");

            map.put(tArr[0].toCharArray()[0], Integer.parseInt(tArr[1]));
        }

        int num = 0;
        // 개인정보
        for (String p : privacies) {
            num++;

            String[] pArr = p.split(" ");
            String date = pArr[0];
            String type = pArr[1];
            char t = type.toCharArray()[0];

            // 오늘 - 시작일 >= (28 * 12) 인 경우 파기한다.
            int dateC = convert(date);

            if (todayC - dateC >= map.get(t) * 28) {
                list.add(num);
            }
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int convert(String today) {
        String[] tArr = today.split("\\.");

        int y = Integer.parseInt(tArr[0]);
        int m = Integer.parseInt(tArr[1]);
        int d = Integer.parseInt(tArr[2]);

        return y * (28 * 12) + m * 28 + d;
    }
}

// System.out.println();



// 1년 28 * 12
// 1달 28
