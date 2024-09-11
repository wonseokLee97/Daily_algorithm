package com.ssafy._2024._04.BJ_1845_배열회전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static final double EARTH_RADIUS = 6370.0; // 지구 반지름 (km)
    static int N; // 공항 수
    static double R; // 최대 허용 거리 (km)
    static ArrayList<Airport> airports; // 공항 정보

    static class Airport {
        double latitude, longitude;

        public Airport(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    static class Edge {
        int to;
        double cost;

        public Edge(int to, double cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseNum = 0; // 테스트 케이스 번호

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            R = Double.parseDouble(st.nextToken());

            if (N == 0 && R == 0) break; // 입력 종료 조건

            caseNum++;
            System.out.println("Case " + caseNum + ":");

            // 공항 정보 입력
            airports = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                double latitude = Double.parseDouble(st.nextToken());
                double longitude = Double.parseDouble(st.nextToken());
                airports.add(new Airport(latitude, longitude));
            }

            int Q = Integer.parseInt(br.readLine()); // 질의 수
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1; // 출발 공항 번호
                int end = Integer.parseInt(st.nextToken()) - 1; // 도착 공항 번호
                int fuel = Integer.parseInt(st.nextToken()); // 연료 용량 (최대 연료 이동할 수 있는 거리)

                double minDistance = dijkstra(start, end, fuel); // 최단 비행 경로 탐색
                if (minDistance >= 0) {
                    System.out.printf("%.3f\n", minDistance);
                } else {
                    System.out.println("impossible");
                }
            }
        }

        br.close();
    }

    // 두 지점 간의 거리 계산 (km)
    static double distance(int a, int b) {
        Airport airportA = airports.get(a);
        Airport airportB = airports.get(b);
        double lat1 = Math.toRadians(airportA.latitude);
        double lon1 = Math.toRadians(airportA.longitude);
        double lat2 = Math.toRadians(airportB.latitude);
        double lon2 = Math.toRadians(airportB.longitude);
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a1 = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a1), Math.sqrt(1 - a1));
        return EARTH_RADIUS * c;
    }

    // 다익스트라 알고리즘을 이용한 최단 비행 경로 탐색
    static double dijkstra(int start, int end, int fuel) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(a.cost, b.cost));
        double[] dist = new double[N];
        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curNode = cur.to;
            double curCost = cur.cost;

            if (curNode == end) return curCost; // 도착 공항에 도달한 경우

            for (int nextNode = 0; nextNode < N; nextNode++) {
                double nextCost = distance(curNode, nextNode);
                if (nextCost > fuel) continue; // 최대 허용 거리를 초과하는 경우 pass
                if (dist[nextNode] > curCost + nextCost) {
                    dist[nextNode] = curCost + nextCost;
                    pq.offer(new Edge(nextNode, curCost + nextCost));
                }
            }
        }

        return -1; // 도착 공항까지의 경로가 존재하지 않는 경우
    }
}
