package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Problem {
    int A;
    int B;

    Problem(int A, int B) {
        this.A = A;
        this.B = B;
    }
}

public class BJ_1766_문제집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }
        int[] degree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A).add(B);
            degree[B]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            // 진입점이 없는, 먼저 풀 문제가 없는 경우
            if (degree[i] == 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 문제의 난이도 순으로 풀어야하므로 pq
        while (!pq.isEmpty()) {
            int now_node = pq.poll();
            sb.append(now_node + " ");

            List<Integer> list = graph.get(now_node);
            for (int next_node : list) {
                // 현재 문제를 풀었으니 먼저 풀어야하는 문제의 수 degree 감소
                degree[next_node]--;

                // 먼저 풀어야 하는 문제가 없다면 pq에 넣자.
                if (degree[next_node] == 0) {
                    pq.offer(next_node);
                }
            }
        }

        System.out.println(sb);
    }
}

// 1 ~ N .. 총 N개
//N개의 문제는 모두 풀어야 한다.
//먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
//가능하면 쉬운 문제부터 풀어야 한다
// 4 > 2
// 3 > 1

// 난이도 / 뒤에 풀어야 한는 것
//  3      1
//  4      2

//  3      1
//  4      1

// 3 4 1 2

//6 6
//6 5
//6 4
//5 3
//4 2
//3 1
//2 1

// [2, 1, 1, 1, 1, 0]
// 1 - {}
// 2 - {1}
// 3 - {1}
// 4 - {2]
// 5 - {3}
// 6 - {5, 4}

// 1
// [1 4 5]
// 1번 poll
// 4번 poll (2,3이 있다!)
// [2 5]

// [6]
// 6번 poll
// 5와 4가 있다!
// [4, 5]

// 4번 poll
// 2가 있다!
// [2, 5]

// 2번 poll
// 1번이 있다!
// [1, 5]

//

// pq 두개 만드셈.
// 하나는 난이도 저장 -
// 2 3 4 5 6 6
// 하나는 뒤에 풀거 저장 -
// 1 1 2 3 4 5

// 6 4 2 5 3 1

// 먼저 풀어야하는 문제들을 난이도 순으로 오름정렬하자.
// 뒤에 풀어야 하는 문제들도 난이도 순으로 오름정렬하자.

// 난이도 순으로 정렬
// 3 4

// 1 2 3 4