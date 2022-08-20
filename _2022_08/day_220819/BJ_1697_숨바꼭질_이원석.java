package com.ssafy._2022_08.day_220819;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697_숨바꼭질_이원석{
    static int N, K;
    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 수빈이의 위치
        K = sc.nextInt(); // 동생의 위치
        visited = new int[100001];

        bfs();
        System.out.println(visited[K] - 1);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 1});

        while (!queue.isEmpty()) {
            int[] sujin = queue.poll();
            int N = sujin[0];
            int cnt = sujin[1];

            if (visited[N] != 0) { //
                if (visited[N] < cnt) {
                    continue;
                }
            }
            visited[N] = cnt;

            if (N == K) { // 동생을 찾았다면,
                if (visited[N] == 0) { // 최초로
                    visited[N] = cnt;
                }
                return;

            } else if (N < K) { // 동생을 찾지 못했다면
                if (N <= 50000) {
                    queue.add(new int[]{N * 2, cnt + 1});
                }

                queue.add(new int[]{N + 1, cnt + 1});

                if (N >= 1) {
                    queue.add(new int[]{N - 1, cnt + 1});
                }
            } else { // 동생보다 앞서있다면,
                queue.add(new int[]{N - 1, cnt + 1});
            }
        }
    }
}
