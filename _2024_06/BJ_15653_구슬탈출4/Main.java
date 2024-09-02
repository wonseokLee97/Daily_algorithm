//package com.ssafy._2024_06.BJ_15653_구슬탈출4;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.StringTokenizer;
//
//// [동, 서, 남, 북]으로 보드를 기울일 수 있다.
//// 동: y++
//// 서: y--
//// 남: x++
//// 북: x--
//
//class Node {
//    int x;
//    int y;
//    int color;
//
//    public Node(int x, int y, int color) {
//        this.x = x;
//        this.y = y;
//        this.color = color;
//    }
//}
//
//
//public class Main {
//    // 동, 서, 남, 북
//    static int ways[][] = {
//            {0, 1},
//            {0, -1},
//            {1, 0},
//            {-1, 0}
//    }, flag, N, M, min_val;
//    static char[][] arr;
//    static List<Node> list;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        arr = new char[N][M];
//        min_val = Integer.MAX_VALUE;
//
//        Node blue = null;
//        Node red = null;
//        for (int i = 0; i < N; i++) {
//            char[] c = br.readLine().toCharArray();
//            for (int j = 0; j < M; j++) {
//                if (c[j] == 'B') {
//                    blue = new Node(i, j, 0);
//                } else if (c[j] == 'R') {
//                    red = new Node(i, j, 1);
//                }
//
//                arr[i][j] = c[j];
//            }
//        }
//
//        dfs(1, blue, red);
//    }
//
//    // 구슬에 움직임이 없었다면 다음 움직임
////            if (!move(i)) {
////        continue;
////    } else {
////        // 빨간 구슬이 탈출했다면?
////        if (flag == 1) {
////            min_val = Math.min(min_val, cnt);
////            flag = 0;
////            return;
////        }
////    }
//
//    static void dfs(int cnt, Node blue, Node red) {
//        // 동서남북
//        for (int i = 0; i < 4; i++) {
//            int mx = ways[i][0]; // x축 이동
//            int my = ways[i][1]; // y축 이동
//
//            int bx = blue.x;
//            int by = blue.y;
//            int rx = blue.x;
//            int ry = blue.y;
//
//            // blue 이동
//            while (true) {
//                // y가 움직이는 경우. 동, 서
//                if (mx == 0) {
//                    int next = by + my;
//                    // 다음 이동이 범위 내인경우
//                    if (next >= 1 && next < N - 1) {
//                        // 움직일 수 있는 경우
//                        if (arr[bx][next] == '.') {
//                            by += my;
//                        } else if (arr[bx][next] == 'O') { // 구멍인 경우
//                            by += my;
//                            flag = 1;
//                            break;
//                        } else { // 움직일 수 없는 경우(구슬이거나 벽인 경우)
//                            break;
//                        }
//                    } else { // 아닌 경우
//                        break;
//                    }
//
//                } else { // x가 움직이는 경우. 남, 북
//                    int next = bx + mx;
//                    // 다음 이동이 범위 내인경우
//                    if (next >= 1 && next < N - 1) {
//                        // 움직일 수 있는 경우
//                        if (arr[next][by] == '.') {
//                            bx += mx;
//                        } else if (arr[next][by] == 'O') { // 구멍인 경우
//                            bx += mx;
//                            flag = 1;
//                            break;
//                        } else { // 움직일 수 없는 경우(구슬이거나 벽인 경우)
//                            break;
//                        }
//                    } else { // 아닌 경우
//                        break;
//                    }
//                }
//
//
//                // red 이동
//                while (true) {
//                    // y가 움직이는 경우. 동, 서
//                    if (mx == 0) {
//                        int next = ry + my;
//                        // 다음 이동이 범위 내인경우
//                        if (next >= 1 && next < N - 1) {
//                            // 움직일 수 있는 경우
//                            if (arr[rx][next] == '.') {
//                                ry += my;
//                            } else if (arr[rx][next] == 'O') { // 구멍인 경우
//                                ry += my;
//                                flag = 1;
//                                break;
//                            } else { // 움직일 수 없는 경우(구슬이거나 벽인 경우)
//                                break;
//                            }
//                        } else { // 아닌 경우
//                            break;
//                        }
//
//                    } else { // x가 움직이는 경우. 남, 북
//                        int next = bx + mx;
//                        // 다음 이동이 범위 내인경우
//                        if (next >= 1 && next < N - 1) {
//                            // 움직일 수 있는 경우
//                            if (arr[next][by] == '.') {
//                                bx += mx;
//                            } else if (arr[next][by] == 'O') { // 구멍인 경우
//                                bx += mx;
//                                flag = 1;
//                                break;
//                            } else { // 움직일 수 없는 경우(구슬이거나 벽인 경우)
//                                break;
//                            }
//                        } else { // 아닌 경우
//                            break;
//                        }
//                    }
//
//
//                break;
//            }
//
//            by += my;
//
//            Node nBlue = null;
//            Node nRed = null;
//
//            dfs(cnt + 1, nBlue, nRed);
//        }
//    }
//
//    static boolean move(int w) {
//        int mx = ways[w][0]; // x축 이동
//        int my = ways[w][1]; // y축 이동
//
//        while (true) {
//
//        }
//    }
//}
//
//// dfs
//
//// [동, 서, 남, 북]으로 보드를 기울일 수 있다.
//// 동: y++
//// 서: y--
//// 남: x++
//// 북: x--
//
//// 각각의 동작에서 공은 동시에 움직인다.
//// 1. 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다.
//// 2. 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다.
//// 3. 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다.
//// 4. 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다.
//// 5. 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.