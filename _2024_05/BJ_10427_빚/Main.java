package com.ssafy._2024_05.BJ_10427_빚;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);


            long[] preSum = new long[N + 1];
            for (int i = 1; i < N + 1; i++) {
                preSum[i] = preSum[i - 1] + arr[i - 1];
            }

            long ans = 0L;

            // S(i)
            for (int M = 2; M <= N; M++) {
                long min_val = Long.MAX_VALUE;
                for (int j = 0; j <= N - M; j++) {
                    min_val = Math.min(min_val, arr[(M - 1) + j] * M - (preSum[M + j] - preSum[j]));
                }
                ans += min_val;
            }

            System.out.println(ans);
        }
    }
}


// 김우현 연구소가 민균이에게 M번 (1 ≤ M ≤ N) 의 빚을 갚으라고 명령하면,
// 민균이는 N번중 아무렇게나 M 번을 고르고,
// 고른 것 중에서 가장 많은 돈을 빌렸을 때 빌린돈 x M 을 갚아야 한다.

// 갚아야 하는 돈 = 빌린 돈 + 추가적으로 갚아야 할 돈
// 추가적으로 갚아야 할 돈 = 갚아야 하는 돈 - 빌린 돈

// 만약 S(M)일 때.. M개의 돈 선택해서 갚는다.
// M의 값이 최소가 되려면
// i를 기준으로 arr[i+m]가 최대 배열의 값이고

// S(M)을 구한다. 원본은 m-1에 위치해있다.
// (m-1)원본의 위치를 i씩 이동시켜야 한다. 어디까지? n-m까지.
// ex) n이 5고 m이 2면 원본은 1 (n-m = 3)
// 1+3 (4)가 원본이 될 수 있는 가장 마지막
// ex) n이 5고 m이 3면
// 원본이 2일때.. (n-m = 2) / 0,1,2 / 1,2,3 /
// 3+i의 누적합을 구해야되는데 3+i는 N보다 작아야 해. 따라서



// 그 최대 배열의 값을 기준으로  (i+m) - (i)
//1
//1 1