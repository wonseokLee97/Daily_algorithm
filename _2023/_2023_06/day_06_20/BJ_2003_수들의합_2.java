package com.ssafy._2023._2023_06.day_06_20;

import java.util.*;
import java.io.*;

public class BJ_2003_수들의합_2 {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s_idx = -1;
        int e_idx = -1;
        int total = 0;
        int cnt = 0;

        // 시작점이 배열의 끝 점에 도달할 때 까지..
        while (s_idx < N - 1) {
            // 총 합이 M보다 같거나 크다면 or 끝 점이 배열의 끝 점에 도달했다면
            if (total >= M || e_idx == N - 1) {
                // 구간 합의 시작점을 앞으로 이동하자. (값을 감소시킴)
                total -= arr[++s_idx];
            }
            // 총합이 M 보다 작다면
            else if (total < M) {
                // 구간 합의 시작점을 뒤로 이동하자. (값을 증가시킴)
                total += arr[++e_idx];
            }

            // 총 합을 M과 비교.
            if (total == M) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

//

// 시작, 끝 지점을 -1로 두고
// 끝 지점까지의 합이 M보다 작을경우?
// 끝점을 증가시킨다.
// 끝 지점까지의 합이 M보다 큰 경우?
// 시작 지점을 증가시킨다.
// 끝 지점까지의 합이 M과 같은 경우?
// 끝 점을 증가시킨다.