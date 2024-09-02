package com.ssafy._2024_06.BJ_20665_독서실거리두기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    String s;
    String e;

    public Node(String s, String e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {
    static int visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < T; i++) {
            String[] reserving = br.readLine().split(" ");
            String s = reserving[0];
            String e = reserving[1];

            pq.offer(new Node(s, e));
        }


    }

    static void findSeat() {

    }
}


// 1. 사람들은 가장 가까이에 앉아있는 사람이 가장 먼 자리를 선호한다.
// 만약 독서실을 이용하는 사람이 없다면 좌석번호 1번 자리를 가장 선호한다.

// 2. 1번 규칙으로 비교할 수 없다면,
// 가장 먼 좌석들 중에서 좌석 번호가 가장 작은 자리를 선호한다.

// N T P
// 5 6 1
// 0915 0930
// 0940 2040
// 0910 0920
// 2040 2050
// 2043 2047
// 2044 2046

// [0, 0, 0, 0, 0]
//