package com.ssafy._2022_1._2022_09.day_220904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1092_배_이원석 {
    static int N, M;
    static ArrayList<Integer> box, crane;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 크레인
        crane = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(crane, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine()); // 박스
        box = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(box, Collections.reverseOrder());
        System.out.println(move());
    }

    public static int move() {
        int cnt = 0;

        // 박스의 최대값이 크레인의 최대값 보다 큰 경우는
        if (crane.get(0) < box.get(0)) {
            return -1;
        }

        while (box.size() != 0) {
            cnt++;
            // 크레인을 기준으로 M 개만큼의 박스를 loop
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < box.size(); j++) {
                    // 무게 허용치보다 작거나 같은 박스만 옮긴다.
                    if (box.get(j) <= crane.get(i)) {
                        box.remove(j);
                        break;
                    }
                }
            }
        }

        return cnt;
    }
}

//3
//10 6 5
//11
//6 8 9 6 8 6 9 6 8 6 9