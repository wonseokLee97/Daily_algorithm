package com.ssafy._2024_09.BJ_1941_소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int ans, visited[], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static char arr[][];
    static List<Pos> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[5][5];
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            char[] cArr = br.readLine().toCharArray();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = cArr[j];
                list.add(new Pos(i, j));
            }
        }

        visited = new int[25];
        ans = 0;

        comb(0, 0);

        System.out.println(ans);
    }

    static void comb(int start, int cnt) {
        if (cnt == 7) {
            bfs();
            return;
        }

        for (int i = start; i < 25; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(i, cnt + 1);
            visited[i] = 0;
        }
    }

    static void bfs() {
        List<Pos> newList = new ArrayList<>();
        int[][] visited2 = new int[5][5];
        int[][] arr2 = new int[5][5];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 25; i++) {
            if (visited[i] == 1) {
                Pos pos = list.get(i);
                newList.add(pos);
                arr2[pos.x][pos.y] = 1;
                sb.append(arr[pos.x][pos.y]);
            }
        }

        Pos start = newList.get(0);
        Queue<Pos> q = new LinkedList<>();
        q.offer(start);
        visited2[start.x][start.y] = 1;
        int S = 0;
        int Y = 0;

        if (arr[start.x][start.y] == 'Y') {
            Y++;
        } else {
            S++;
        }

        while (!q.isEmpty()) {
            Pos nowPos = q.poll();
            int x = nowPos.x;
            int y = nowPos.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    // 이미 방문했거나 갈 수 없다면
                    if (visited2[nx][ny] == 1 || arr2[nx][ny] == 0) {
                        continue;
                    }

                    if (arr[nx][ny] == 'Y') {
                        Y++;
                    } else {
                        S++;
                    }
                    visited2[nx][ny] = 1;
                    q.offer(new Pos(nx, ny));
                }
            }
        }

        int total = Y + S;


        if (total == 7) {
            if (S >= 4) {
                ans++;
            }
        }

//        0, 0, 0, 0, 0,
//        0, 0, 0, 1, 1,
//        0, 0, 0, 0, 1,
//        0, 1, 1, 1, 1,
//        0, 0, 0, 0, 0

    }
}

// 이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
// 강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
// 화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
// 그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.

// Y Y Y Y Y
// S Y S Y S
// Y Y Y Y Y
// Y S Y Y S
// Y Y Y Y Y