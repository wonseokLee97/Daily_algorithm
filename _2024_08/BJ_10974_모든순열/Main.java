package com.ssafy._2024_08.BJ_10974_모든순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, arr[], visited[];
    static List<String> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new int[N];
        list = new ArrayList<>();

        perm(0);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    static void perm(int cnt) {
        if (cnt == N) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i] + " ");
            }
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == 1) {
                continue;
            }

            visited[i] = 1;
            arr[i] = cnt + 1;
            perm(cnt + 1);
            visited[i] = 0;
            arr[i] = 0;
        }
    }
}
