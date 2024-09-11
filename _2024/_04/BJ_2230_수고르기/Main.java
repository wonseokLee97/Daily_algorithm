package com.ssafy._2024._04.BJ_2230_수고르기;

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
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);


        int s = 0;
        int e = 1;
        int min_gap = Integer.MAX_VALUE;

        while (e < N) {
            int gap = Math.abs(arr[s] - arr[e]);
            if (gap >= M) {
                s++;
                min_gap = Math.min(min_gap, gap);
            } else if (gap == M){
                min_gap = gap;
                break;
            } else {
                e++;
            }
        }

        System.out.println(min_gap);
    }
}


//5 3
//1
//2
//3
//4
//5