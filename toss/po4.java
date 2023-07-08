package com.ssafy.toss;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class po4 {

    static int maxSize;
    static String[] actions;
    static Deque<String> recent, back, front;

    public static void main(String[] args) {
        maxSize = 3;
        actions = new String[]{"1", "2", "3", "4", "3"};

        recent = new ArrayDeque<>();
        back = new ArrayDeque<>();
        front = new ArrayDeque<>();

        for (String action : actions) {
            if (!action.equals("B") && !action.equals("F")) {
                // 중복방문?
                if (recent.contains(action)) {
                    recent.remove(action);
                }

                if (recent.peekFirst() != null) {
                    back.addFirst(recent.peekFirst());
                }
                recent.addFirst(action);
                front.pollFirst();
            }

            if (action.equals("B")) {
                if (back.size() >= 1) {
                    String now_node = recent.peekFirst();
                    String back_node = back.pollFirst();
                    recent.pollLast();
                    recent.addFirst(back_node);
                    front.addFirst(now_node);
                }
            }

            if (action.equals("F")) {
                if (front.size() >= 1) {
                    String now_node = recent.peekFirst();
                    String front_node = front.pollFirst();
                    recent.pollLast();
                    recent.addFirst(front_node);
                    back.addFirst(now_node);
                }
            }

//            System.out.println(recent.toString());
//            System.out.println(back.toString());
//            System.out.println(front.toString());
//            System.out.println();
        }

        String[] answer = new String[Math.min(maxSize, recent.size())];
        int idx = 0;

        for (String s : recent) {
            if (idx == maxSize) {
                break;
            }
            System.out.println(s);
            answer[idx++] = s;
        }

        System.out.println(Arrays.toString(answer));
    }
}
