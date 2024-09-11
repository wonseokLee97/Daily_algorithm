package com.ssafy._2024._04.BJ_2571_색종이_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 누적합

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] sum = new int[100][100];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (sum[j][k] == 1) {
                        continue;
                    }

                    sum[j][k] = 1;
                }
            }
        }

        int ans = Integer.MIN_VALUE;



        // 좌 -> 우
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (sum[i][j] == 0) {
                    continue;
                }

                // 0, 0일 때, 가로열 j + dir 개 만큼 직사각형의 넓이를 구하자.
                for (int dir = 0; dir < 100; dir++) {
                    int ny = j + dir;

                    // 범위를 벗어나는 경우
                    if (ny >= 100) break;

                    int min_depth = Integer.MAX_VALUE;
                    for (int k = j; k < j + dir + 1; k++) {
                        int depth = 0;

                        for (int l = i; l < 100; l++) {
                            if (sum[l][k] == 0) {
                                break;
                            }

                            depth++;
                        }

                        min_depth = Math.min(min_depth, depth);
                    }

                    ans = Math.max(ans, min_depth * (dir + 1));
                }
            }
        }

        System.out.println(ans);
    }
}


// 0 1 2 3 4
// 1 1 1 1 1

// 100 + 100 + 100 = 300
// 40 +

// 260

// 425

// 3
// 3 7
// 15 7
// 5 2

// (3, 7) -> (13, 17)
// (15, 7) -> (25, 17)
// (5, 2) -> (15, 12)


// (3, 7), (3, 17), (13, 7), (13, 17)
// (15, 7), (15, 17), (25, 7), (25, 17)
// (5, 2), (5, 12), (15, 2), (15, 12)

//     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
//  0 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  1 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  2 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  3 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  4 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  5 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  6 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  7 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
//  8 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
//  9 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 10 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 11 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 12 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 13 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 14 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 15 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 16 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 17 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]




//  22 * 15

// 탐색 시작점 기준, 도화지가 없을 때 까지 가로 탐색
// 가로는 10이다!
// 탐색이 끝났다면, 세로의 끝까지 내려가 누적합을 구한다.
// 1. 시작점에서 세로 끝까지 .. 10
// 2. 가로 + 1 에서 세로 끝까지 .. 15
// 3. 계속 keep going 최소길이는 10이므로 10*10


// 탐색 시작점 기준, 도화지가 없을 때 까지 가로 탐색
// 가로는 8이다!
// 탐색이 끝났다면, 세로의 끝까지 내려가 누적합을 구한다.
// 1. 시작점에서 세로 끝까지 .. 15
// 2. 가로 + 1 에서 세로 끝까지 .. 15
// 3. 계속 keep going 최소길이는 15이므로 15*8


// 0 1 2 3 4
// 1 1 1 1 1

// 100 + 100 + 100 = 300
// 40 +

// 260

// 425

// 3
// 3 7
// 15 7
// 5 2

// (3, 7) -> (13, 17)
// (15, 7) -> (25, 17)
// (5, 2) -> (15, 12)


// (3, 7), (3, 17), (13, 7), (13, 17)
// (15, 7), (15, 17), (25, 7), (25, 17)
// (5, 2), (5, 12), (15, 2), (15, 12)

//     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
//  0 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  1 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  2 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  3 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  4 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  5 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  6 [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//  7 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
//  8 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
//  9 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 10 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 11 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 12 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 13 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 14 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 15 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 16 [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0]
// 17 [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]


//30
//30 65
//57 42
//41 3
//53 84
//58 29
//10 56
//45 20
//81 32
//30 83
//79 20
//28 88
//30 25
//86 58
//16 20
//66 69
//28 34
//2 21
//25 58
//57 73
//12 46
//76 46
//1 84
//51 67
//64 28
//45 2
//41 48
//66 53
//37 46
//11 34
//13 51

//  22 * 15

// 탐색 시작점 기준, 도화지가 없을 때 까지 가로 탐색
// 가로는 10이다!
// 탐색이 끝났다면, 세로의 끝까지 내려가 누적합을 구한다.
// 1. 시작점에서 세로 끝까지 .. 10
// 2. 가로 + 1 에서 세로 끝까지 .. 15
// 3. 계속 keep going 최소길이는 10이므로 10*10


// 탐색 시작점 기준, 도화지가 없을 때 까지 가로 탐색
// 가로는 8이다!
// 탐색이 끝났다면, 세로의 끝까지 내려가 누적합을 구한다.
// 1. 시작점에서 세로 끝까지 .. 15
// 2. 가로 + 1 에서 세로 끝까지 .. 15
// 3. 계속 keep going 최소길이는 15이므로 15*8