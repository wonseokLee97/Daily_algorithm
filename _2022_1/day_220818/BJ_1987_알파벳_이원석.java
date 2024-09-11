package com.ssafy._2022_1.day_220818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1987_알파벳_이원석 {
    static int[] validate = new int[100];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static int R, C, cnt = 1, max_val = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = chars[j];
            }
        }
        validate[arr[0][0]] = 1;
        dfs(0, 0);
        System.out.println(max_val);
    }

    public static void dfs(int x, int y) {
        cnt++;
        int nx, ny;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C) { // 범위 안이라면
                if (validate[arr[nx][ny]] == 0) { // 방문한 알파벳이 아니라면
                    validate[arr[nx][ny]] = 1; // 방문처리
                    dfs(nx, ny);
                } else {
                    // 방문한 알파벳이라면
                    continue;
                }
            }
        }

        // 4방향 모두 가지 못할 경우,
        // 카운트를 감소시키고, 해당 좌표까지의 거리를 최대값과 비교하여 저장한다.
        cnt--;
        max_val = Math.max(cnt, max_val);
        // 그리고 해당 좌표의 알파벳 사용기록을 0으로 지우고, 이전 좌표로 return
        validate[arr[x][y]] = 0;
        return;
    }
}

// H, A, D, G, J, F, D