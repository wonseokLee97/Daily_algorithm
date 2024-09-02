package com.ssafy._2024_07.BJ_19535_ㄷㄷㄷㅈ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int visited[], ans, visited2[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        long d = 0;
        long g = 0;

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited2 = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            List<Integer> parentNextNodes = graph.get(i);
            long parentSize = parentNextNodes.size();

            // 'ㅈ' 찾기
            if (parentNextNodes.size() >= 3) {
                g += (parentSize * (parentSize - 1) * (parentSize - 2)) / 6;
            }

            // 'ㄷ' 찾기
            visited2[i] = 1;
            for (int nextNode : parentNextNodes) {
                long childSize = graph.get(nextNode).size();

                if (visited2[nextNode] == 0) {
                    d += (childSize - 1) * (parentNextNodes.size() - 1);
                }
            }
        }

        if (d > g * 3) {
            System.out.println("D");
        } else if (d < g * 3) {
            System.out.println("G");
        } else {
            System.out.println("DUDUDUNGA");
        }
    }

    static void comb(int start, int cnt, int size) {
        if (cnt == 3) {
            ans++;
            return;
        }

        for (int i = start; i < size; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            comb(i, cnt + 1, size);
            visited[i] = 0;
        }
    }
}


// 시작 정점을 포함 4 개의 정점을 거친다. 'ㄷ'
// 시작 정점을 포함 3개만 거쳤는데 더 이상 갈 곳이 없다면 'ㅈ'

//8
//1 2
//2 3
//3 4
//4 5
//4 6
//4 7
//7 8