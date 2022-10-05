package com.ssafy._2022_09.day_220920;

import com.sun.jdi.Value;

import java.util.HashMap;

public class PG_베스트앨범_이원석 {
    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(plays[i], 0));
        }

        for (String s : map.keySet()) {
            System.out.println(s + ", " + map.get(s));
        }

//        solution(genres, plays);
    }

    public static int[] solution(String[] genres, int[] plays) {


        int[] answer = {};
        return answer;
    }
}


