package com.ssafy._2024_04.BJ_2121_넷이놀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, A, B;
    static List<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }

                return o1.x - o2.x;
            }
        });

        int cnt = 0;
        for (Node node : list) {
            Node n1 = new Node(node.x + A, node.y + B);
            Node n2 = new Node(node.x, node.y + B);
            Node n3 = new Node(node.x + A, node.y);

            if (bs(n1) && bs(n2) && bs(n3)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean bs(Node n) {
        int s = 0;
        int e = N - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            Node now = list.get(mid);

            // 찾으려는 좌표가 있는가?
            // 만약 노드의 x좌표보다 찾으려는 놈이 더 크면
            if (n.x > now.x || (n.x == now.x && n.y > now.y)) {
                s = mid + 1;
            } else if (n.x < now.x || (n.x == now.x && n.y < now.y)) {
                e = mid - 1;
            } else if (n.x == now.x && n.y == now.y) {
                return true;
            }
        }

        return false;
    }
}


// 6
// 2 3

// 0 0
// 2 0
// 2 3
// 0 3
// 4 0
// 4 3

// 0 0
// 0 3
// 2 0
// 2 3
// 4 0
// 4 3

// 특정 점위 위치에서.. [0, 0]이라고 할 때
// 만약 가로가 2, 세로가 3라면
// x.x
// ...
// ...
// x.x
// 특정 점 기준에서 가로+2, 세로+3인 위치의 세 점을 찾았을 때 있으면 성공 ㅋ
// (x+A, y+B)
// (x, y+B)
// (x+A, y)
