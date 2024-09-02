package com.ssafy._2023._2023_07.day_07_01;

import java.io.*;
import java.util.*;


public class BJ_20055_컨베이어벨트위의로봇 {

    static class Robot {
        int y;

        public Robot(int y) {
            this.y = y;
        }
    }

    static List<Robot> list;
    static int N, K, arr[][], visited[][], check;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        check = 0;
        arr = new int[3][N + 2];
        visited = new int[3][N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            } else {
                for (int j = N; j >= 1; j--) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }

        while (K > 0) {
            cnt++;
            rotate();
            move(1);
            robot();
        }
        System.out.println(cnt);
    }

    // 1. rotate
    // 2. move
    // 3. robot

    public static void rotate() {
        for (int i = 1; i <= 2; i++) {
            if (i == 1) {
                for (int j = N; j >= 1; j--) {
                    arr[i][j + 1] = arr[i][j];
                }
            } else {
                for (int j = 1; j <= N; j++) {
                    arr[i][j - 1] = arr[i][j];
                }
            }
        }

        arr[2][N] = arr[1][N + 1];
        arr[1][N + 1] = 0;
        arr[1][1] = arr[2][0];
        arr[2][0] = 0;

        // 벨트가 돌때 로봇도 함께 움직인다.
        move(0);
    }

    public static void move(int type) {
        List<Integer> del = new ArrayList<>();

        // 벨트로인한 움직임
        if (type == 0) {
            for (int i = 0; i < list.size(); i++) {
                Robot r = list.get(i);

                r.y++;

                if (r.y == N) {
                    del.add(i);
                }
            }


            for (int i = 0; i < del.size(); i++) {
                int idx = del.get(i);
                list.remove(idx);
            }
        }
        // 로봇 스스로 움직임
        else  {
            for (int i = 0; i < list.size(); i++) {
                int flag = 0;
                Robot r = list.get(i);

                // 다음 지점이 이동가능한 곳이라면?
                if (arr[1][r.y + 1] >= 1) {
                    for (int j = 0; j < list.size(); j++) {
                        if (i == j) {
                            continue;
                        }

                        Robot next_robot = list.get(j);

                        if (next_robot.y == r.y + 1) {
                            flag = 1;
                        }
                    }

                    // 다음 지점에 로보트가 있다면?
                    if (flag == 1) {
                        // 로보트를 움직이지 않는다.
                        continue;
                    }

                    r.y++;


                    if (r.y == N) {
                        del.add(i);
                    }

                    arr[1][r.y]--;
                    if (arr[1][r.y] == 0) {
                        K--;
                    }
                }
            }

            for (int i = 0; i < del.size(); i++) {
                int idx = del.get(i);
                list.remove(idx);
            }
        }
    }

    public static void robot() {
        // 1번칸에 로보트를 올릴 수 있는 경우에만 올린다.
        if (arr[1][1] >= 1) {
            list.add(new Robot(1));
            arr[1][1]--;

            if (arr[1][1] == 0) {
                K--;
            }
        }
    }
}


// N이 3인 경우
// 1 2 3
// 6 5 4

//[0, 0, 0, 0]
//[0, 1, 2, 1]
//[0, 2, 1, 2]

// 1
// rotate
//[0, 0, 0, 0]
//[0, 2, 1, 2]
//[0, 1, 2, 1]

// robot
//[0, 0, 0, 0]
//[0, [1], 1, 2]
//[0, 1, 2, 1]

// 2
// rotate
//[0, 0, 0, 0]
//[0, 1, [1], 1]
//[0, 2, 1, 2]

// robot
//[0, 0, 0, 0]
//[0, 1, 1, [0]]
//[0, 2, 1, 2]

// 3


// 1. 먼저 회전을 시킨다.
// 2. 그 다음에 로봇을 올린다.

// 현재 움직이려는 로봇의 열이 N 이라면 행에 +1
// 현재 움직이려는 로봇의 열이 1 이라면 행에 -1
