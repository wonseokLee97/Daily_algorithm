package com.ssafy._2024_05.BJ_13702_이상한술집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        long s = 1;
        long e = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, arr[i]);
        }


        while (s <= e) {
            // 나누어줄 막걸리 용량
            long mid = (s + e) / 2;
            int cnt = 0;


            for (int i : arr) {
                cnt += i / mid;
            }

//            System.out.println(s + ", " + e + ", " + mid + ", " + cnt);

            // 만약 K 명한테 동등하게 나누어줄 수 없다면 나누어줄 막걸리 양을 줄여라
            if (cnt < K) {
//                System.out.println("줄여!");
                e = mid - 1;
            } else { // 막걸리 양을 늘려라.
//                System.out.println("늘려!");
                s = mid + 1;
            }
        }

        System.out.println(e);
    }
}

// 1002, 802, 705
// 1000 800 105 - 1905 (200)
// 802 802 402 - 2006 (401)

// 예를 들어 5명이 3 주전자를 주문하여 1002, 802, 705 ml의 막걸리가 각 주전자에 담겨져 나왔고,
// 이것을 401ml로 동등하게 나눴을 경우 각각 주전자에서 200ml, 0m, 304ml 만큼은 버린다.)
// 이럴 때 K 명에게 최대한의 많은 양의 막걸리를 분배할 수 있는 용량 ml는 무엇인지 출력해주세요.

