package com.ssafy.day_220803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1873_상호의배틀필드_이원석 {
    static int way = -1; // 0,1,2,3 상하좌우
    static int[] sp;
    static int T = 0;
    static int H = 0;
    static int W = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            char[][] arr = new char[H][W];

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                char[] get = s.toCharArray();
                for (int j = 0; j < W; j++) {
                    switch (get[j]) {
                        case '^':
                            sp = new int[]{i, j};
                            way = 0;
                            break;
                        case 'v':
                            sp = new int[]{i, j};
                            way = 1;
                            break;
                        case '<':
                            sp = new int[]{i, j};
                            way = 2;
                            break;
                        case '>':
                            sp = new int[]{i, j};
                            way = 3;
                            break;
                    }
                    arr[i][j] = get[j];
                }
            }
            int N = Integer.parseInt(br.readLine());
            char[] act = br.readLine().toCharArray();

            mission(act, arr);

            System.out.printf("#%d ", t);
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
        }
    }

    public static void mission(char[] act, char[][] arr) {
        for (char c : act) {
            if (c == 'S') {
                shoot(arr);
            } else {
                move(c, arr);
            }
//            System.out.println("====" + c);
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < W; j++) {
//                    System.out.print(arr[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
//        System.out.println();
    }

    /** shooting */
    public static void shoot(char[][] arr) {
        int x = sp[0];
        int y = sp[1];

        switch (way) {
            case 0: // 상
                while (x > 0) { // 맵 범위 끝까지
                    if (arr[x - 1][y] == '*') { // 벽돌
                        arr[x - 1][y] = '.';
                        break;
                    } else if (arr[x - 1][y] == '#') { // 강철
                        break;
                    } else { // 벽 이외
                        x--;
                    }
                }
                break;
            case 1: // 하
                while (x < H - 1) {
                    if (arr[x + 1][y] == '*') { // 벽돌
                        arr[x + 1][y] = '.';
                        break;
                    } else if (arr[x + 1][y] == '#') { // 강철
                        break;
                    } else { // 벽 이외
                        x++;
                    }
                }
                break;
            case 2: // 좌
                while (y > 0) {
                    if (arr[x][y - 1] == '*') { // 벽돌
                        arr[x][y - 1] = '.';
                        break;
                    } else if (arr[x][y - 1] == '#') { // 강철
                        break;
                    } else { // 벽 이외
                        y--;
                    }
                }
                break;
            case 3: // 우
                while (y < W - 1) {
                    if (arr[x][y + 1] == '*') { // 벽돌
                        arr[x][y + 1] = '.';
                        break;
                    } else if (arr[x][y + 1] == '#') { // 강철
                        break;
                    } else { // 벽 이외
                        y++;
                    }
                }
                break;
        }
    }

    public static void move(char c, char[][] arr){
        switch (c) {
            case 'U': // 상
                way = 0;
                arr[sp[0]][sp[1]] = '^';

                if (sp[0] - 1 >= 0) {
                    if (arr[sp[0] - 1][sp[1]] == '.') { // 평지라면
                        arr[sp[0] - 1][sp[1]] = '^';
                        arr[sp[0]][sp[1]] = '.';
                        sp[0]--;
                    } else { // 평지가 아니라면
                        break;
                    }
                }
                break;
            case 'D': // 하
                way = 1;
                arr[sp[0]][sp[1]] = 'v';

                if (sp[0] + 1 < H) {
                    if (arr[sp[0] + 1][sp[1]] == '.') { // 평지라면
                        arr[sp[0] + 1][sp[1]] = 'v';
                        arr[sp[0]][sp[1]] = '.';
                        sp[0]++;
                    } else { // 평지가 아니라면
                        break;
                    }
                }
                break;
            case 'L':
                way = 2;
                arr[sp[0]][sp[1]] = '<';

                if (sp[1] - 1 >= 0) {
                    if (arr[sp[0]][sp[1] - 1] == '.') { // 평지라면
                        arr[sp[0]][sp[1] - 1] = '<';
                        arr[sp[0]][sp[1]] = '.';
                        sp[1]--;
                    } else { // 평지가 아니라면
                        break;
                    }
                }
                break;
            case 'R':
                way = 3;
                arr[sp[0]][sp[1]] = '>';

                if (sp[1] + 1 < W) {
                    if (arr[sp[0]][sp[1] + 1] == '.') { // 평지라면
                        arr[sp[0]][sp[1] + 1] = '>';
                        arr[sp[0]][sp[1]] = '.';
                        sp[1]++;
                    } else { // 평지가 아니라면
                        break;
                    }
                }
                break;
        }
    }
}



//#98 ..*-.#-..*...#.*.
//*##....#......-..
//...*..*......*...
//..*#.-..*-.-..#*.
//-...#..*........*
//*<#.**.-*....--*.
//..............-..
//*#-..*-*..*.*..*.
//.*..-.*-.*.*...**
//....*#.#***##*...
//.#...#*.#...*....
//*.#.*#...*.*.-...

//#98 ..*-.#-..*...#.*.
//*##....#......-..
//...*..*......*...
//..*#.-..*-.-..#*.
//-...#..*........*
//*<#.**.-*....--*.
//..............-..
//*#-..*-*..*.*..*.
//.*..-.*-.*.*...**
//....*#.#***##*...
//.#...#*.#...*....
//*.#.*#...*.*.-...

