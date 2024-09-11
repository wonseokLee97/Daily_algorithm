package com.ssafy._2024._04.BJ_11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 누적합

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum_arr = new int[N];

        sum_arr[0] = arr[0];
        int total = sum_arr[0];

        for (int i = 1; i < N; i++) {
            sum_arr[i] += sum_arr[i - 1] + arr[i];

            total += sum_arr[i];
        }

//        System.out.println(Arrays.toString(sum_arr));
        System.out.println(total);

        // 1 2 3 3 4
    }
}

// 소요시간의 오름차순 정렬후 누적합