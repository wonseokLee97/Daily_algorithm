package com.ssafy._2024_07.BJ_10476_좁은미술전시관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 열
        int k = Integer.parseInt(st.nextToken()); // 닫아야하는 방
        int[][] arr = new int[201][2];
        int[][][] dp = new int[202][202][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i][0] = a;
            arr[i][1] = b;
        }


        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // dp[n][k][f] = n번째 행에서 방을 k개를 닫았을 때, 열이 f인 모습일 때의 최대값
        dp[1][1][0] = arr[1][1];
        dp[1][1][1] = arr[1][0];
        dp[1][0][2] = arr[1][1] + arr[1][0];

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                // 1개 이상 닫힌경우
                if (j >= 1) {
                    // F = 0 : ■□ (왼쪽만 닫힘)
                    dp[i][j][0] = Math.max
                            (dp[i - 1][j - 1][0],
                             dp[i - 1][j - 1][2]) + arr[i][1];

                    // F = 1 : □■ (오른쪽만 닫힘)
                    dp[i][j][1] = Math.max
                            (dp[i - 1][j - 1][1],
                             dp[i - 1][j - 1][2]) + arr[i][0];
                }

                // i와 k의 값이 같게되면,
                // ex) 3번째 행에 3번째 방을 닫은경우
                // 말이 안된다. 왜냐하면 2번째 행까지 방을 하나씩 닫을때 3번째 행에 아무것도
                // 닫지 않는 경우 k는 2로 유지되기 때문에
                if (i != k) {
                    // F = 2 : □□ (닫히지 않음)
                    List<Integer> list = new ArrayList<>();
                    list.add(dp[i - 1][j][0]);
                    list.add(dp[i - 1][j][1]);
                    list.add(dp[i - 1][j][2]);

                    Collections.sort(list, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o2 - o1;
                        }
                    });

                    int maxVal = list.get(0);

                    dp[i][j][2] = maxVal + arr[i][0] + arr[i][1];
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(dp[N][k][0]);
        list.add(dp[N][k][1]);
        list.add(dp[N][k][2]);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        System.out.println(list.get(0));
    }
}

//           0  1  2
// 막았을 때   3  1  1  5
// 안막았 떄   4  1  1  6

// 일단 최소만 막는다.
// 1. 그리고 길이 막힌다면 반대쪽을 막는다.
// 2.

// F = 0 : ■□ (왼쪽만 닫힘)
// F = 1 : □■ (오른쪽만 닫힘)
// F = 2 : □□ (닫히지 않음)
//
// dp[n][k][f] = n번째 행에서 방을 k개를 닫았을 때, 열이 f인 모습일 때의 최대값

// F가 0인 경우에서 N-1행은 0이나 2의 F형태가 와야한다.
// dp[n][k][0] = Math.max(dp[n-1][k-1][0], dp[n-1][k-1][2]) + arr[n][1];

// F가 1인 경우에서 N-1행은 1이나 2의 F형태가 와야한다.
// dp[n][k][1] = Math.max(dp[n-1][k-1][1], dp[n-1][k-1][2]) + arr[n][0];

// F가 2인 경우에서는 3가지 형태 모두 가능하다.
// dp[n][k][2] = Math.max(dp[n-1][k-1][0],
//                        dp[n-1][k-1][1],
//                        dp[n-1][k-1][2]) + arr[n][0] + arr[n][1];