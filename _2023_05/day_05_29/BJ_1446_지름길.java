package com.ssafy._2023_05.day_05_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BJ_1446_지름길 {

    static class Node implements Comparable<Node> {
        int start_idx;
        int dist;

        @Override
        public String toString() {
            return "Node{" +
                    "start_idx=" + start_idx +
                    ", dist=" + dist +
                    '}';
        }

        public Node(int idx, int dist) {
            this.start_idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.start_idx, o.start_idx);
        }
    }

    static int N, D, dist[];
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        list = new List[10001];

        for (int i = 0; i < 10001; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            // 역주행 불가, 지름길이 아닌 경우..
            if (e > D || e - s <= l) {
                continue;
            }

            list[e].add(new Node(s, l));
        }

        dist = new int[10001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;


        // 한줄정리
        // 시작점을 기준으로 정렬한다. (그래야 도달순으로 최단 경로를 구함)
        // 도착하는 지점 i를 기준으로, 만약 해당 위치까지의 도달 지름길이 더 먼 경우는 continue
        // 도착하는 지점 i를 기준으로
        // 이전 지점에서 + 1 거리와,
        // (i를 도착지점으로 하는 지름길의 시작점의 최소 거리) + (지름길의 거리)
        // 중에서 더 최소 경로를 dist 배열에 저장한다.


        // 도착 지점까지..
        for (int i = 1; i < D + 1; i++) {
            // i에 도착하는 방법들 (Node)중..
            for (Node node : list[i]) {
                // 시작 시점까지의 거리 + 끝 지점 까지의 거리
                // 가 이미 갱신되었다면 (Integer.MAX_VALUE 가 아니거나, 지름길이 더 먼 경우)
                if (dist[node.start_idx] + node.dist > dist[i]){
                    continue;
                }
                dist[i] = Math.min(dist[i - 1] + 1, dist[node.start_idx] + node.dist);
            }

            if (list[i].size() == 0) {
                dist[i] = dist[i - 1] + 1;
            }
        }

        System.out.println(dist[D]);
    }
}
