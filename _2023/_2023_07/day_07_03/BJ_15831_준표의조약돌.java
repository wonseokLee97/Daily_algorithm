package com.ssafy._2023._2023_07.day_07_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15831_준표의조약돌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int max_val = Integer.MIN_VALUE;

        char[] stone = br.readLine().toCharArray();

        int s = 0;
        int e = 0;

        int takeB = 0;
        int takeW = 0;

        while (e < N) {
            // 검은색 조약돌이 기준에 적합할 경우
            if (takeB <= B) {
                if (stone[e] == 'B') {
                    takeB++;
                } else {
                    takeW++;
                }
                e++;

            } else {
                if (stone[s] == 'B') {
                    takeB--;
                } else {
                    takeW--;
                }
                s++;
            }

            // 흰색 조약돌이 기준에 적합할 경우
            if (takeW >= W && takeB <= B) {
                // 조건을 만족하는 경우 최대길이 갱신
                max_val = Math.max(e - s, max_val);
            }

        }

        if (max_val == Integer.MIN_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(max_val);
        }
    }
}

// 현재 길이까지의 조약돌 중, 검은색이 B개 이하라면?
// 계속해서 전진
// B개 초과라면? 시작점을 이동

// W, WB, WBB, WBBW, WBBWW, WBBWWB(!), BBWWB, BWWB, BWWBW, WWBW
