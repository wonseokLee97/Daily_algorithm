package com.ssafy._2023_02.day_2023_02_20;

// 에너지 구슬 하나를 고른다. 고른 에너지 구슬의 번호를 x라고 한다. 단, 첫 번째와 마지막 에너지 구슬은 고를 수 없다.
// x번째 에너지 구슬을 제거한다.
// Wx-1 × Wx+1의 에너지를 모을 수 있다.
// N을 1 감소시키고, 에너지 구슬을 1번부터 N번까지로 다시 번호를 매긴다. 번호는 첫 구슬이 1번, 다음 구슬이 2번, ... 과 같이 매겨야 한다.


// 3번째 구슬을 고른다면.. 2번째 x 4번째 구슬의 에너지를 모을 수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_16198_에너지_모으기 {
    static int N, MAX_VAL, sum_val;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        MAX_VAL = Integer.MIN_VALUE;
        sum_val = 0;
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }


        dfs(0);
        System.out.println(MAX_VAL);
    }


    // 백트래킹
    // 1. 처음과 마지막을 제외한 인덱스로 접근한다.
    // 2.
    public static void dfs(int sum_val) {
        if (arr.size() <= 2) {
            MAX_VAL = Math.max(MAX_VAL, sum_val);
            return;
        }


        for (int i = 1; i < arr.size() - 1; i++) {
            int val = arr.get(i - 1) * arr.get(i + 1);

            int remove = arr.remove(i);
            dfs(sum_val + val);
            arr.add(i, remove);
        }
    }
}

//8
//10 7 8 9 10 2 4 13

// 10 8 9 10 2 4 13
// 10 8 10 2 4 13 , 80
// 10 10 2 4 13 , 180
// 10 10 4 13 , 220
// 10 4 13 , 350
// 10 13 , 480