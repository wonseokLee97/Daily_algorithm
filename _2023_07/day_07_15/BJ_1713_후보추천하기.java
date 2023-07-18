package com.ssafy._2023_07.day_07_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_1713_후보추천하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (list.size() == N && !list.contains(next)) {
//                System.out.println(next);
                int min_val = Integer.MAX_VALUE;
                // 추천받은 횟수가 같은
                for (int student : list) {
                    min_val = Math.min(min_val, map.get(student));
                }

                for (int j = 0; j < list.size(); j++) {
//                    System.out.println(list.get(j));
                    if (map.get(list.get(j)) == min_val) {
                        map.put(list.get(j), 0);
                        list.remove(j);
                        break;
                    }
                }
            }

            if (map.get(next) == null) {
                map.put(next, 1);
            } else {
                map.put(next, map.get(next) + 1);
            }

            if (map.get(next) != null) {
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int student : list) {
            sb.append(student + " ");
        }

        System.out.println(sb);
    }
}

// [0, 0, 0, 0, 0, 0, 0, 0, 0]

// 6 7 2

// 제일 오래된 친구를 알아야 한다.
// 해쉬맵을 쓰자.

// 1 4 3 / 3
// 4 3 5 / 5
// 3 5 6 / 6
// 5 6 2 / 2
// 6 2 7 / 7
