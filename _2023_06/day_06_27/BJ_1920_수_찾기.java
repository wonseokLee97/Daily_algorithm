package com.ssafy._2023_06.day_06_27;

import java.util.*;
import java.io.*;


public class BJ_1920_수_찾기
{
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        ans = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long target = Long.parseLong(st.nextToken());

            int start = 0;
            int end = arr.length;

            while (start < end) {
                int mid = (start + end) / 2;
                // mid가 찾으려는 수 보다 작다면?
                // mid를 키우자. (upper bound)
                if (arr[mid] > target) {
                    end = mid;
                } else {
                    start = mid + 1;
                    ans = mid;
                }
            }

            if (arr[ans] == target) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}