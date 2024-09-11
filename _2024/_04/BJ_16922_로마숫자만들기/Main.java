package com.ssafy._2024._04.BJ_16922_로마숫자만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int N, visited[], ans, rome[] = {1, 5, 10, 50};
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[4];

        map = new HashMap<>();

        comb(0, 0);

        System.out.println(ans);
    }

    static void comb(int cnt, int start) {
        if (cnt == N) {
//            System.out.println(Arrays.toString(visited));

            int total = 0;
            for (int i = 0; i < 4; i++) {
                if (visited[i] != 0) {
                    total += rome[i] * visited[i];
                }
            }

            if (map.get(total) == null) {
                map.put(total, 1);
                ans++;
            }

            return;
        }

        for (int i = start; i < 4; i++) {
            visited[i] += 1;
            comb(cnt + 1, i);
            visited[i] -= 1;
        }
    }
}

// 2, 6, 11, 51, 10, 15, 55, 20, 60, 100

//  I, V, X, L

// 중복해서 선택할 수 있다. 순서에 상관없다. 중복조합