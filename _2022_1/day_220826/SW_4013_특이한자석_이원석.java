package com.ssafy._2022_1.day_220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class SW_4013_특이한자석_이원석 {
    static int[] move = {-1, 1}; // 좌 우
    static int[] gear, visited;
    static List<int[]> list;
    static List<int[]> rotates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int TC = Integer.parseInt(br.readLine()); // 전체 테스트 케이스
        for (int t = 1; t < TC + 1; t++) {
            List<int[]> cmd = new ArrayList<>();
            list = new ArrayList<>();

            int result = 0;
            int K = Integer.parseInt(br.readLine()); // 자석의 회전 수

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                gear = new int[8];
                for (int j = 0; j < 8; j++) {
                    int get = Integer.parseInt(st.nextToken());
                    gear[j] = get;
                }
                list.add(gear);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                cmd.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }

            for (int[] c : cmd) {
                rotates = new ArrayList<>();
                visited = new int[4];

                bfs(c[0] - 1, c[1]);
                for (int[] rotate : rotates) {
                    if (rotate[1] == 1) { // 시계방향이면
                        list.set(rotate[0], rotate(list.get(rotate[0])));
                    } else { // 반시계라면,
                        list.set(rotate[0], rotate_r(list.get(rotate[0])));
                    }
                }
            }

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] == 1) {
                    result += Math.pow(2, i);
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }

    public static void bfs(int select, int way) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{select, way});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int w = poll[1];
            rotates.add(new int[]{x, w});
            int[] now_gear = list.get(x);

            for (int i = 0; i < 2; i++) {
                int nx = x + move[i];

                if (0 <= nx && nx < 4) {
                    if (visited[nx] == 1) {
//                        System.out.println((nx + 1) + "번째 기어를 건너뛴다!");
                        continue;
                    }
                    int[] other_gear = list.get(nx);

                    if (i == 0) { // 왼쪽 기어 - 지금 기어
                        if (other_gear[2] != now_gear[6]) { // 둘이 극이 다르다면
                            if (w == 1) { // 시계방향
//                                System.out.println("왼쪽기어가 돌아간다. 둘의 극이 다르며, 지금 기어는 시계 다른기어는 반시계");
                                visited[nx] = 1;
                                q.add(new int[] {nx, -1});
                            } else {
//                                System.out.println("왼쪽기어가 돌아간다. 둘의 극이 다르며, 지금 기어는 반시계 다른기어는 시계");
                                visited[nx] = 1;
                                q.add(new int[] {nx, 1});
                            }
                        }
                    } else { // 지금 기어 - 오른쪽 기어
                        if (other_gear[6] != now_gear[2]) { // 둘이 극이 다르다면
                            if (w == 1) { // 시계방향
//                                System.out.println("오른쪽 기어가 돌아간다. 둘의 극이 다르며, 지금 기어는 시계 다른기어는 반시계");
                                visited[nx] = 1;
                                q.add(new int[] {nx, -1});
                            } else {
//                                System.out.println("오른쪽 기어가 돌아간다. 둘의 극이 다르며, 지금 기어는 반시계 다른기어는 시계");
                                visited[nx] = 1;
                                q.add(new int[] {nx, 1});
                            }
                        }
                    }
                }
            }
            visited[x] = 1;
        }
    }

    // 시계 반대방향
    public static int[] rotate_r(int[] gear) {
        LinkedList<Integer> q = new LinkedList<>();

        for (int i : gear) {
            q.add(i);
        }
        q.add(q.poll());
        for (int i = 0; i < q.size(); i++) {
            gear[i] = q.get(i);
        }

        return gear;
    }

    // 시계 방향
    public static int[] rotate(int[] gear) {
        LinkedList<Integer> q = new LinkedList<>();

        for (int i : gear) {
            q.add(i);
        }

        q.addFirst(q.pollLast());
        for (int i = 0; i < q.size(); i++) {
            gear[i] = q.get(i);
        }

        return gear;
    }
}


//10
//2
//0 0 1 0 0 1 0 0
//1 0 0 1 1 1 0 1
//0 0 1 0 1 1 0 0
//0 0 1 0 1 1 0 1
//1 1
//3 -1


