package com.ssafy._2024_08.BJ_14675_단절점과_단절선;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 단절점인가?
            if (t == 1) {
                List<Integer> list = graph.get(k);
                if (list.size() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            // 단절선인가?
            else {
                System.out.println("yes");
            }
        }
    }
}

// 단절점: 해당 정점이 갈 수 있는 다음 정점이 2개 이상인 경우
// 단절선

// 다음 줄에는 질의의 개수 q가 주어진다. (1 ≤ q ≤ 100,000)
// 다음 q줄에는 질의 t k가 주어진다. (1 ≤ t ≤ 2)
// t가 1일 때는 k번 정점이 단절점인지에 대한 질의,
// t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지에 대한 질의이다.

// t가 1일 때는 (1 ≤ k ≤ n)이며, t가 2일 때는 (1 ≤ k ≤ n - 1)이다.