package com.ssafy._2023._2023_06.day_06_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1300_K번째_수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;

        int[] arr = new int[k];
        int[] arr2 = new int[k];

        for (int i = 0; i < k; i++) {
            arr2[i] = i + 1;
        }

        while (start < end) {
            int mid = (start + end) / 2;


            int total = 0;
            for (int i = 1; i <= N; i++) {
                total += Math.min(N, mid / i);
            }

//            System.out.println(start + ", " + end);
//            System.out.println(mid + ", " + total);
//            System.out.println("=================");
            System.out.println(mid + ", " + total);

            arr[mid - 1] = total;
            // B[7] = 8;
            // B[]
            // 3단 기준
            // 1 2 3
            // 2 4 6
            // 3 6 9
            // [1,2,2,3,3,4,6,6,9]
            // [1,2,3,4,5,6,7,8,9]
            // lower bound
            // total 을 증가시키자!
            if (total < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));

        System.out.println(end);
    }

    // B[7] = x
}

//[0, 0, 0, 0, 6, 6, 8]
//[1, 2, 3, 4, 5, 6, 7]

//[0, 0, 0, 0, 0, 8, 10, 10, 12, 0]
//[1, 2, 3, 4, 5, 6,  7,  8,  9, 10]
// i*j 2차원 행렬에서 1차원 행렬로 변경한 B[k]를 찾아라!
// B[k] = x 라고 할 때..
// x보다 작거나 같은 원소들의 개수가 k라는 뜻이다.
// 1. upper bound 를 사용하자.
// 2. x에 따른 k의 값을 구하면 된다. (ex. x 6일때 k는 11, x가 5일때는 k는 )
// 3. 그렇다면 x에 따른 k의 값은 어떻게 구할까..
// 4. 1 ~ n단에 대한 x 이하의 개수를 구하면 된다.
// 5. x/1 ... x/n 들의 총 합이 그 개수가 된다.
// 6. 그 이유는.. 1단에서 5이하의 개수는 5/1개
//    2단에서 5이하의 개수는 5/2개 (5를 2봉지씩 묶으면 총 2개가 나오는 원리)
// 이 총합이 k인 경우들에 대해서 구하자.

