package com.ssafy._2023._2023_03.day_03_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2473_세_용액 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long[] ans = new long[3];
        long min_val = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int s = i + 1, e = N - 1;
            long sum;

            while (s < e) {
                sum = arr[s] + arr[e] + arr[i];

//                System.out.println(arr[s] + ", " + arr[e] + ", " + arr[i]);
//                System.out.println(sum + ", " + min_val);

                if (Math.abs(sum) < min_val) {
                    min_val = Math.abs(sum);
                    ans[0] = arr[s];
                    ans[1] = arr[e];
                    ans[2] = arr[i];

                    if (sum == 0) {
                        break;
                    }
                }

                // 양수인 경우 수를 감소시키자!
                if (sum > 0) {
                    e--;
                } else {
                    s++;
                }
            }
        }

        Arrays.sort(ans);

        for (long i : ans) {
            System.out.print(i + " ");
        }
    }
}

// [-97, -6, -2, 6, 98]
// arr[s] + arr[e]
//
// 어떻게 더해줘야 할까? 씨발!
//