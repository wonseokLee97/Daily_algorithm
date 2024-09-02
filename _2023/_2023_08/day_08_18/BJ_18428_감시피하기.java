package com.ssafy._2023._2023_08.day_08_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_18428_감시피하기 {
    static char arr[][];
    static int N, result, visited[][];
    static List<int[]> list, way;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        visited = new int[N][N];
        list = new ArrayList<>();
        way = new ArrayList<>();
        result = 0;

        way.add(new int[] {1, 0});
        way.add(new int[] {0, 1});
        way.add(new int[] {-1, 0});
        way.add(new int[] {0, -1});

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char c = st.nextToken().toCharArray()[0];
                arr[i][j] = c;

                if (c == 'T') {
                    list.add(new int[]{i, j});
                }
            }
        }


        dfs(0);

        if (result == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            // 학생을 잡지 못했다면
            if (validate()) {
                result = 1;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'X' && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    dfs(cnt + 1);
                    visited[i][j] = 0;
                }
            }
        }
    }

    static boolean validate() {
        for (int[] ints : list) {
            int x = ints[0];
            int y = ints[1];

            // (1, 0), (0, 1), (-1, 0), (0, -1)
            for (int[] w : way) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += w[0];
                    ny += w[1];

                    // 범위 내에서 움직인다.
                    if (nx >= 0 && nx < N && ny >= 0 & ny < N) {
                        // 벽 만나면 끝
                        if (visited[nx][ny] == 1) {
                            break;
                        }
                        // 학생을 만났다면
                        if (arr[nx][ny] == 'S') {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        return true;
    }
}

//[0, 0, 0, 1, 0]
//[0, 1, 0, 0, 0]
//[0, 0, 1, 0, 0]