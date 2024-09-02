package com.ssafy._2023._2023_05.day_05_10;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PG_두큐합_같게_만들기 {
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.solution(new int[] {1, 1}, new int[] {1, 5}));
    }
}

// [1, 2, 1, 2], [1, 10, 1, 2] 각각 sum = 6, 14 이다.
// 각각의 합을 10으로 만들어야함.
// 1. q1은 4가 필요하다.
// 1-1. 1을 가져온다.(1) 4보다 작음
// 1-2. 10을 가져온다.(11) 4보다 큼
// 2. [1, 2, 1, 2, 1, 10] [1, 2]
// 3. q2는 7이 필요하다.
// 3-1. 1을 가져온다.(1) 7보다 작음
// 3-2. 2를 가져온다.(3) 7보다 작음
// 3-3. 1을 가져온다.(4) 7보다 작음
// 3-4. 2를 가져온다.(6) 7보다 작음
// 3-5. 1을 가져온다.(7) 과 같음.


class Solution {
    static ArrayDeque<Integer> queue1, queue2;
    static long sum1, sum2, require;

    public int solution(int[] q1, int[] q2) {
        sum1 = Arrays.stream(q1).sum();
        sum2 = Arrays.stream(q2).sum();
        require = (sum1 + sum2) / 2;

        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();

        for (int a : q1) {
            queue1.add(a);
        }
        for (int b : q2) {
            queue2.add(b);
        }

        return calc();
    }

    public static int calc() {
        int cnt = 0;

        while (true) {
            if (sum1 > sum2) {
                int a = queue1.pop();
//                System.out.println(sum1 + ", " + sum2 + ", " + a);

                queue2.add(a);
                sum1 -= a;
                sum2 += a;
                cnt++;

            } else if (sum1 < sum2){
                int b = queue2.pop();
//                System.out.println(sum1 + ", " + sum2 + ", " + b);

                queue1.add(b);
                sum1 += b;
                sum2 -= b;
                cnt++;

            } else  {
                return cnt;
            }

            if (cnt > (queue1.size() + queue2.size()) * 2) {
                return -1;
            }
        }
    }
}