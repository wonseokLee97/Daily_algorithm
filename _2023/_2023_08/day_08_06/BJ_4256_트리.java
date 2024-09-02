package com.ssafy._2023._2023_08.day_08_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4256_트리 {
    class Node {
        int now;
        int left;
        int right;

        public Node(int now, int left, int right) {
            this.now = now;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        // 1~n 노드
        int n = Integer.parseInt(br.readLine());
        int[] preorder = new int[n];
        int[] inorder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }


    }

    static void pre(Node v) {

        if (v.left != 0) {

        }
    }
}

// 전위순회는 루트 노드를 기준으로 좌, 우 탐색이다.
// 우, 좌로 다시 찾아나서

// 전위순회 (가-왼-오)
// 3,6,5,4,8,7,1,2
// 루트노드는 3, 3의 left 자식은 6인것 까지 알 수 있음
// 6의 오른쪽 자식이 4인것을 알 수 있음

// 중위순회 (왼-가-오)
// 5,6,8,4,3,1,2,7
// 가장 왼쪽 리프노드가 5인것을 알 수 있음. 6은 5의 부모임
//

// 2,1,7 // 8,4,5,6 // 3
// 2번 노드는 가장 오른쪽에 있는 리프노드
// 1번 노드는 2번 노드의 부모
// 1번 노드는
