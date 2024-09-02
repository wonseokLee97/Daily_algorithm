package com.ssafy._2024_08.BJ_2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 두 공유기 사이의 최소 거리
        int s = 1;
        // 최대 거리
        int e = arr[N - 1];
        int d = arr.length;
        int answer = 0;

        while (s <= e) {
            // 최대거리 m을 넘어야한다!
            int m = (s + e) / 2;
            int before = arr[0];
            // 설치할 공유기 수
            int cnt = 1;


            for (int i = 1; i < d; i++) {
                // 시작지점부터 공유기까지의 거리가 m(최대거리)보다 크다면
                if (arr[i] - before >= m) {
                    // 설치하자
                    cnt++;
                    before = arr[i];
                }
            }

//            System.out.println(s + ", " + e + ", " + m + ", cnt: " + cnt);

            // m이 작으면 공유기를 많이 설치하게됨

            // 선택한 공유기의 수가 C보다 작다면 m을 줄이자. 그래야 공유기를 많이 설치한다.
            if (cnt < C) {
                e = m - 1;
            }
            // 선택한 공유기의 수가 C보다 크다면 m을 늘이자. 그래야 공유기를 적게 설치한다.
            else {
                s = m + 1;
                answer = m;
            }
        }

        System.out.println(e);
    }
}

// upperbound
// m  1  2  3  4  5  6  7 ...
// n     3  3  2  2

// 1   2   4   8   9
//   1   2   4   1
// 0부터 10억사이의 거리에 공유기를 설치한다.
// C개를 고를건데, C개 중 가장 인접한 두 공유기 사이의 거리를 최대로

// 가장 인접한 두 공유기 사이의 거리를 가능한 크게 하여 설치하려고 한다.
//5 3
//1
//2
//8
//4
//9