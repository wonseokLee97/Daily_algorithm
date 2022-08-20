package com.ssafy.day_220802;

import java.util.*;

public class BJ_11866_요세푸스문제0_이원석 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();


        // 컬렉션의 큐를 활용한다
        Queue<Integer> q = new LinkedList<>();

        // 1부터 N까지 할당
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        System.out.print("<");
        // 큐가 텅 빌때까지
        while (!q.isEmpty()) {
            // K번째 숫자 전까지 popleft 하여 오른쪽 끝에 add 한다.
            for (int i = 0; i < K - 1; i++) {
                int poll = q.poll();
                q.add(poll);
            }

            // 원소가 마지막 하나 남았을 때는
            if (q.size() == 1) {
                // 출력 조건을 위해 문자열을 생략하고 출력한다.
                System.out.print(q.poll());
            } else {
                // 아닐경우 K번째 숫자에 해당하는 원소를 poll 하고 출력한다.
                System.out.print(q.poll() + ", ");
            }
        }
        System.out.print(">");
    }
}


// 3, 6, 9, 12, 15, 18, 21
// 3, 6, 2, 5

// 1, 2, 3, 4, 5, 6, 7

// 1, 2, 4, 5, 6, 7
// 3
// index = 3

// 1, 2, 4, 5, 7
// 3, 6
// index = 6 - 1 = 5

// 1, 4, 5, 7
// 3, 6, 2
// index = 8 - 1 = 7 % 5 = 2

// 1, 4, 5
// 3, 6, 2, 7
// index = 5 - 1 = 4 // if 4 % 4 = 0 so 0 + 3

// 1, 4
// 3, 6, 2, 7, 5
// index = 3

// 4
// 3, 6, 2, 7, 5, 1
// index =