package com.ssafy._2024_06.BJ_10282_해킹;

import javax.management.modelmbean.ModelMBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int computer;
    int depend;
    int time;

    public Node(int computer, int depend, int time) {
        this.computer = computer;
        this.depend = depend;
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Node{");
        sb.append("computer=").append(computer);
        sb.append(", depend=").append(depend);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}

public class Main {
    static List<List<Node>> graph;
    static int n, c, cnt, dist[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴터개수

            dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int computer = Integer.parseInt(st.nextToken());
                int depend = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                graph.get(depend).add(new Node(computer, depend, time));
            }

            dijikstra(c);
        }
    }

    static void dijikstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.time - o2.time;
            }
        });

        pq.offer(new Node(start, 0, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();

            List<Node> next_nodes = graph.get(now_node.computer);
            for (Node next_node : next_nodes) {
                if (dist[next_node.computer] > dist[now_node.computer] + next_node.time) {
                    dist[next_node.computer] = dist[now_node.computer] + next_node.time;
                    pq.offer(next_node);
                }
            }
        }

        cnt = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                cnt++;
                ans = Math.max(ans, dist[i]);
            }
        }

        System.out.println(cnt + " " + ans);


    }
}

// a - b 인 경우 a가 감염되고 t이후 b도 감염됨.
// a x b 인 경우 a가 감염되어도 b는 안전하다.

// 2 1 5 - 1가 감염되고 5초 이후 2도 감염됨.
// 3 2 5 - 2가 감염되고 5초 이후 3도 감염됨.

// 3 <- 2 <- 1