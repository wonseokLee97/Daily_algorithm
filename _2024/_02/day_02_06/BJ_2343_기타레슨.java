package com.ssafy._2024._02.day_02_06;

import java.io.*;
import java.util.*;

public class BJ_2343_기타레슨 {
    static int arr[], M, max_val, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]) start = arr[i];
            end += arr[i];
        }

        bs(start, end);

        System.out.println(ans + "!!");
    }

    static void bs(int s, int e) {
        System.out.println(s + ", " + e + ", " + ((s + e) / 2));
        if (s > e) {
            return;
        }

        int mid = (s + e) / 2;
        int cnt = check(mid);

        System.out.println(cnt);
        System.out.println();

        if (cnt <= M) {
            bs(s, mid - 1);
        } else {
            bs(mid + 1, e);
        }

        ans = s;
    }

    static int check(int mid) {
        int sum = 0;
        int cnt = 1;
        max_val = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (sum + arr[i] > mid) {
                cnt++;
                sum = 0;
            }
            sum += arr[i];
        }

        if (sum != 0) cnt++;

        return cnt;
    }
}


// 100 400 300 100 500 101 400
// 500, 400, 500, 101, 400