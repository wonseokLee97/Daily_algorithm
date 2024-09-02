package com.ssafy._2024_06.BJ_22857_가장긴짝수연속한부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int l = 0;
        int r = 0;
        int odd = 0;
        int even = 0;

        if (arr[0] % 2 == 0) even++;
        else odd++;

        int max_val = even;
        // 기준:
        // 우측은 움직이고나서 판단 (새로 가는곳이기 때문)
        // 좌측은 판단하고 움직이기 (기존에 있던곳이기 때문)
        while (l <= r) {
            if (odd > K) { // 지운 숫자가 K를 초과한다면
                if (arr[l] % 2 == 0) even--;
                else odd--;
                l++;
            } else {
                r++;

                if (r > N - 1) break;

                if (arr[r] % 2 == 0) even++;
                else odd++;
                max_val = Math.max(max_val, even);
            }
        }

        System.out.println(max_val);
    }
}
