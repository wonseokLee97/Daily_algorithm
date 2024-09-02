package com.ssafy._2024_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class L {
    int S;
    int E;

    public L(int s, int e) {
        S = s;
        E = e;
    }
}

public class BJ_2170_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        L[] arr = new L[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arr[i] = new L(S, E);
        }

        Arrays.sort(arr, new Comparator<L>() {
            @Override
            public int compare(L o1, L o2) {
                if (o1.S == o2.S) {
                    return o1.E - o2.E;
                }

                return o1.S - o2.S;
            }
        });

        int start = arr[0].S;
        int end = arr[0].E;
        int l = 0;

        for (int i = 1; i < N; i++) {
            if (end < arr[i].S) {
                l += end - start;
                start = arr[i].S;
            }

            // 길이의 연장
            if (end < arr[i].E) {
                end = arr[i].E;
            }
        }

        l += end - start;

        System.out.println(l);
    }
}


// 1   3
//   2       5
//     3     5
//              6  7