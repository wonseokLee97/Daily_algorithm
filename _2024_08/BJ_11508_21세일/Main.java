package com.ssafy._2024_08.BJ_11508_21세일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N + 1];
        arr[0] = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        long ans = 0;
        // 0 1 (2) 3 4 (5)
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0) {
                continue;
            }

            ans += arr[i];
        }

        System.out.println(ans);
    }
}


// KSG 편의점에서
// 1. 유제품 3개를 한 번에 산다면
// a, b, c
// 그중에서 가장 싼 것은 무료로 지불하고
// 나머지 두 개의 제품 가격만 지불하면 됩니다.

// 2. 한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불해야 합니다.

// ex) 7개의 유제품이 있어서 각 제품의 가격이 10, 9, 4, 2, 6, 4, 3이고
//     재현이가 (10, 3, 2), (4, 6, 4), (9)로 총 3번
// 10 9 6 4 4 3 2

// 10 9 6, 4 4 3, 2
// 19, 8, 2
//

// 6 5 4 5 5 5
//

// 가장 싼 가격은 할인(가격을 지불하지 않는다).

// 한 번에 3개의 유제품을 사지 않는다면 할인 없이 정가를 지불해야 합니다.