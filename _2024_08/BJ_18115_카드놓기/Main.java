package com.ssafy._2024_08.BJ_18115_카드놓기;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            deque.addFirst(i);
        }

        System.out.println(deque);
    }
}

// 2 3 3 2 1
// 1 2 3 4 5
//

// 1. 제일 위의 카드 1장을 바닥에 내려놓는다.
// R. 제일 아래의 카드 1장을 가장 위에 내려놓는다.

// 2. 위에서 두 번째 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
// R. idx

// 3. 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상일 때만 쓸 수 있다.
// R. 제일 위에 있는 카드를 가장 위에 내려놓는다.

// idx: 1 2 3 4 5
// 최초: (위) 5 4 3 2 1 (아래)

// 기술: 1 1 1 1 1
// 결과: (위) 1 2 3 4 5 (아래)

// stack: 5 4 3 ... 1
//


// 최초: 1 5 2 3 4

// 기술: 2 3 3 2 1
// 결과: 1 2 3 4 5

//