package com.ssafy._2022_1.day_220826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4485_녹색옷입은애가젤다지_이원석 {
    static int N, cnt = 0;
    static int[][] arr, cost;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            cnt++;
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            arr = new int[N][N];

            // cost 배열을 MAX 값으로 초기화
            cost = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dijikstra();

            // 가장 오른쪽 아래 지점 출력
            System.out.printf("Problem %d: %d\n", cnt, cost[N - 1][N - 1]);
        }
    }

    public static void dijikstra() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        cost[0][0] = arr[0][0];

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // bfs 로직을 토대로, 모든 경로에서 항상 더 낮은 비용을 그리디하게 찾아다니는 다익스트라 문제이다.
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 지금 위치까지 뺏긴 비용과 다음에 뺏길 비용의 합이, 다음 위치에서 뺏길 비용보다 작은경우에만 움직인다.
                    if (cost[nx][ny] > cost[x][y] + arr[nx][ny]) {
                        cost[nx][ny] = cost[x][y] + arr[nx][ny];
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
