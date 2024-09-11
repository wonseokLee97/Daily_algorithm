package com.ssafy._2022_1.day_220818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3109_빵집_이원석 {
    static char[][] arr;
    static int R, C, flag, result = 0;

    // 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = chars[j];
            }
        }

//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

//      가장 왼쪽 0열부터 시작
        for (int i = 0; i < R; i++) {
//            System.out.println(i);
            flag = 0;
            pipe(i, 0);
        }

        System.out.println(result);
    }

    public static void pipe(int x, int y) {
        System.out.println(x + ", " + y);
        for (int i = 0; i < R; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
        System.out.println();
        // 원웅이 집
        if (y == C - 1) {
            result++;
            // 파이프 설치 완료
            flag = 1;

            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위를 벗어나지 않을 때,
            System.out.println(nx + ", " + ny);
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                // 벽을 만난다면
                if (arr[nx][ny] == 'x' || visited[nx][ny] == 1) {
                    continue;
                }
                visited[x][y] = 1;
                pipe(nx, ny);
                return;
            }
        }
    }
}
