package com.ssafy._2024_04.BJ_14499_주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos {
    int top;
    int bot;

    public Pos(int top, int bot) {
        this.top = top;
        this.bot = bot;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        //          동  서  북  남
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] dice = new int[7];

        for (int i = 0; i < K; i++) {
            int move = Integer.parseInt(st.nextToken());

            // 현재 위치 이동
            int nx = x + dx[move - 1];
            int ny = y + dy[move - 1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
//                System.out.println("!범위를 벗어남!");
                continue;
            }

//            System.out.println(nx + ", " + ny);

            // 윗면
            int tmp = dice[3];
            switch (move) {
                case 1: // 동
                    dice[3] = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[4];
                    dice[4] = tmp;
                    break;

                case 2: // 서
                    dice[3] = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[2];
                    dice[2] = tmp;
                    break;

                case 3: // 북
                    dice[3] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = dice[1];
                    dice[1] = tmp;
                    break;

                case 4: // 남
                    dice[3] = dice[1];
                    dice[1] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = tmp;
                    break;
            }

            x = nx;
            y = ny;

            // 0이 아니면 밑변의 숫자가 주사위에 복사됨
            if (arr[x][y] != 0) {
                dice[6] = arr[x][y];
                arr[x][y] = 0;
            } else {
                arr[x][y] = dice[6];
            }

            System.out.println(dice[3]);

//            System.out.println(Arrays.toString(dice));
//            System.out.println();

        }
    }
}

// 윗면 1, 아랫면 6
// [x, 0, 0, 0, 0, 0, 0]
// 0 2 0
// 4 1 3
// 0 5 0
// 0 6 0
// 윗면 (1, 1)
// 아랫면 (3, 1)

// 4: 남쪽
//   6
// 4 2 3
//   1
//   5(3)
// 윗면 2, 아랫면 5, arr[2] = 0
// [x, 0, 0, 0, 0, 3, 0]

// 4: 남쪽
//   5(3)
// 4 6 3
//   2
//   1(5)
// 윗면 6, 아랫면 1, arr[6] = 0
// [x, 5, 0, 0, 0, 3, 0]
//   3
// 0 0 0
//   0
//   5

// 4: 남쪽
//   1(5)
// 4 5(3) 3
//   6
//   2(7)
// 윗면 5, 아랫면 2, arr[5] = 3
// [x, 5, 7, 0, 0, 3, 0]


// 1: 동쪽
//   1
// 2 4 5
//   6
//   3

// 윗면 4, 아랫면 3, arr[4] = 0
// [x, 5, 7, 8, 0, 3, 0]


// 3: 북쪽
// 윗면 5, 아랫면 2, arr[5] = 3
// [x, 5, 6, 8, 0, 3, 0]









// [주사위를 굴렸을 때]
// 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
// 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며, 칸에 쓰여 있는 수는 0이 된다.