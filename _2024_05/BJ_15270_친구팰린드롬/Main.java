package com.ssafy._2024_05.BJ_15270_친구팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 분류: dfs 백트래킹
 */

public class Main {
    static int N, M, visited[], ans;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = Integer.MIN_VALUE;

        visited = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(0, 1);

        if (ans < N) ans++;

        System.out.println(ans);
    }

    // cnt: 짝이된 인원 수
    // now: 현재 친구
    static void dfs(int cnt, int now) {
        ans = Math.max(ans, cnt);
        if (now >= N) {
            return;
        }

        // 현재 친구가 짝이 있다면 다음 사람
        if (visited[now] == 1) {
            dfs(cnt, now + 1);
            return;
        }

        visited[now] = 1;
        // find 를 기준으로 친한 친구 list
        List<Integer> list = graph.get(now);
        for (int next : list) {
            if (visited[next] == 1) {
                continue;
            }

            visited[next] = 1;
            // 짝이되므로 +2, 현재 친구(now)를 기준으로 다음 사람
            dfs(cnt + 2, now + 1);
            visited[next] = 0;
        }
        visited[now] = 0;

        // 현재 친구(now)의 탐색이 끝났다면 다음 친구
        dfs(cnt, now + 1);
    }
}



// A-B, B-C

// A와 B가 친한 친구고, B와 C가 친한 친구라고해서 반드시 A와 C가 친한 친구는 아니다.
// 로봇 댄스를 추는 친구를 제외한 무대에 올라가는 친구들은
// 모두 각자 자신과 친한 친구하고만 춤을 춰야한다.
// 또한 재홍이 반 친구들은 모두 로봇 댄스를 출 수 있다.

// A B C
// 3 3
// 1 2
// 2 3
// 3 1

// 1 2 3 4 친구가 있을 때 1-2, 3-4가 친하다면 모두 올려도 됨
// 1 2 3 4 5 친구가 있을 때 1-2, 3-4, 4-5가 친하다면
// 3 1 5 2 4

// N이 홀수이면, 로봇댄스를 출 수 있는 친구가 하나 있어야됨. 그 외에는 모두 짝댄스
// N이 짝수이면, 짝인 경우만 올라가야됨

// A B C

// 1 - 2, 3
// 2 - 1, 3
// 3 - 1, 2

//[]
//[2]
//[1, 3]
//[2, 4]
//[3, 5]
//[4, 6]
//[5]