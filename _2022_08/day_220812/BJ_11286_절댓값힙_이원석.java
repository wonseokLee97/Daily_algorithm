package com.ssafy.day_220812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11286_절댓값힙_이원석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new PriorityQueue<>(
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int sub = Math.abs(o1) - Math.abs(o2);
                    if (sub == 0) {
                        return o1 - o2;
                    }
                    return sub;
                }
            }
        );

        for (int i = 0; i < N; i++) {
            int get = Integer.parseInt(br.readLine());

            if (get != 0) {
                queue.add(get);
            } else if (get == 0) {
                Integer poll = queue.poll();
                if (poll == null) {
                    System.out.println(0);
                } else {
                    System.out.println(poll);
                }
            }
        }

    }
}
// 절대값이 가장 작은 값을 출력하고 배열에서 제거
// 절대값이 가장 작은 값이 여러개 일 때는, 가장 작은수를 출력

//1
//1
//0
//-2
//-1
//-1
//1
//1
//2
//0

//-1
//1
//0
//-2
//-1
//-1
//1
//1
//2
//0