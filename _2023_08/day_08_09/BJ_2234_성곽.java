package com.ssafy._2023_08.day_08_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2234_성곽 {
    static int visited[], arr[], visited2[][], map[][], cnt, width, max_width, N, M, breakWidth, breakMax;
    static int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

    static HashMap<Integer, int[]> hashMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        List<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);

        System.out.println(list);

        arr = new int[]{1, 2, 4, 8};
        visited = new int[4];
        hashMap = new HashMap<>();
        cnt = 0;
        max_width = Integer.MIN_VALUE;
        breakMax = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        // 가로길이
        N = Integer.parseInt(st.nextToken());
        // 세로길이
        M = Integer.parseInt(st.nextToken());

        visited2 = new int[M][N];
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        hashMap.put(0, new int[] {0, 0, 0, 0});
        comb(0, 0);


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited2[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max_width);


        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    visited2 = new int[M][N];
                    bfsDel(i, j, k);
                }
            }
        }

        System.out.println(breakMax);
    }

    static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited2[i][j] = 1;
        width = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int[] way = hashMap.get(map[x][y]);

            for (int k = 0; k < 4; k++) {
                // 벽이 없는 방향
                if (way[k] == 0) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (isIn(nx, ny) && visited2[nx][ny] == 0) {
                        visited2[nx][ny] = 1;
                        q.add(new int[]{nx, ny});
                        width++;
                    }
                }
            }
        }

        cnt++;
        max_width = Math.max(max_width, width);
    }


    static void bfsDel(int i, int j, int del) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited2[i][j] = 1;
        breakWidth = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int[] way;

            // 시작하는 지점
            if (x == i && y == j) {
                way = hashMap.get(map[x][y]).clone();
                // 벽 부수기
                way[del] = 0;
            } else {
                way = hashMap.get(map[x][y]);
            }

            for (int k = 0; k < 4; k++) {
                // 벽이 없는 방향
                if (way[k] == 0) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (isIn(nx, ny))
                        if (visited2[nx][ny] == 0) {
                            visited2[nx][ny] = 1;
                            q.add(new int[]{nx, ny});
                            breakWidth++;
                        }
                    }
                }
            }

        breakMax = Math.max(breakMax, breakWidth);
    }

    static boolean isIn(int x, int y) {
        if (x >= 0 && x < M && y >= 0 && y < N) {
            return true;
        }
        return false;
    }

    static void comb(int cnt, int start) {
        if (cnt == 4) {
            return;
        }

        for (int i = start; i < 4; i++) {
            if (visited[i] != 0) {
                continue;
            }

            visited[i] = 1;
            int total = 0;
            for (int j = 0; j < 4; j++) {
                if (visited[j] == 1) {
                    total += arr[j];
                }
            }

            hashMap.put(total, visited.clone());

            comb(cnt + 1, i + 1);
            visited[i] = 0;
        }
    }
}

// 1 서
// 2 북
// 4 동
// 8 남

// 3 서 북
// 5 서 동
// 9 서 남
// 6 북 동
// 10 북 남
// 12 동 남
// 13 서 동 남
// [1, 2, 4, 8]
// 서  북  동  남
// dx = {0, -1, 0, 1}
// dy = {-1, 0, 1, 0}

// 9, 3, 7, 1, 8

//0 6 11 6 3 10 6
//7 9 6 13 5 15 5
//1 10 12 7 13 7 5
//13 11 10 8 10 12 13