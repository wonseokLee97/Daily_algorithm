package com.ssafy._2024._03.day_03_22.day_03_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_1665_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int max_poll = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            pq.offer(n);


            if (i == 0) {
                ans.append(n + "\n");
                continue;
            }

            // 홀수인경우
            if (i % 2 == 0) {
                System.out.println(pq + " 길이가 홀수여");
                System.out.println(pq.peek() + " : " + max_poll);
                ans.append(Math.max(pq.peek(), max_poll) + "\n");
//                System.out.println(Math.max(pq.peek(), max_poll));
            } else { // 짝수인 경우
                int now_poll = pq.poll();
                System.out.println(pq);
                if (max_poll == 0) {
                    max_poll = now_poll;
                } else {
                    if (max_poll < now_poll) {
                        max_poll = now_poll;
                    }
                }

                System.out.println(pq.peek() + " : " + max_poll);
//                System.out.println(Math.min(pq.peek(), max_poll));
                ans.append(Math.min(pq.peek(), max_poll) + "\n");
            }
        }

        System.out.println(ans);
    }
}

// 1, 5, 2, 10, -99, 7, 5

// 1 (peeK) - 1
// 1

// 2(poll, peek) - 1 /  poll = 1
// (1) 5

// 3(peek) - 2
// (1) 2 5

// (2와 5를 비교)
// 4(poll, peek) - 2 / poll = 2
// (1 2) 5 10

// 5(peek) - 2 / (
// -99 (1 2) 5 10
// 1 (1 2) 5 10

// 이전에 poll 했던 놈보다 지금 poll 한 놈이 작으면 무시 (2, 5를 비교)
// 6(poll, peek) - 2 / poll = -99
// (-99  1  2)  5  7  10

// 7(peek) - 5
// (-99  1  2)  5  5  7  10

// 1 - 1
// 1 5 - 1
// 1 3 5 - 3
// -2 1 3 5 - 1



// 8(poll, peek)
// (-99  1  2  5)  6  7  9  10

// -99 -99  1  1  2  2  5  10

// 1, 5, 2, 10, -99, 7, 5
// 1 - 1
// 1, 5 - 1 1
// 1, 5, 2 - 1 1 2
// 1, 5, 2, 10 - 1 1 2 2
// 1, 5, 2, 10, -99
// -99, 1, 2, 5, 10
// - 1 1 2 2 2

// -99, 1, 2, 5, 7, 10
// - 1 1 2 2 2

//4
//2
//3
//4
//1

//10
//999
//1234
//5
//1
//-51
//-688
//51
//0
//2347
//9999

// 999 - 999
// 999 1234 - 999
// 5 999 1234 - 999
// 1 5 9999 1234 - 5
// -51 1 5 9999 1234 - 5