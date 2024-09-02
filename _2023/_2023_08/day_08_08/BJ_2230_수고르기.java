package com.ssafy._2023._2023_08.day_08_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2230_수고르기 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = 0;

        while (e < N) {
            if (arr[e] - arr[s] > M) {
                ans = Math.min(ans, arr[e] - arr[s]);
                s++;
            } else if (arr[e] - arr[s] == M) {
                ans = Math.min(ans, arr[e] - arr[s]);
                break;
            } else {
                e++;
            }
        }

        System.out.println(ans);

    }
}


// 1, 2, 3, 4, 5
// x
//             x