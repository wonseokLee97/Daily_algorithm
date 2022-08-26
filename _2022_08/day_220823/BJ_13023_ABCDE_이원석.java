package com.ssafy.day_220823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class BJ_13023_ABCDE_이원석 {
    static int cnt = 1, flag = 0, a;
    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        graph = new ArrayList[a];

        for (int i = 0; i < a; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        visited = new int[a];

        for (int i = 0; i < a; i++) {
            dfs(i);
            if (flag == 1) {
                System.out.println(1);
                break;
            }
        }

        if (flag == 0) {
            System.out.println(0);
        }
    }

    public static void dfs(int from) {
//        ArrayList<Integer> get = graph[from];

        if (cnt == 5) {
            flag = 1;
            return;
        }

        for (int to : graph[from]) {
            if (visited[to] == 0) {
                visited[from] = 1;
                cnt++;
                dfs(to);
                visited[from] = 0;
                cnt--;
                if (flag == 1) {
                    return;
                }
            }
        }
    }
}

// A-B, B-C, C-D, D-A, B-E
// A-B, B-C,E ,C-D, D-A


// 0 - 1
// 1 - 2 4
// 2 - 3
// 3 - 0

//if (get.size() == 1) {
//        System.out.println(from + ", " + to + ", " + check);
//        dfs(to);
//        } else {
//        if (visited[to] == 1) {
//        continue;
//        }
//        System.out.println(from + ", " + to + ", " + check);
//        dfs(to);
//        }