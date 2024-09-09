package com.ssafy._2024_09.BJ_16162_가희와3단고음;

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
        int A = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int after = A;
        for (int i = 0; i < N; i++) {
            if (arr[i] == after) {
                cnt++;
                after += D;
            }
        }

        System.out.println(cnt);
    }
}

// N A D
// 3 1 2
// 1 3 5
// 1 3 5
