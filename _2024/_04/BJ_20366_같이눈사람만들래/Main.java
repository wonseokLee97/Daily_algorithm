package com.ssafy._2024._04.BJ_20366_같이눈사람만들래;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 투 포인터

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int min_val = Integer.MAX_VALUE;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2 3 5 5 9
        Arrays.sort(arr);

        // 엘자는 [i, j]를 먼저 고른다.
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                // 안나는 [s, e]를 뒤에 고른다.
                int s = 0;
                int e = N - 1;

                while (s < e) {
                    // 엘자와 겹치는 경우
                    if (s == i || s == j) {
                        s++;
                        continue;
                    }
                    if (e == i || e == j) {
                        e--;
                        continue;
                    }

                    int elsa = arr[j] + arr[i];
                    int anna = arr[e] + arr[s];

//                    System.out.println(i + ", " + j + " - " + elsa);
//                    System.out.println(s + ", " + e + " - " + anna);
//                    System.out.println();

                    min_val = Math.min(min_val, Math.abs(elsa - anna));

                    // 안나가 더 크면 줄이자.
                    if (anna > elsa) {
                        e--;
                    } else if (anna < elsa) { // 안나가 더 작으면 키우자.
                        s++;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(min_val);
    }
}
