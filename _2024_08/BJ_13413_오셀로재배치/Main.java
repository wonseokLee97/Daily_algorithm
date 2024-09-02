package com.ssafy._2024_08.BJ_13413_오셀로재배치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            char[] a = br.readLine().toCharArray();
            char[] b = br.readLine().toCharArray();

            int WB = 0;
            int BW = 0;

            for (int i = 0; i < N; i++) {
                // WB
                if (a[i] == 'W' && b[i] == 'B') {
                    WB++;
                } else if (a[i] == 'B' && b[i] == 'W') {
                    BW++;
                }
            }

            if (WB > BW) {
                System.out.println(WB);
            } else if (WB < BW) {
                System.out.println(BW);
            } else {
                System.out.println(WB);
            }
        }
    }
}

// W B B W W B W B
// W B W B W W B W
// BW:3
// WB:2

// 다른 부분
// O O ! ! O

// B B B B B B B
// B W B W B W B
// O ! O ! O ! O
// BW:3
// WB:0

// W W B B B
// B B W B W

// W W B B B
// B B W B W
// 다른 부분
// ! ! ! O
// WB:2
// BW:2
//

// 두 개를 서로 바꾸는 경우 2개가 해소된다.