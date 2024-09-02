package com.ssafy._2024_08.BJ_20165_인내의도미노장인호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    //                  S  N  W  E
    static int dx[] = {1, -1, 0, 0},
            dy[] = {0, 0, -1, 1}, arr[][], N, M, R, score;
    static char cArr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cArr = new char[N][M];
        for (char[] chars : cArr) {
            Arrays.fill(chars, 'S');
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        map.put("S", 0);
        map.put("N", 1);
        map.put("E", 3);
        map.put("W", 2);

        for (int i = 0; i < R * 2; i++) {
            st = new StringTokenizer(br.readLine());

            if (i % 2 == 0) {
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;
                String D = st.nextToken();
                play(X, Y, map.get(D));
            } else {
                int X = Integer.parseInt(st.nextToken()) - 1;
                int Y = Integer.parseInt(st.nextToken()) - 1;

                cArr[X][Y] = 'S';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(cArr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(score);
        System.out.println(sb.toString());
    }

    static void play(int X, int Y, int W) {
        int sx = X;
        int sy = Y;

        if (cArr[sx][sy] == 'F') {
            return;
        }

        // 현재를 기준으로 높이만큼 다음 도미노들을 확인한다.
        // 현재 높이가 H라면, H가 0이 될때까지 다음 도미노를 무너뜨린다.
        // 만약 다음 도미노를 만났다면, 다음 도미노의 높이로 현재 높이를 갱신
        // 높이가 1인 경우 다음 도미노를 무너뜨리지 못한다.
        // 높이가 0인 경우 아무일도 일어나지 않는다.
        int H = arr[sx][sy];
        char before = ' ';
        while (true) {
            // 더 이상 이동할 수 없다면
            // H가 1이고 before 에 값이 있다면 이전에 사용했던 H가 1이므로
            // 지금은 H가 0이다. 따라서 break
            if (H == 1 && before != ' ') {
                break;
            }

            // 시작점이 아닌 경우
            if (before != ' ') {
                // 이동한 곳이 쓰러진 곳이라면 H--
                if (cArr[sx][sy] == 'F') {
                    H--;
                } else { // 쓰러지지 않은 곳이라면 H-1과 현재 도미노의 높이중 큰 것으로 갱신
                    H = Math.max(H - 1, arr[sx][sy]);
                }
            }

            before = cArr[sx][sy];

            // 다음으로 이동
            // 무너뜨릴 수 있다면 무너뜨려
            if (cArr[sx][sy] == 'S') {
                // 현재 도미노 무너뜨리기
                cArr[sx][sy] = 'F';
                score++;

                // 위치 이동
                sx += dx[W];
                sy += dy[W];

                // 범위를 벗어난 경우
                if (sx < 0 || sx >= N || sy < 0 || sy >= M) {
                    break;
                }
            } else {
                // 위치 이동
                sx += dx[W];
                sy += dy[W];

                // 범위를 벗어난 경우
                if (sx < 0 || sx >= N || sy < 0 || sy >= M) {
                    break;
                }
            }
        }
    }
}

// 도미노의 높이 만큼 다음 도미노에 영향을 준다.

// 1 1 1 1 1
// 1 2 2 1 1
// 3 1 2 2 2
// 1 3 2 1 1
// 1 3 3 1 1


// 공격수의 행동은 "X Y D"로 주어진다.
// 이는 X행 Y열의 도미노를 D 방향으로 민다는 뜻이다.
// D는 E, W, S, N 중 하나이며 각각 동, 서, 남, 북 방향을 의미한다.

// 수비수의 행동은 "X Y"로 주어진다.
// 이는 X행 Y열의 도미노를 다시 세운다는 뜻이다.

// 만약 이미 넘어진 격자의 도미노를 공격수가 넘어뜨리려 할 때에는
// 아무 일도 일어나지 않는다.

// 또한 만약 넘어지지 않은 도미노를 수비수가 세우려고 할 때에도
// 아무 일도 일어나지 않는다.