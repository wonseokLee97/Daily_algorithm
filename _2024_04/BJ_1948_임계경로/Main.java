package com.ssafy._2024_04.BJ_1948_임계경로;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

class Node {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static List<List<Node>> graph_short, graph_path;
    static int dist[], visited[], cnt, s, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        visited = new int[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MIN_VALUE);

        graph_short = new ArrayList<>();
        graph_path = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph_short.add(new ArrayList<>());
            graph_path.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph_short.get(from).add(new Node(to, cost));
            graph_path.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());


        dijikstraShort();
        dijikstraPath();

        System.out.println(dist[e]);
        System.out.println(cnt);
    }

    static void dijikstraPath() {
        cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(e);
        visited[e] = 0;

        while (!q.isEmpty()) {
            int now_node = q.poll();

            List<Node> next_nodes = graph_path.get(now_node);

            for (Node next_node : next_nodes) {
//                System.out.println("현재 정점: " + now_node + ", 다음 정점: " + next_node.to);
//                System.out.println("비용: " + (dist[now_node] - next_node.cost) + ", 최대비용: " + dist[next_node.to]);
//                System.out.println();
                // 만약, 되돌아갈 때, 경로의 최대비용과 같다면 카운팅 (1분도 쉬지않은 거리)
                // 최대 비용에 맞춰서 간선을 통과하게 되면 그 말은 즉슨 1분도 쉬지 못하고 최대 시간에 딱 맞추는 경로를 찾으라는 말!
                if (dist[now_node] - next_node.cost == dist[next_node.to]) {

                    cnt++;
                    if (visited[next_node.to] == 0) {
                        visited[next_node.to] = 1;
                        q.offer(next_node.to);
                    }
                }
            }
        }
    }

    // [0, 0, 4, 2, 3, 3, 7, 12]

    static void dijikstraShort() {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node now_node = pq.poll();
            int idx = now_node.to;
            int cost = now_node.cost;

            // 최대경로보다 작은 가중치는 제외
            if (dist[idx] > cost) {
                continue;
            }

            List<Node> next_nodes = graph_short.get(idx);

            for (Node next_node : next_nodes) {
                if (dist[next_node.to] < cost + next_node.cost) {
                    dist[next_node.to] = cost + next_node.cost;
                    pq.offer(new Node(next_node.to, dist[next_node.to]));
                }
            }
        }
    }
}
