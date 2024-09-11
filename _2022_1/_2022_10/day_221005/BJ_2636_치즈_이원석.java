package com.ssafy._2022_1._2022_10.day_221005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 0, 0을 기준으로 bfs 탐색
// 1. 탐색중 1(치즈)를 만나게 되면 방문처리와 제거표시를 체크 한다.
// 2. 모든 탐색이 끝나면, 방문처리된 치즈를 제거한다.

public class BJ_2636_치즈_이원석 {
    static int arr[][], W, H, visited[][], last_cheese,
    dx[] = {-1, 1, 0, 0},
    dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        int cnt = 0;

        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    last_cheese += 1;
                }
            }
        }


//        for (int[] ints : arr) {
//            System.out.println(Arrays.toString(ints));
//        }

        while (true) {
            cnt++;
            visited = new int[H][W];
            bfs(0, 0);
            if (del()) { // 더 이상 제거할 치즈가 없다면 loop 탈출
                break;
            }
        }

        System.out.println(cnt);
        System.out.println(last_cheese);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어나지 않고, 방문지역이 치즈이고, 아직 방문하지 않았다면..
                if (isIn(nx, ny) && visited[nx][ny] == 0) {
                    // 방문지역이 치즈라면..
                    if (arr[nx][ny] == 1) {
                        // 제거표시
                        arr[nx][ny] = 2;
                    } else {
                        q.add(new int[]{nx, ny});
                    }

                    // 방문처리
                    visited[nx][ny] = 1;
                }
            }
        }
    }

    public static boolean del() {
        int tmp = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 2) {
                    // 치즈 제거
                    arr[i][j] = 0;
                }
            }
        }

        // check cheese
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 아직 제거할 치즈가 있다면 return
                if (arr[i][j] != 0) {
                    tmp += 1;
                }
            }
        }

        //  제거할 치즈가 한 개 이상 있을경우..
        if (tmp > 0) {
            last_cheese = tmp;
            return false;
        }

        // 제거할 치즈가 없다면 return true;
        return true;
    }

    public static boolean isIn(int nx, int ny) {
        if (0 <= nx && nx < H && 0 <= ny && ny < W) {
            return true;
        }
        return false;
    }
}



//5 5
//0 0 0 0 0
//0 1 1 0 0
//0 1 0 1 0
//0 1 1 1 0
//0 0 0 0 0