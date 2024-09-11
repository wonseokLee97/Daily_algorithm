package com.ssafy._2024._04.BJ_19566_수열의구간평균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        long[] sumList = new long[N + 1];
        for (int i = 0; i < N; i++) {
            sumList[i + 1] = sumList[i] + data[i];
        }


        long[] diffList = new long[N + 1];
        for (int i = 0; i < N + 1; i++) {
            diffList[i] = sumList[i] - (long) K * i;
        }


        Map<Long, Integer> diffMap = new HashMap<>();
        for (int i = 0; i < N + 1; i++) {
            long d = diffList[i];
            diffMap.put(d, diffMap.getOrDefault(d, 0) + 1);
        }


        long result = 0;
        for (long d : diffMap.keySet()) {
            int cnt = diffMap.get(d);
            result += (long) cnt * (cnt - 1) / 2;
        }

        System.out.println(result);
    }
}


// 4 2
// 1 3 2 2
// 0 1 4 6 8
// 0 -1 0 0 0

// 0
// 4 (1, 3)
// 6 (1, 3, 2)
// 8 (1, 3, 2, 2)


// 1 -> 1
// 4 -> 2
// 6 -> 2
// 8 -> 2

// 3 -> 3
// 5 -> 2.5
// 7 -> 2.3333..

// 2 -> 2
// 2 2 -> 2

// 2 _> 2

// 1 3
// 1 3 2
// 2 2
// 1 3 2 2
// 2
// 2