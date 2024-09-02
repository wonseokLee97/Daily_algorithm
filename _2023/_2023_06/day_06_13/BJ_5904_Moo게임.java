package com.ssafy._2023._2023_06.day_06_13;

import java.io.IOException;
import java.util.Scanner;

public class BJ_5904_Moo게임 {

    public static char answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Moo(N);
        System.out.println(answer);
    }

    // size : N보다 큰 Moo 수열의 길이
    // index : 늘어나는 가운데 Moo 뒤의 + "o" 의 개수
    //
    public static void Moo(int N){
        int size = 3;
        int index = 1;

        // 1: m, 2: o, 3: o
        if(N == 1){
            answer = 'm';
        } else if(N <= 3)
            answer = 'o';
        else{
            // N보다 커질 때 까지 수열 size up
            while(size < N){
                // K가 최소 1 이상, index 1부터 시작
                // S(K) = S(K - 1) + Mo..o + S(K - 1);
                size = size + index + 3 + size;
                index++;
            }

            // S(1) = "m o o m o o o m o o" - 10
            // S(2) = "/ m o o m o o o m o o / m o o o o / m o o m o o o m o o /" - 25

            // 이전 수열의 길이 <= (S(K-1) * 2 - (가운데 Moo)) / 2
            int front_back = (size - index - 2) / 2;

            // 전체 길이에서 가장 오른쪽 Moo 수열안에 포함되면 재귀
            // 2번째 S(X-1) 안에 있다면 재귀
            if (size - front_back + 1 <= N) {
                // 찾으려는 위치 + 이전 수열 - 전체 수열 => 오른쪽 Moo 수열로 범위를 좁히면서 idx도 줄인다.
                Moo(N - size + front_back);
            }
            // 1번째 S(X-1) 다음으로 오는 m의 위치 (이전수열 + 1)
            else if (N == front_back + 1)
                answer = 'm';
            // 이전 수열보다 size 가 같거나 큰 경우까지 구했기 때문에 이 외의 경우는 "o"
            // front_back < N
            else
                answer = 'o';
        }
    }
}


//
// S(k) = S(K-1) + "mo...o" + S(K-1)
// S(1) = S(0) +"mooo" _ S(0)

// num = 11
// size = 3x2 + 0+4 = 10
// index = 1;

// size = 20 + 5 = 25
// index = 2;

// (size - index - 3) / 2
//

// 25 - 2 - 3 / 2 -> 10

// 25 - 10 + 1 <= 11
// 16 <= 11 x
// 11 ==

//S(0) = "m o o" - 3
//S(1) = "m o o m o o o m o o" - 10
//S(2) = "/ m o o m o o o m o o / m o o o o / m o o m o o o m o o /" - 25

// 25 - 10 + 1 (size - 이전수열 + 1) -> 2번째 S(X-1) 안에 있다면 재귀
// 10 + 1 (size + 1) -> 1번째 S(X-1) 다음으로 오는 m의 위치
// 이전 수열보다 size 가 같거나 큰 경우까지 구했기 때문에 이 외의 경우는
// frontback = 10 + 11
// size = -25
