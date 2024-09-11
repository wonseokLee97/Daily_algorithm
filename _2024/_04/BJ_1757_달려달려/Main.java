package com.ssafy._2024._04.BJ_1757_달려달려;

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
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}



// 0 1 2 3 4
// 5 3 4 2 10

// 계속 달리는 경우
// 쉬는 경우

//    0  1  2  3  4  5
// 0  0  0  
// 1  0  5
// 2  0  0
