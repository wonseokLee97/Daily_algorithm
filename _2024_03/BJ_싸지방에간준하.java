package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int P;
    int Q;
    int idx;

    Node(int P, int Q) {
        this.P = P;
        this.Q = Q;
    }

    @Override
    public String toString() {
        return P + ", " + Q;
    }
}

public class BJ_싸지방에간준하 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 현재 있는 사람
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.Q - o2.Q;
            }
        });

        // 내보내야 하는 사람
        PriorityQueue<Node> pq2 = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.idx - o2.idx;
            }
        });

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            list.add(new Node(P, Q));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.P - o2.P;
            }
        });

        int room = 0;
        int[] visited = new int[N];
        for (Node cur : list) {

            while (!pq.isEmpty() && pq.peek().Q < cur.P) {
                // 지금 사용하려는 사람이, 사용하는 사람들 중 끝나는 시간보다 크면
                // 내보낼 사람에 추가.
                pq2.add(pq.poll());
            }

            int now_room = 0;
            // 내보내야 하는 사람이 없다면
            if (pq2.isEmpty()) {
                // 현재 자리에 앉아.
                now_room = room++;
            } else {
                // 나간사람 자리에 앉아.
                Node out = pq2.poll();
                now_room = out.idx;
            }

            // 현재 컴퓨터를 사용하려는 사람을 기록
            visited[now_room]++;
            cur.idx = now_room;
            pq.add(cur);
        }


        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                continue;
            }

            cnt++;
            sb.append(visited[i] + " ");
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}

// [기준]
// 1. 현재 사용하고 있는 사람
// 2. 사용이 끝난 사람
// 3. 이제 사용할 사람

// 이제 사용할 사람을 순회한다 (시작 시간 기준으로)
// 사용할 사람은 먼저 현재 사용이 끝난 사람이 있는지 확인한다.
// 1. 사용이 끝난 사람이 있다면
// 내보낼 사람을 꺼내고 그 사람의 자리에 앉는다.
// 2. 사용이 끝난 사람이 없다면
// 현재 자리에 앉는다.


//                 80  90 - 4
//            60           110 - 2
//     30            70 - 3
//   20     50 - 2
// 10                   100 - 1


// [80, 90]


//     30                     120 - 4
//            60           110 - 3
// 10                   100 - 2
//                 80 90 - 1
//   20     50 - 1

// 자리가 있거나, 종료했거나


//7
//0 20
//3 10
//5 17
//7 13
//8 15
//14 25
//16 30

