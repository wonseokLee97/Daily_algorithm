package com.ssafy.day_220804;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164_카드2_이원석 {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt(); // 1 ~ n card
    static Queue<Integer> q = new LinkedList<>(); // Queue

    public static void main(String[] args) {
        card(); // card 로직 수행
    }

    public static void card() {
        // q에 카드 add
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }

        // 카드가 한장 남을때 까지
        while (q.size() != 1) {
            q.poll(); // 제일 위 카드 버리기
            q.add(q.poll()); // 제일 위 카드 밑으로 옮기기
        }
        System.out.println(q.poll());
        return;
    }
}
