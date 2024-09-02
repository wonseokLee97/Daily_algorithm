package com.ssafy._2023._2023_06.day_06_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {

    static int K;
    static long arr[], answer, N, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        bs();
        System.out.println(answer);
    }

    public static void bs() {
        start = 0;
        end = arr[K - 1] + 1;
        long mid;

        while (start < end) {
            // 나눌 랜선길이
            mid = (start + end) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

//            System.out.println("mid: " + mid + ", cnt: " + cnt + ", start: " + start + ", end: " + end);

            // 해당 mid 값으로 랜선을 나누었을 때..
            // N 보다 작은 개수가 나온다면? mid 값을 줄여 더 많이 자르자.
            if (cnt < N) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        answer = start - 1;
    }
}

//mid: 401, cnt: 5, start: 1, end: 802
//mid: 200, cnt: 11, start: 1, end: 400
//mid: 300, cnt: 6, start: 201, end: 400
//mid: 250, cnt: 8, start: 201, end: 299
//mid: 225, cnt: 10, start: 201, end: 249
//mid: 212, cnt: 10, start: 201, end: 224
//mid: 206, cnt: 10, start: 201, end: 211
//mid: 203, cnt: 10, start: 201, end: 205
//mid: 201, cnt: 10, start: 201, end: 202

//mid: 401, cnt: 5, start: 1, end: 802
//mid: 201, cnt: 10, start: 1, end: 401
//mid: 101, cnt: 23, start: 1, end: 201
//mid: 151, cnt: 15, start: 102, end: 201
//mid: 176, cnt: 13, start: 152, end: 201
//mid: 189, cnt: 11, start: 177, end: 201
//mid: 195, cnt: 11, start: 190, end: 201
//mid: 198, cnt: 11, start: 196, end: 201
//mid: 200, cnt: 11, start: 199, end: 201
//200