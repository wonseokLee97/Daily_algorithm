package com.ssafy._2023_06.day_06_15;

import java.util.*;
import java.io.*;


public class BJ_1005_ACM_Craft
{
    static List<List<Integer>> graph;
    static Queue<Integer> q;
    static int arr[], inza[], result[];

    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int ans = 0;

            arr = new int[N + 1];
            inza = new int[N + 1];
            result = new int[N + 1];
            graph = new ArrayList<>();
            q = new LinkedList<>();

            // 소요 시간
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int put = Integer.parseInt(st.nextToken());
                arr[i] = put;
                result[i] = put;
            }

            // 그래프 초기화
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

//            for (List<Integer> list : graph) {
//                System.out.println(list.toString());
//            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                graph.get(X).add(Y);
                inza[Y]++;
            }


            int W = Integer.parseInt(br.readLine());


            for (int i = 1; i <= N; i++) {
                if (inza[i] == 0) {
                    q.add(i);
                }
            }



            while(!q.isEmpty()) {
                int now_node = q.poll();

                List<Integer> list = graph.get(now_node);

                // 다음 건물 누적합 = Math.max(다음 값 ,지금 건물 + 다음 건물이 지어지는 시간)
                for (int next_node : list) {
                    result[next_node] = Math.max(result[next_node], result[now_node] + arr[next_node]);

                    if (--inza[next_node] == 0) {
                        q.add(next_node);
                    }
                }
            }

            System.out.println(result[W]);
        }
    }
}

// 1
// 4 4
// 10 1 100 10
// 1 2
// 1 3
// 2 4
// 3 4
// 4

// 1
// 8 8
// 10 20 1 5 8 7 1 43
// 1 2
// 1 3
// 2 4
// 2 5
// 3 6
// 5 7
// 6 7
// 7 8
// 7

// []
// [10]
// [30]
// [30]
// [35]
// [38]
// [37]
// [39]

// 7 - 6 - 3 - 1 : 1 + 7 + 30 -> 38
// 7 - 5 - 2 - 1 : 1 + 8 + 30 -> 39