package com.ssafy.day_220825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10971_외판원순회2_이원석 {
    static int[] visited;
    static int N, cnt, min_val = Integer.MAX_VALUE;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            visited = new int[N];
            visited[i] = 1;
            cnt = 0;
            dfs(i, i, 0);
        }

        System.out.println(min_val);
    }

    public static void dfs(int start, int origin_start, int cost) {
        if (cnt == N - 1) { // 다 돌았다면,
            if (arr[start][origin_start] == 0) { // 시작점으로 갈 수 없다면,
                return;
            }
            min_val = Math.min(cost + arr[start][origin_start], min_val); // 마지막 정점에서
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1 || arr[start][i] == 0) {
                continue;
            }

            cnt++;
            visited[i] = 1;
            dfs(i, origin_start, cost + arr[start][i]);
            visited[i] = 0;
            cnt--;
        }
    }
}


//4
//0 1 0 0
//0 0 1 0
//0 0 0 1
//1 0 0 0


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BJ_10971_외판원순회2_이원석 {
//    static int n;
//    static boolean[] visited;
//    static int[][] map;
//    static long result_min = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//
//        map = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                map[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for(int i=0; i<n; i++) {
//            visited = new boolean[n];
//            visited[i] = true;
//            dfs(i, i, 0);
//        }
//        System.out.println(result_min);
//    }
//
//    public static void dfs(int start, int now, long cost){
//        if (allVisited()) {
//            if(map[now][start]!=0){
//                result_min = Math.min(result_min, cost+map[now][0]);
//            }
//            return;
//        }
//
//        for(int i=1; i<n; i++){
//            if (!visited[i] && map[now][i] != 0) {
//                visited[i] = true;
//                dfs(start, i, cost + map[now][i]);
//                visited[i] = false;
//            }
//        }
//    }
//
//    public static boolean allVisited() {
//        for (int i = 0; i < n; i++) {
//            if (!visited[i]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
//4
//0 1 2 0
//1 0 2 0
//0 0 0 3
//0 2 0 0