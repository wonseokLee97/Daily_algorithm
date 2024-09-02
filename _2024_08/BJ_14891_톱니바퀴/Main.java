package com.ssafy._2024_08.BJ_14891_톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Pos {
    int s;
    int e;

    Pos(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {
    static int arr[][], visited[];
    static List<Pos> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[4][8];
        list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char[] cArr = br.readLine().toCharArray();
            list.add(new Pos(0, 7));
            for (int j = 0; j < 8; j++) {
                arr[i][j] = cArr[j] - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            visited = new int[4];
            st = new StringTokenizer(br.readLine());
            // t번의 톱니바퀴를 w방향(1:시계, -1:반시계)으로 회전
            int t = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            visited[t - 1] = 1;
            play(t - 1, w);
        }


        int idx = 0;
        int total = 0;
        int[] score = new int[] {1, 2, 4, 8};
        for (Pos pos : list) {
            int a;

            if (pos.s % 8 < 0) {
                a = pos.s % 8 + 8;
            } else {
                a = pos.s % 8;
            }

            if (arr[idx][a] == 1) {
                total += score[idx];
            }

            idx++;
        }

        System.out.println(total);



        // 1번 s + 2(오)
        // 2번 s + 6(왼), s + 2(오)
        // 3번 s + 6(왼), s + 2(오)
        // 4번 s + 6(왼)

        // -1 -> 7
        // -2 -> 6
        // -3 -> 5
        // -8 -> 0
        //

        // -1      67
        //  s m    e
        //   10101111
        //   01234567
    }

    static void play(int t, int w) {
        // 현재 톱니바퀴 pos
        Pos pos = list.get(t);
        int leftFlag = 0;
        int rightFlag = 0;

        // left
        // 현재 톱니바퀴 기준 왼쪽 톱니바퀴
        if (t - 1 >= 0) {
            Pos leftPos = list.get(t - 1);
            // 현재 톱니바퀴의 9시방향이
            // 왼쪽 톱니바퀴의 3시방향과
            // 다른 극이라면
            int idx;
            int lIdx;

            if ((pos.s + 6) % 8 < 0) {
                idx = ((pos.s + 6) % 8) + 8;
            } else {
                idx = (pos.s + 6) % 8;
            }

            if ((leftPos.s + 2) % 8 < 0) {
                lIdx = ((leftPos.s + 2) % 8) + 8;
            } else {
                lIdx = (leftPos.s + 2) % 8;
            }

            if (arr[t][idx] != arr[t - 1][lIdx]) {
                if (visited[t - 1] == 0) {
                    move(w, pos);
                    leftFlag = 1;
                    visited[t - 1] = 1;
                    play(t - 1, w * -1);
                }
            }
        }

        if (t + 1 < 4) {
            Pos rightPos = list.get(t + 1);
            // 현재 톱니바퀴의 3시방향이
            // 왼쪽 톱니바퀴의 9시방향과
            // 다른 극이라면
            int idx;
            int rIdx;

            if ((pos.s + 2) % 8 < 0) {
                idx = ((pos.s + 2) % 8) + 8;
            } else {
                idx = (pos.s + 2) % 8;
            }

            if ((rightPos.s + 6) % 8 < 0) {
                rIdx = ((rightPos.s + 6) % 8) + 8;
            } else {
                rIdx = (rightPos.s + 6) % 8;
            }


            if (arr[t][idx] != arr[t + 1][rIdx]) {

                // 오른쪽 톱니바퀴로 재귀
                if (visited[t + 1] == 0) {
                    move(w, pos);
                    rightFlag = 1;
                    visited[t + 1] = 1;
                    play(t + 1, w * -1);
                }
            }
        }

        // 현재 톱니를 기준으로 왼/오른쪽 모두 돌아가지 않았을 때
        if (leftFlag == 0 && rightFlag == 0) {
            move(w, pos);
        }
    }


    static void move(int w, Pos pos) {
        // 시계 방향
        if (w == 1) {
            pos.s--;
            pos.e--;
        }
        // 반시계 방향
        else {
            pos.s++;
            pos.e++;
        }
    }

}

// 시계방향: 마지막 idx를 첫 번째로
// 반시계: 첫 번째 idx를 마지막으로
//10101111 -> 11010111
//01111101
//11001110
//00000010

// 1번의 idx2 와 2번의 idx6
// 2번의 idx2 와 3번의 idx6
// 3번의 idx2 와 4번의 idx6

//  톱니바퀴 A를 회전할 때,
//  그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면,
//  B는 A가 회전한 방향과 반대방향으로 회전하게 된다.

// 회전할 때, 맞닿은 톱니바퀴가
// 다른 극일 경우, [시계 - 반시계], [반시계 - 시계]
// 같은 극일 경우, 회전 X

//0, 7
//0, 7
//1, 0
//-1, 6

//00100001
//11111101
//10000000
//00000000
//1
//3 1