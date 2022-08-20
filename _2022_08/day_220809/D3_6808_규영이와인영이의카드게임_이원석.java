package com.ssafy.day_220809;

import javax.print.MultiDocPrintService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D3_6808_규영이와인영이의카드게임_이원석 {
    static int[] my_card;
    static int[] e_card;
    static int my_score;
    static int e_score;
    static int win;
    static int lose;
    static int[] new_card = new int[9];
    static int[] visited = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int t = 1; t < TC + 1; t++) {
            win = 0;
            lose = 0;

            my_card = new int[9];
            e_card = new int[9];
            int cnt = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 9; i++) {
                e_card[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 18; i++) {
                int flag = 0;
                for (int j = 0; j < 9; j++) {
                    if (e_card[j] == i + 1) {
                        flag = 1;
                        break;
                    }
                }

                if (flag != 1) {
                    my_card[cnt++] = i + 1;
                }
            }
            check(0);

            System.out.printf("#%d %d %d\n", t, win, lose);
        }
    }

    public static void check(int round){
        if (round == 9) {
            validate();
            return;
        }
        // 첫 번째 라운드에서 내가 이기는 경우, 지는 경우를 재귀로 구한다.
        for (int i = 0; i < 9; i++) {
            if (visited[i] == 1) {
                continue;
            }
            new_card[round] = my_card[i];
            visited[i] = 1;
            check(round + 1);
            visited[i] = 0;
        }
    }

    public static void validate() {
        my_score = 0;
        e_score = 0;

        for (int i = 0; i < 9; i++) {
            if (new_card[i] > e_card[i]) {
                my_score += new_card[i] + e_card[i];
            } else if (new_card[i] < e_card[i]) {
                e_score += new_card[i] + e_card[i];
            } else {
                continue;
            }
        }

        if (my_score < e_score) {
            win += 1;
        } else {
            lose += 1;
        }
    }
}
//
//1
// 2 4 6 8 10 12 14 16 18
// 2 4 6 8 10 12 14 16
// 2 4 6 8 10 12 14 18 16