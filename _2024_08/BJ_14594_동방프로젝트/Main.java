package com.ssafy._2024_08.BJ_14594_동방프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 동아리 방의 개수
        int M = Integer.parseInt(br.readLine()); // 종빈의 행동 횟수
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        int ans = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tmp = 0;

            for (int j = x; j <= y; j++) {
                // 이미 합쳐진 방이면..
                if (arr[j] != j) tmp = arr[j];

                // 합쳐진 방이 아니라면
                if (tmp == 0) {
                    arr[j] = x;
                }
                // 합쳐진 방이라면, 합쳐진 방의 번호를 넣어주자.
                else {
                    arr[j] = tmp;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (arr[i] == i) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}


// 1 |  2 | 3 | .. | N

// 1 | 2 | 3 | 4 | 5
// 1   2 | 3 | 4 | 5
// 1   2   3   4 | 5

// 0   0   0   0   0
// 1   1   1   1   0

// 1 2 3 4 5 6 7 8 9 10
// 1 1 1 1 2 2 2 2 3  4