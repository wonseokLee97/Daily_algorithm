package com.ssafy._2022_1.day_220817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1992_쿼드트리_이원석 {
    static StringBuilder sb;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder("");

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();

            for (int j = 0; j < N; j++) {
                arr[i][j] = chars[j] - '0';
            }
        }

        dfs(0, 0, N);
        System.out.println(sb);
    }

    public static void dfs(int x, int y, int N) {
        int get = validate(x, y, N);
        int div = N / 2;

        if (get == -1) { // 4분할을 해야된다면,
            sb.append("("); // 추가
            // 1사분면 (0~4)(0~4)
            dfs(x, y, div);
            // 2사분면 (0~4)(4~8)
            dfs(x, y + div, div);
            // 3사분면 (4~8)(0~4)
            dfs(x + div, y, div);
            // 4사분면 (4~8)(4~8)
            dfs(x + div, y + div, div);

        } else {
            sb.append(get);
            return;
        }
        sb.append(")");
        return;
    }
    public static int validate(int x, int y, int N) {
        int check = 0;

        check = arr[x][y];
        for (int i = x; i < x + N; i++) {
            for (int j = y; j < y + N; j++) {
                if (arr[i][j] != check) { // 첫 번째 값과 다른 요소가 발견되면 false
                    return -1;
                }
            }
        }
        // 0 혹은 1로만 이루어져있다면 true return
        return check;
    }
}
//8
//00000000
//00000000
//00001111
//00001111
//00011111
//00111111
//00111111
//00111111

//8
//00000001
//00000000
//00000000
//00000000
//00000000
//00000000
//00000000
//00000000