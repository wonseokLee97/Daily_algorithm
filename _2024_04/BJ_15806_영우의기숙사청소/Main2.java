package com.ssafy._2024_04.BJ_15806_영우의기숙사청소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node2 {
    int x;
    int y;
    int t;

    @Override
    public String toString() {
        return x + ", " + y + ", t: " + t;
    }

    public Node2(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

// 기존좌표에서 8방향으로 뻗어 나간다.
// 좌상: [-1, -2], [-2, -1]
// 우상: [-1, 2], [-2, 1]
// 좌하: [1, -2], [2, -1]
// 우하: [1, 2], [2, 1]
public class Main2 {
    static PriorityQueue<Node2> mold_q;
    static List<Node2> list;
    static int dx[] = {-1, -1, -2, -2, 1, 1, 2, 2},
            dy[] = {-2, 2, -1, 1, -2, 2, -1, 1},
            arr[][],
            N, M, K, t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        list = new ArrayList<>();

        mold_q = new PriorityQueue<>(new Comparator<Node2>() {
            @Override
            public int compare(Node2 o1, Node2 o2) {
                return o1.t - o2.t;
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            arr[x][y] = 1;
            mold_q.add(new Node2(x, y, 0));
        }

        bfs();

        int flag = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (arr[x][y] == 1) {
                flag = 1;
                break;
            }
        }

        if (flag == 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }


        System.out.println();
        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int n : ints) {
                if (n == 1) {
                    sb.append("■ ");
                } else {
                    sb.append("□ ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        int time = 0;
        while (!mold_q.isEmpty()) {
            List<Node2> now_molds = new ArrayList<>();
            System.out.println(time + " 초!");
            StringBuilder sb = new StringBuilder();
            for (int[] ints : arr) {
                for (int n : ints) {
                    if (n == 1) {
                        sb.append("■ ");
                    } else {
                        sb.append("□ ");
                    }
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.out.println();

            while (true) {
                Node2 peek = mold_q.peek();
                if (peek.t >= t) {
                    return;
                } else if (peek.t == time) {
                    Node2 mold = mold_q.poll();
                    arr[mold.x][mold.y] = 0;
                    now_molds.add(mold);
                }

                if (mold_q.isEmpty()) {
                    break;
                }
            }

            for (Node2 mold : now_molds) {
                for (int i = 0; i < 8; i++) {
                    int nx = mold.x + dx[i];
                    int ny = mold.y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (arr[nx][ny] == 1) {
                            continue;
                        }

                        arr[nx][ny] = 1;
                        mold_q.offer(new Node2(nx, ny, mold.t + 1));
                    }
                }
            }

            time++;
        }
    }
}

//9 2 1 1
//5 5
//4 3

// 원래의 곰팡이 위치를 저장하자.
// 하루가 지난 뒤의 곰팡이를 증식시켜야 함.


//10 2 4 10
//1 1
//2 1
//2 3
//2 2
//3 3
//4 1