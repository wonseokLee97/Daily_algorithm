package com.ssafy._2024_06.BJ_20181_꿈틀꿈틀호석애벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int s = 0;
        int e = 1;
        int total = arr[0];
        while (s <= e) {
            if (e == N) {
                break;
            }
            System.out.println("left: " + s + ", right: " + e + ", total: " + total);


            // 에너지 합산이 K 이상인 경우..
            if (total >= K) {
                while (total >= K) {
                    dp[e] += Math.max(dp[e], dp[s] + total - K);
                    total -= arr[s++];
                }

            } else {
                dp[e] = Math.max(dp[e], dp[e - 1]);
                total += arr[e++];
            }

            System.out.println(Arrays.toString(dp));
            System.out.println();
        }

    }
}


// 0 1  2  3  4  5  6 7 8
// 1 5  4  4  2  3 10  3  5
// 1 6 10 14 16 19 29 32 37
// 0 0! 0  2  0! 1 4!  0  2!

// x\y 0 1 2 3 4 5 6 7 9
//  0
//  1
//  2
//  3
//  4
//  5

//9 6
//1 5 4 4 2 3 10 3 5