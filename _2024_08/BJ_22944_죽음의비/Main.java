package com.ssafy._2024_08.BJ_22944_죽음의비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int visited[][], minVal, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, N, H, D;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        visited = new int[N][N];
        minVal = Integer.MAX_VALUE;

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < N; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = cArr[j];

                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
            }
        }


        bfs(sx, sy);
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b, H, 0, 0});
        visited[a][b] = H;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int nowHp = poll[2];
            int nowD = poll[3];
            int nowCnt = poll[4];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    // 종점 도착
                    if (arr[nx][ny] == 'E') {
                        minVal = Math.min(minVal, nowCnt + 1);
                        continue;
                    }

                    // 우산 이면
                    if (arr[nx][ny] == 'U') {
                        nowD = D;
                    }

                    // 내구도가 남아있다면
                    if (nowD != 0) {
                        nowD--;
                    }
                    // 내구도를 모두 소진했다면
                    else {
                        nowHp--;
                    }

                    if (nowHp == 0) {
                        continue;
                    }

                    // 현재 체력 + 우산 내구도가 현재 진행상황보다 크다면
                    if (visited[nx][ny] < nowHp + nowD) {
                        visited[nx][ny] = nowHp + nowD;
                        q.offer(new int[]{nx, ny, nowHp, nowD, nowCnt + 1});
                    }
                }
            }
        } // while

        if (minVal == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minVal);
        }
    }
}

// 1. 상하좌우로 이동한다. 만약 이동할 곳이 격자 밖이라면 이동할 수 없다.
// 2. 이동한 곳이 안전지대라면 반복을 종료한다.
// 3. 이동한 곳에 우산이 있다면 우산을 든다.
//    만약, 이동할 때부터 우산을 가지고 있다면
//    가지고 있는 우산을 버리고 새로운 우산으로 바꾼다.
// 4. 버린 우산은 더 이상 사용할 수 없다.
// 5. 죽음의 비를 맞았을 때, 우산을 가지고 있다면 우산의 내구도가 1이 감소하고 만약 우산을 가지고 있지 않는다면 체력이 1 감소한다.
// 6. 만약 우산의 내구도가 0이 되면 들고 있는 우산이 사라진다.
// 7. 만약 체력이 0이 되면 죽는다...
// 8. 아직 체력이 남았다면 안전지대까지 위 과정을 반복한다.


// 가로, 세로 길이가 N인 정사각형 격자가 있다.
// 해당 격자에는 두 곳을 제외한 모든 곳에 체력을 1씩 감소시키는 죽음의 비가 내리고 있다.
// 죽음의 비가 안내리는 곳은 현재 있는 위치와 안전지대라는 곳이다.
// 현재 있는 위치에도 곧 비가 내릴 예정이라 빨리 이 죽음의 비를 뚫고 안전지대로 이동해야한다.

// 다행히도 격자에는 죽음의 비를 잠시 막아주는 우산이
// K개 존재한다. 우산에는 내구도
// D라는 개념이 존재한다. 우산에 비를 맞으면 내구도가 1씩 감소하고,
// 내구도가 0이 되는 순간 우산은 사라진다. 문제에서 주어지는 우산의 내구도는 모두
// D로 동일하다.
//
// 격자에서 이동을 할 때 다음과 같이 순서로 진행된다.

//6 2 5
//......
//......
//E..S.U
//......
//......
//......