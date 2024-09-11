package com.ssafy._2024._04.BJ_1010_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long site = 1;
            for (int i = 0; i < N; i++) {
                site *= M - i;
                site /= 1 + i;
            }

            System.out.println(site);
        }
    }
}


// N개의 서쪽 사이트
// M개의 동쪽 사이트
// 문제에서 요구하는 바에 따르면 N개의 사이트는 모두 사용해야 한다.
// 그렇다는 것은 M개의 사이트 중, N개의 사이트를 모두 연결하는 경우를 구해야함.
// M개의 사이트 중 N개의 사이트를 뽑으면 된다.
// mCn

// 5!/3!*2!
// 5 4 3 2 1
// 3 2 1 2 1
