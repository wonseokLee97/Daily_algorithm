package com.ssafy._2024_08.BJ_3184_양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, R, C, visited[][], v, o;
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        arr = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                arr[i][j] = cArr[j];
            }
        }

        int totalO = 0;
        int totalV = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // 울타리가 아니고, 방문하지 않았다면 탐색시작
                if (arr[i][j] != '#' && visited[i][j] == 0) {
                    v = 0;
                    o = 0;
                    bfs(i, j);

                    // 늑대가 양의 수보다 같거나 크다면
                    if (o <= v) {
                        totalV += v;
                    } else {
                        totalO += o;
                    }
                }
            }
        }

        System.out.println(totalO + " " + totalV);
    }

    static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            // 늑대
            if (arr[x][y] == 'v') {
                v++;
            }
            // 양
            else if (arr[x][y] == 'o') {
                o++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 내에서
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (visited[nx][ny] == 0) {
                        // 울타리가 아니라면 이동
                        if (arr[nx][ny] != '#') {
                            visited[nx][ny] = 1;
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }
}


// '.' (점)은 빈 필드를 의미하며,
// '#'는 울타리를,
// 'o'는 양,
// 'v'는 늑대를 의미한다.

// 한 칸에서 수평, 수직만으로 이동하며 울타리를 지나지 않고
// 다른 칸으로 이동할 수 있다면, 두 칸은 같은 영역 안에 속해 있다고 한다.
// 마당에서 "탈출"할 수 있는 칸은 어떤 영역에도 속하지 않는다고 간주한다.

// 다행히 우리의 양은 늑대에게 싸움을 걸 수 있고
// 영역 안의 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다.
// 그렇지 않다면 늑대가 그 지역 안의 모든 양을 먹는다.