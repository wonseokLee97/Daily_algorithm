package com.ssafy._2024_07.BJ_1613_역사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max_val = Integer.MAX_VALUE / 2;
        int[][] arr = new int[n + 1][n + 1];

        for (int[] ints : arr) {
            Arrays.fill(ints, max_val);
        }


        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
        }

        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][l] + arr[l][j]);
                }
            }
        }

        int s = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start < 1 || end < 1 || start > n || end > n) {
                sb.append(0);
                continue;
            }

            if (arr[start][end] == max_val) {
                if (arr[end][start] != max_val) { // e -> s (1)
                    sb.append(1);
                } else { // 모른다 - (0)
                    sb.append(0);
                }
            } else {
                sb.append(-1);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}


// 2 4인 경우, 2에서 4로 갈 수 있는가?
// 1. 갈 수 있다. - 1
// 2. 갈 수 없다. - (-1)
// 3. 모른다. - (0)
//

//   0 1 2 3 4 5
// 0 0 0 0 0 0 0
// 1 0 0 1 1 0 0
// 2 0 0 0 1 1 0
// 3 0 0 0 0 1 0
// 4 0 0 0 0 0 0
// 5 0 0 0 0 0 0

// 1 - x - 4

//5 5
//1 2
//1 3
//2 3
//3 4
//2 4
//3
//3 2
//2 4
//3 1