package com.ssafy._2024_05.BJ_21921_블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        int idx = 0;
        int total = 0;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < X; i++) {
            total += arr[i];
        }
        int max_val = total;



        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(total, 1);

        while ((idx + X) < N) {
            total -= arr[idx]; // 현재 배열 인덱스 값 빼고
            total += arr[idx++ + X]; // 다음+X 배열 인덱스 값 더하고

            max_val = Math.max(max_val, total);

            if (map.containsKey(total)) {
                map.put(total, map.get(total) + 1);
            } else {
                map.put(total, 1);
            }
        }

        if (max_val == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max_val);
        System.out.println(map.get(max_val));
    }
}
