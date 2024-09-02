package com.ssafy._2023._2023_07.day_07_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1963_소수경로 {

    static List<Integer> prime;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        prime = new ArrayList<>();

        for (int i = 1000; i < 10000; i++) {
            int flag = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                prime.add(i);
            }
        }

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A);

            sb.append(visited[B] + "\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int A) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{A, 0});

        visited = new int[10001];
        Arrays.fill(visited, Integer.MAX_VALUE);

        visited[A] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            int num = poll[0];
            char[] c = Integer.toString(num).toCharArray();

            // 각 자리수를
            for (int i = 0; i < 4; i++) {
                // 0 ~ 9까지 바꿔주며
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }

                    StringBuilder sb = new StringBuilder();

                    for (int k = 0; k < 4; k++) {
                        if (i == k) {
                            sb.append((char) (j + '0'));
                        } else {
                            sb.append(c[k]);
                        }
                    }

                    int get = Integer.parseInt(String.valueOf(sb));

                    if (prime.contains(get) && visited[get] > poll[1] + 1) {
                        q.add(new int[] {get, poll[1] + 1});
                        visited[get] = Math.min(visited[get], poll[1] + 1);
                    }
                }
            }
        }
    }
}

// 1033
// 1033 ... 9033
//