package com.ssafy._2024._06.BJ_9024_두수의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int a;
    int b;
    int gap;

    @Override
    public String toString() {
        return "Node{" +
                "a=" + a +
                ", b=" + b +
                ", gap=" + gap +
                '}';
    }

    public Node(int a, int b, int gap) {
        this.a = a;
        this.b = b;
        this.gap = gap;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int s = 0;
        int e = 1;
        int total = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int diff1 = Math.abs(o1.gap - K);
                int diff2 = Math.abs(o2.gap - K);

                return diff1 - diff2;
            }
        });

        while (s < n) {
            total = arr[s] + arr[e];
            System.out.println(s + ", " + e);
            pq.offer(new Node(s, e, Math.abs(total)));
            if (total >= K || e == n - 1) {
                s++;
            } else {
                if (e < n - 1) {
                    e++;
                }
            }
        }

        for (Node node : pq) {
            System.out.println(node);
        }

        int min_gap = Math.abs(K - pq.peek().gap);
        int cnt = 0;

        while (true) {
            Node node = pq.poll();
            System.out.println(Math.abs(K - node.gap) + ", " + min_gap);
            if (Math.abs(K - node.gap) != min_gap) {
                break;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}

// -7 9 2 -4 12 1 5 -3 -2 0

//  0  1  2  3 4 5 6 7 8 9
// -7 -4 -3 -2 0 1 2 5 9 12
// gap