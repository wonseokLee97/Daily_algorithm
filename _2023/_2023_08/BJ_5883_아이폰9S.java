package com.ssafy._2023._2023_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_5883_아이폰9S {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Integer> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max_val = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int get = Integer.parseInt(br.readLine());
            arr[i] = get;

            if (!list.contains(get)) {
                list.add(get);
            }
        }

        for (int except : list) {
            int len = 1;
            int now = arr[0];

            for (int i = 1; i < N; i++) {
                // 제외한 값은 pass
                if (arr[i] == except) {
                    continue;
                }

                if (now == arr[i]) {
                    len++;
                } else {
                    max_val = Math.max(max_val, len);
                    len = 1;
                }

                now = arr[i];
            }
        }

        System.out.println(max_val);
    }
}

// 2 7 3 7 7 3 7 5 7
// 2, 3, 5, 7



// 2를 뺌
// 7 3 7 7 7 3 7 5 7 - 3
// 3을 뺌
// 2 7 7 7 7 5 7 - 4
// 5를 뺌
// 2 7 3 7 7 3 7 7 - 2
// 7을 뺌
// 2 3 3 5 - 2