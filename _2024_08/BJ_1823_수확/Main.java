package com.ssafy._2024_08.BJ_1823_수확;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


    }
}

// N = 5
// 1 3 1 5 2
// O       O
// [1] - 2
// 3 - [2]
// [3] - 5
// [1] - 5
// [5]

// 수확을 하였을 때 얻을 수 있는 이익은 다음과 같다.
// 만약에 그 벼의 가치가 v(i)라고 하고 그 벼를 k번째로 수확을 한다고 하면
// v(i) × k 만큼의 이익을 얻게 된다.