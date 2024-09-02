package com.ssafy._2024_04.BJ_13413_오셀로재배치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[] f_arr = br.readLine().toCharArray();
            char[] s_arr = br.readLine().toCharArray();

            int wb = 0;
            int bw = 0;

            for (int i = 0; i < N; i++) {
                if (f_arr[i] == s_arr[i]) {
                    continue;
                }

                if (f_arr[i] == 'W' && s_arr[i] == 'B') {
                    wb++;
                } else if (f_arr[i] == 'B' && s_arr[i] == 'W') {
                    bw++;
                }
            }

            // ex) 4, 2 라면..
            // 1. 둘 중 최솟값 2를 쌍으로 스와핑 해야한다.
            // 2. 남은 2개는 알을 뒤집어야 한다. |wb - bw|
            int ans = Math.min(wb, bw) + Math.abs(wb - bw);

            System.out.println(ans);
        }
    }
}

// WWBB
// BBWB

// 서로 다른 쌍을 찾아주자. 이들은 서로 1바꾸는 1번이다.
// W B
// B W

// 모두 바꾸고 남은 것들은 2번으로 처리