//    public static void logic(int select, int way) {
//
//
//        visited[select] = 1;
//        int[] now_gear = list.get(select);
//        // 좌우 모두 기어가 있을 경우, (2, 3번 기어)
//        if (0 <= select - 1 && select + 1 < 4) {
//            int[] l_gear = list.get(select - 1);// 좌기어
//            int[] r_gear = list.get(select + 1);// 우기어
//
//            // 회전을 하기 전,
//            if (l_gear[2] != now_gear[6]) { // 지금 기어의 왼쪽 톱날과 좌기어의 우측 톱날의 자성이 다르다면, 반대방향으로 회전한다
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select)) ; // 시계방향
//                    list.set(select - 1, rotate_r(l_gear, select - 1)); // 반시계방향
//                    logic(select - 1, -1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                } else {
//                    list.set(select, rotate_r(now_gear, select)); // 반시계방향
//                    list.set(select - 1, rotate(l_gear, select - 1)); // 시계방향
//                    logic(select - 1, 1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                }
//            }
//
//            // 회전을 하기 전,
//            if (now_gear[2] != r_gear[6]) { // 지금 기어의 오른쪽 톱날과 우기어의 왼쪽 톱날의 자성이 다르다면, 반대방향으로 회전한다
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select)); // 시계방향
//                    list.set(select + 1, rotate_r(r_gear, select + 1)); // 반시계방향
//                    logic(select + 1, -1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                } else {
//                    list.set(select, rotate_r(now_gear, select)); // 반시계방향
//                    list.set(select + 1, rotate(r_gear, select + 1)); // 시계방향
//                    logic(select + 1, 1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                }
//            }
//
//            if (now_gear[2] == r_gear[6] && now_gear[6] == l_gear[2]) { // 지금 기어를 기준으로 양쪽 모두 극성이 같다면,
//                // 지금의 기어만 회전
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select));
//                } else {
//                    list.set(select, rotate_r(now_gear, select));
//                }
//            }
//
//
//        } else if (select == 0) { // 1번 기어
//            int[] r_gear = list.get(select + 1);// 우기어
//
//            // 회전을 하기 전,
//            if (now_gear[2] != r_gear[6]) { // 지금 기어의 오른쪽 톱날과 우기어의 왼쪽 톱날의 자성이 다르다면, 반대방향으로 회전한다
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select)); // 시계방향
//                    list.set(select + 1, rotate_r(r_gear, select + 1)); // 반시계방향
//                    logic(select + 1, -1); // 지금 기어를 기준으로 오른쪽 기어를 재귀한다.
//                } else {
//                    list.set(select, rotate_r(now_gear, select)); // 반시계방향
//                    list.set(select + 1, rotate(r_gear, select + 1)); // 시계방향
//                    logic(select + 1, 1); // 지금 기어를 기준으로 오른쪽 기어를 재귀한다.
//                }
//            }
//
//            else { // 지금 기어를 기준으로 오른쪽 극성이 같다면,
//                // 지금의 기어만 회전
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select));
//                } else {
//                    list.set(select, rotate_r(now_gear, select));
//                }
//            }
//
//
//        } else if (select == 4) { // 4번 기어
//            int[] l_gear = list.get(select - 1);// 좌기어
//
//            // 회전을 하기 전,
//            if (l_gear[2] != now_gear[6]) { // 지금 기어의 왼쪽 톱날과 좌기어의 우측 톱날의 자성이 다르다면, 반대방향으로 회전한다
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select)); // 시계방향
//                    list.set(select - 1, rotate_r(l_gear, select - 1)); // 반시계방향
//                    logic(select - 1, -1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                } else {
//                    list.set(select, rotate_r(now_gear, select)); // 반시계방향
//                    list.set(select - 1, rotate(l_gear, select - 1)); // 시계방향
//                    logic(select - 1, 1); // 지금 기어를 기준으로 왼쪽 기어를 재귀한다.
//                }
//            }
//
//            else { // 지금 기어를 기준으로 왼쪽 기어와 극성이 같다면,
//                // 지금의 기어만 회전
//                if (way == 1) {
//                    list.set(select, rotate(now_gear, select));
//                } else {
//                    list.set(select, rotate_r(now_gear, select));
//                }
//            }
//
//        }
//    }