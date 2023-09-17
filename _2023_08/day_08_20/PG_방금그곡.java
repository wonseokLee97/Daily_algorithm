package com.ssafy._2023_08.day_08_20;

import java.util.*;


public class PG_방금그곡 {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(
                "abcdef",
                new String[] {
                        "00:00,00:05,HELLO,abcdef",
                }
        ));
    }
}

class Music implements Comparable<Music> {
    int cnt;
    int time;
    String music;

    public Music (int cnt, int time, String music) {
        this.cnt = cnt;
        this.time = time;
        this.music = music;
    }

    @Override
    public String toString() {
        return "Music{" +
                "cnt=" + cnt +
                ", time=" + time +
                ", music='" + music + '\'' +
                '}';
    }

    @Override
    public int compareTo(Music o) {
        // 시간에 대해서는 내림차순, 입력 순서에 대해서는
        if (Integer.compare(o.time, this.time) == 0) {
            return Integer.compare(this.cnt, o.cnt);
        } else {
            return Integer.compare(o.time, this.time);
        }
    }
}

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        List<Music> list = new ArrayList<>();
        int cnt = 0;

        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

        for (String get : musicinfos) {
            String[] arr = get.split(",");
            String[] startArr = arr[0].split(":");
            String[] endArr = arr[1].split(":");

            int s = Integer.parseInt(startArr[0]) * 60 + Integer.parseInt(startArr[1]);
            int e = Integer.parseInt(endArr[0]) * 60 + Integer.parseInt(endArr[1]);
            int playTime = e - s;
            int musicTime = arr[3].length();
            StringBuilder sb = new StringBuilder();

            char[] getChar = arr[3].toCharArray();

            if (musicTime < playTime) {
                for (int i = 0; i < playTime / musicTime; i++) {
                    sb.append(arr[3]);
                }

                for (int i = 0; i < playTime % musicTime; i++) {
                    sb.append(getChar[i]);
                }

            } else {
                for (int i = 0; i < playTime; i++) {
                    sb.append(getChar[i]);
                }
            }

            String result = sb.toString();
            result = result.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

            System.out.println(result);
            System.out.println(m);

            if (result.contains(m)) {
                list.add(new Music(cnt++, playTime, arr[2]));
            }
        }

        Collections.sort(list);
        System.out.println(list);

        if (list.size() == 0) {
            answer = "(None)";
        } else {
            answer = list.get(0).music;
        }

        return answer;
    }
}

// 5 10 15
// 6 12

// 음악이 진행된 시간보다 음악의 길이가 작다면?
// 진행된 시간에 맞춰 음악의 길이를 반복함

// 음악이 진행된 시각보다 음악의 길이가 길다면?
// 진행된 시간 만큼만 들려줌

// C#DEFGAB
// C# D E F G A B