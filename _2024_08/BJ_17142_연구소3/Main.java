package com.ssafy._2024_08.BJ_17142_연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Virus {
    int x;
    int y;
    int time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Virus{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }
}

public class Main {
    static List<Virus> virusList, infectList;
    static int total, empty, arr[][], N, M, visited[], minTime, maxTime, ans, visited2[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ans = Integer.MAX_VALUE;

        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 바이러스인경우
                if (arr[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                } else if (arr[i][j] == 0) {
                    empty++;
                }
            }
        }

        visited = new int[virusList.size()];

        if (empty == 0) {
            System.out.println(0);
            return;
        }

        comb(0, 0);

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void comb(int start, int cnt) {
        if (cnt == M) {
            total = 0; // 빈 공간의 개수
            infectList = new ArrayList<>();

            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 1) {
                    infectList.add(virusList.get(i));
                }
            }

            maxTime = Integer.MIN_VALUE;
            visited2 = new int[N][N];
            infect();


            // 빈 공간을 모두 채웠다면
             if (empty == total) {
                // 모든 칸을 채우는데 걸린 시간중 최소!
                ans = Math.min(ans, maxTime);
            }
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(i, cnt + 1);
            visited[i] = 0;
        }
    }

    static void infect() {
        // 시간이 낮은 순으로 virus를 뽑아!
        PriorityQueue<Virus> pq = new PriorityQueue<>(new Comparator<Virus>() {
            @Override
            public int compare(Virus o1, Virus o2) {
                return o1.time - o2.time;
            }
        });

        for (int i = 0; i < M; i++) {
            Virus virus = infectList.get(i);
            visited2[virus.x][virus.y] = 1;
            pq.offer(virus);
        }

        // 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면
        // 비활성 바이러스가 활성으로 변한다.

        while (!pq.isEmpty()) {
            Virus virus = pq.poll();
            maxTime = Math.max(maxTime, virus.time);
            // 다 채웠으면 걸린시간 찾고 끝내
            if (empty == total) {
                while (!pq.isEmpty()) {
                    Virus v = pq.poll();
                    maxTime = Math.max(maxTime, v.time);
                }
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    // 방문하지 않은 곳 중
                    if (visited2[nx][ny] == 0) {
                        // 빈 공간으로 이동
                        if (arr[nx][ny] == 0) {
                            visited2[nx][ny] = visited2[virus.x][virus.y] + 1;
                            total++;
                            pq.offer(new Virus(nx, ny, virus.time + 1));
                        }
                        // 비활성화 바이러스로 이동
                        else if (arr[nx][ny] == 2) {
                            visited2[nx][ny] = visited2[virus.x][virus.y] + 1;
                            pq.offer(new Virus(nx, ny, virus.time + 1));
                        }
                    }
                }
            }
        }
    }
}
//
//4 1
//1 1 1 1
//1 1 1 1
//1 1 1 1
//2 0 0 2