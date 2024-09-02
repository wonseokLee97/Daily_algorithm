package com.ssafy._2023._2023_06.day_06_21;

import java.util.*;
import java.io.*;

public class BJ_13549_숨바꼭질3 {

    static int N, K, dist[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dist = new int[21];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijikstra(N);

        // System.out.println(Arrays.toString(dist));
        System.out.println(dist[N]);
        System.out.println(dist[K]);
    }

    public static void dijikstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int now_node = q.poll();

            // 3가지 경우..
            // now_node + 1, now_node - 1, now_node * 2

            // 만약 지금 위치에서 1 초를 더했을 때, 해당 지점까지의 도달거리보다
            // 작다면 갱신하자.
            if (now_node + 1 <= 20 && dist[now_node] + 1 < dist[now_node + 1]) {
                dist[now_node + 1] = dist[now_node] + 1;
                // System.out.println(dist[now_node] + 1 + ", " + dist[now_node + 1]);
                q.offer(now_node + 1);
            }

            if (now_node - 1 >= 0 && dist[now_node] + 1 < dist[now_node - 1]) {
                dist[now_node - 1] = dist[now_node] + 1;
                // System.out.println(dist[now_node] + 1 + ", " + dist[now_node - 1]);
                q.offer(now_node - 1);
            }

            if (now_node * 2 <= 20 && dist[now_node] * 2 < dist[now_node * 2]) {
                dist[now_node * 2] = dist[now_node] * 2;
                // System.out.println(dist[now_node] * 2 + ", " + dist[now_node * 2]);
                q.offer(now_node * 2);
            }

            System.out.println(Arrays.toString(dist));
            // System.out.println("===============");
        }
    }
}
