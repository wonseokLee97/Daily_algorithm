package com.ssafy._2023._2023_07.day_07_15;
import java.util.*;
import java.io.*;
public class BJ_2667_단지번호붙이기 {

    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] visited;
    static int N, arr[][];
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new int[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] get = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = get[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(list);
        sb.append(list.size() + "\n");

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "\n");
        }

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 1;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                // 방문할 수 있다면
                if (isIn(nx, ny) && visited[nx][ny] == 0) {
                    if (arr[nx][ny] == 1) {
                        cnt++;
                        q.add(new int[] {nx, ny});
                        visited[nx][ny] = 1;
                    }
                }
            }
        }

        list.add(cnt);
    }

    static boolean isIn(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            return true;
        } else {
            return false;
        }
    }
}
