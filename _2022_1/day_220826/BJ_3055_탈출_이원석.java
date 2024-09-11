package com.ssafy._2022_1.day_220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출_이원석 {
    static int[][] visited_W, visited_K;
    static int R, C;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로길이
        C = Integer.parseInt(st.nextToken()); // 가로길이
        arr = new char[R][C];                 // 전체배열

        // 고슴도치 시작위치
        int[] beaver = new int[2];

        // 전체 배열을 순회하며,
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                // 고슴도치의 시작 위치를 저장한다.
                if (chars[j] == 'D') {
                    beaver[0] = i;
                    beaver[1] = j;
                }
                // 배열 초기화
                arr[i][j] = chars[j];
            }
        }

        visited_W = new int[R][C]; // 물의 최단경로
        visited_K = new int[R][C]; // 고슴도치의 최단경로


        // 물이 이동한 최단경로를 먼저 구한 뒤, 고슴도치가 물의
        // 최단경로보다 작을 때 움직일 수 있다고 판단하여 탐색을한다.

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == '*') { // 물
                    bfs_W(i, j);        // 물 전용 bfs 탐색
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == 'S') { // 고슴도치
                    bfs_K(i, j);        // 고슴도치 전용 bfs 탐색
                }
            }
        }



        // 비버 집에 가지 못했다면,
        if (visited_K[beaver[0]][beaver[1]] == 0) {
            System.out.println("KAKTUS");
        } else { // 집에 갔다면 최단경로 출력
            System.out.println(visited_K[beaver[0]][beaver[1]]);
        }
    }

    public static void bfs_W(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    // 갈 수 있는 땅일 때,
                    if (arr[nx][ny] == '.' || arr[nx][ny] == 'S') {
                        if (visited_W[nx][ny] == 0) {
                            visited_W[nx][ny] = visited_W[x][y] + 1;
                            q.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    public static void bfs_K(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                    // 갈 수 있는 땅일 때,
                    if (arr[nx][ny] == '.' || arr[nx][ny] == 'D') {
                        if (visited_K[nx][ny] == 0) {
                            visited_K[nx][ny] = visited_K[x][y] + 1;

                            // 물보다 고슴도치가 먼저 움직이거나, 물에 젖지않은 땅이라면,
                            if (visited_K[nx][ny] < visited_W[nx][ny] || visited_W[nx][ny] == 0) {
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
    }
}

//3 3
//S..
//.D.
//...