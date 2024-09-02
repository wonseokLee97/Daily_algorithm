package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Food {
    int A;
    int B;

    Food(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public String toString() {
        return A + ", " + B;
    }
}

public class BJ_2786_상근이의레스토랑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Food> list = new ArrayList<>();
        List<Integer> gap_list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.add(new Food(A, B));
        }

        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.B - o2.B;
            }
        });

        long[] prefixSum = new long[N + 1];
        int[] gap = new int[N + 1];
        int[] minA = new int[N + 1];
        int min_val = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            Food food = list.get(i - 1);
            prefixSum[i] = prefixSum[i - 1] + food.B;
            gap[i] = food.A - food.B;

            if (list.get(N - i).A < min_val) {
                min_val = list.get(N - i).A;
            }

            minA[N - i + 1] = min_val;
        }

        System.out.println(Arrays.toString(prefixSum));
        System.out.println(Arrays.toString(gap));
        System.out.println(Arrays.toString(minA));
    }
}

// 음식을 처음 시킬때와 그 이후의 가격이 다르다.
// 최소 가격을 출력하자.

// 3개가 있을 때..
// 9 3
// 10 5
// 10 5

// [6, 5, 5]

// 3 5 = 8
// 1) 9 5 = 14
// 2) 3 10 = 13

// 3 5 5 = 13
// 1) 9 5 5 = 19
// 2) 3 10 5 = 18
// 3) 3 5 10 = 18

// A를 기준으로 오름차순 정렬
// 같다면 B를 기준으로 내림차순 정렬

//9 100
//9 3
//10 100
//10 7
//11 4
//100 3


//4
//1 2
//10 5
//9 3
//10 5


// 1개를 시킬 때 최소 가격은..
// 9 3 - 9
// 2개를 시킬 때 최소 가격은..
// 10 5 - 10
// 9 3 - 3
// 13

// 3개를 시킬 때 최소 가격은..
//

//4
//10 5
//9 3
//10 5
//1 10