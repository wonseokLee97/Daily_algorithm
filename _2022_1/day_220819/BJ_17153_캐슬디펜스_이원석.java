package com.ssafy._2022_1.day_220819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Man{
    int x;
    int y;
    int die;
    int t = 0;
    public Man(int x, int y, int die) {
        this.x = x;
        this.y = y;
        this.die = die;
    }

    public Man(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class BJ_17153_캐슬디펜스_이원석 {
    static int M, N, D, min_val,  max_res = Integer.MIN_VALUE;
    static int[] arr;
    static int[][] map;
    static List<Man> enemy, archer;
    static Man target;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int get = Integer.parseInt(st.nextToken());
                if (get == 1) {
                    map[i][j] = get;
                }
            }
        }

        comb();
        System.out.println(max_res);
        // mC3
    }

    public static void comb() {
        for (int i = 0; i < 1 << M; i++) { // 100000
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                if ((i & 1 << j) > 0) {
                    cnt++;
                }
            }

            if (cnt == 3) { // 궁수 세 명 배치!
                arr = new int[M];
                archer = new ArrayList<>();

                for (int j = 0; j < M; j++) {
                    if ((i & 1 << j) > 0) { // 배치된 궁수 위치
                        archer.add(new Man(N, j));
                    }
                }
                max_res = Math.max(max_res, battle());
            }
        }
    }

    public static int battle(){
        int kill = 0, except = 0;
        int[][] tmp = new int[N][M];
        enemy = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }

        // 적군좌표
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 1) {
                    enemy.add(new Man(i, j, 0));
                }
            }
        }

        while (true) {
            for (Man A : archer) {
                target = null; // 타겟 초기화
                except = 0;
                min_val = Integer.MAX_VALUE;
                int flag = 0;

                for (Man E : enemy) {

                    if (E.x >= N) { // 범위를 벗어났다면
                        continue;
                    }

                    int dis = Math.abs(E.x - A.x) + Math.abs(E.y - A.y);
                    // 사정범위 안에 있을 때,
                    if (dis <= D && E.die == 0) {
                        flag = 1;
                        if (min_val > dis) { // 가장 가까운 적을 찾되, 살아있어야 한다.
                            min_val = dis;
                            target = E;

                        } else if (min_val == dis) {
                            if (target.y > E.y) { // 이미 타겟이 존재할 때, 새로운놈이 더 왼쪽에 있는 경우
                               target = E;
                            }
                        }
                    }
                }
                if (flag == 1) {
                    target.t = 1; // 타겟팅 당함
                }
            }

            for (Man E : enemy) {
                if (E.t == 1) { // 타겟팅을 당했다면
                    E.die = 1;
                    E.t = 0; // 타겟팅 초기화
                    kill++; // 죽인다.
                }

                if (E.die == 1 || E.x >= N) { // 사망하거나 제외된다면
                    except++;
                    continue;
                }
            }

            if (except == enemy.size()) {
                return kill;
            }


            // Enemy 의 위치 이동
            for (Man E : enemy) {
                E.x += 1;
            }
        }
    }
}

// 2 4 2
// x   1   1   1
// 0   x   x   0
//20 ,21, 22, 23

// 2 4 2
// 0   0   0   0
// 0   x   x   x
//20 ,21, 22, 23

// 4 4 3
// 0 1 1 0
// 0 0 1 1
// 1 0 1 0
// 1 1 1 0
// x x x 0 kill 0

// 4 4 3
// 0 0 0 0
// 0 1 1 0
// 0 0 1 1
// 1 0 1 0
// x x x 0 kill 3

// 4 4 3
// 0 0 0 0
// 0 1 1 0
// 0 0 1 1
// d 0 d 0
// x x x 0 kill 5

// 4 4 3
// 0 0 0 0
// 0 0 0 0
// 0 d 1 0
// 0 0 d 1
// x x x 0 kill 7

// 4 4 3
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0
// 0 0 d 0
// x x x 0 kill 8

